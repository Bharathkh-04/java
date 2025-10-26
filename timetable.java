package timetable;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import java.awt.event.*;
import java.io.*;
import java.util.*;


public class time extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTabbedPane tabbedPane;
    private Map<String, DefaultTableModel> classTables;
    private Map<String, String> teacherSubject = new LinkedHashMap<>();
    private Map<String, Integer> teacherWeeklyLimit = new HashMap<>(); // remaining load during generation
    private Map<String, Integer> teacherTotalLimit = new HashMap<>(); // original limits
    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] periods = {"P1", "P2", "P3", "P4 (LUNCH)", "P5", "P6", "P7"};
    private java.util.List<String> classes = Arrays.asList("Class A", "Class B", "Class C");
    private Random rand = new Random();

    public time() {
        setTitle("Timetable Generator - Enhanced");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sample teachers and their subjects + weekly limits (change as needed)
        teacherSubject.put("Mr. Arun", "Math");
        teacherSubject.put("Ms. Balaprabha", "Science");
        teacherSubject.put("Mr. Chezhiyan", "English");
        teacherSubject.put("Ms. Rajalakshmi", "Computer");
        teacherSubject.put("Mr. Raja", "History");
        teacherSubject.put("Mr. Kumar", "Math");
        teacherSubject.put("Mr. Murugesan", "Science");
        teacherSubject.put("Mr. Kumaran", "English");
        teacherSubject.put("Mr. Chinnamuthu", "Computer");
        teacherSubject.put("Mr. Ram", "History");
        teacherSubject.put("Mr. Kumaresan", "Math");
        teacherSubject.put("Mr. Murugan", "Science");
        teacherSubject.put("Mr. Kannan", "English");
        teacherSubject.put("Mr. Muthu", "Computer");
        teacherSubject.put("Mr. Raman", "History");
        

        // weekly limits (max periods per week)
        teacherTotalLimit.put("Mr. Arun", 10);
        teacherTotalLimit.put("Ms. Balaprabha", 8);
        teacherTotalLimit.put("Mr. Chezhiyan", 9);
        teacherTotalLimit.put("Ms. Rajalakshmi", 7);
        teacherTotalLimit.put("Mr. Raja", 6);
        teacherTotalLimit.put("Mr. Kumar", 8);
        teacherTotalLimit.put("Mr. Kumaran", 12);
        teacherTotalLimit.put("Mr. Murugesan", 8);
        teacherTotalLimit.put("Mr. Chinnamuthu", 15);
        teacherTotalLimit.put("Mr. Ram", 10);
        teacherTotalLimit.put("Mr. Kumaresan", 8);
        teacherTotalLimit.put("Mr. Murugan", 12);
        teacherTotalLimit.put("Mr. Kannan", 8);
        teacherTotalLimit.put("Mr. Muthu", 15);
        teacherTotalLimit.put("Mr. Raman", 10);

        // initialize remaining limits equal to totals
        resetTeacherWeeklyLimit();

        // Top heading
        JLabel heading = new JLabel("Timetable Generator", JLabel.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(heading, BorderLayout.NORTH);

        // Tabbed pane for classes
        tabbedPane = new JTabbedPane();
        classTables = new HashMap<>();
        for (String cls : classes) {
            DefaultTableModel model = createTableModel();
            classTables.put(cls, model);
            JTable table = new JTable(model);
            styleTable(table);
            JScrollPane pane = new JScrollPane(table);
            tabbedPane.addTab(cls, pane);
        }
        add(tabbedPane, BorderLayout.CENTER);

        // Buttons
        JPanel bottom = new JPanel();
        JButton btnGenerateAll = new JButton("Generate All Timetables");
        btnGenerateAll.addActionListener(e -> {
            resetTeacherWeeklyLimit();
            generateAllTimetables();
        });

        JButton btnViewTeacher = new JButton("View Teacher Timetable");
        btnViewTeacher.addActionListener(e -> showTeacherTimetableDialog());

        JButton btnSaveCSV = new JButton("Save Current Class as CSV");
        btnSaveCSV.addActionListener(e -> saveCurrentTabAsCSV());

        bottom.add(btnGenerateAll);
        bottom.add(btnViewTeacher);
        bottom.add(btnSaveCSV);

        add(bottom, BorderLayout.SOUTH);

        // Left control panel for dynamic edits (optional simple editor)
        add(createControlPanel(), BorderLayout.WEST);
    }

    private JPanel createControlPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(BorderFactory.createTitledBorder("Controls"));

        JLabel note = new JLabel("<html><small>Adjust teacher weekly limits below.<br>After changes, click 'Generate'.</small></html>");
        note.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(note);

        for (String teacher : teacherSubject.keySet()) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setAlignmentX(Component.LEFT_ALIGNMENT);
            row.add(new JLabel(teacher + " (" + teacherSubject.get(teacher) + "): "));
            JTextField tf = new JTextField(String.valueOf(teacherTotalLimit.get(teacher)), 3);
            row.add(tf);
            JButton setBtn = new JButton("Set");
            setBtn.addActionListener(evt -> {
                try {
                    int v = Integer.parseInt(tf.getText().trim());
                    if (v < 0) throw new NumberFormatException();
                    teacherTotalLimit.put(teacher, v);
                    resetTeacherWeeklyLimit();
                    JOptionPane.showMessageDialog(this, "Set " + teacher + " limit to " + v);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Enter valid non-negative integer");
                }
            });
            row.add(setBtn);
            p.add(row);
        }

        p.add(Box.createVerticalGlue());
        p.setPreferredSize(new Dimension(300, 0));
        return p;
    }

    private void resetTeacherWeeklyLimit() {
        teacherWeeklyLimit.clear();
        for (Map.Entry<String, Integer> e : teacherTotalLimit.entrySet()) {
            teacherWeeklyLimit.put(e.getKey(), e.getValue());
        }
    }

    private DefaultTableModel createTableModel() {
        String[] colNames = new String[periods.length + 1];
        colNames[0] = "Day";
        System.arraycopy(periods, 0, colNames, 1, periods.length);

        String[][] data = new String[days.length][colNames.length];
        for (int i = 0; i < days.length; i++) {
            data[i][0] = days[i];
            for (int j = 1; j < colNames.length; j++) {
                if (colNames[j].contains("LUNCH")) data[i][j] = "LUNCH";
                else data[i][j] = "";
            }
        }
        return new DefaultTableModel(data, colNames) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // non-editable cells for now
            }
        };
    }

    private void styleTable(JTable table) {
        table.setRowHeight(40);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(0, 120, 215));
        header.setForeground(Color.WHITE);

        // center day column, left others
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        // cell renderer to allow conflict highlighting (we'll mark conflicts by setting text starting with "!!CONFLICT!!")
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
                String text = value == null ? "" : value.toString();
                if (text.startsWith("!!CONFLICT!!")) {
                    setBackground(Color.PINK);
                    setForeground(Color.BLACK);
                    setText(text.replace("!!CONFLICT!!", "")); // show without prefix
                } else if ("LUNCH".equals(text)) {
                    setBackground(new Color(220, 220, 220));
                    setForeground(Color.BLACK);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setText(text);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                    setHorizontalAlignment(SwingConstants.LEFT);
                }
                return this;
            }
        });
    }

    private void generateAllTimetables() {
        // Clear all tables first (keep LUNCH)
        for (String cls : classes) {
            DefaultTableModel model = classTables.get(cls);
            for (int r = 0; r < model.getRowCount(); r++) {
                for (int c = 1; c < model.getColumnCount(); c++) {
                    if (!model.getColumnName(c).contains("LUNCH")) model.setValueAt("", r, c);
                }
            }
        }

        // For each class, assign teachers to periods respecting:
        // - teacherWeeklyLimit > 0
        // - teacher not busy same day/period (we schedule one class at a time globally so busy means same day/period across classes? here we avoid teacher double booking across classes)
        // We'll track global teacherBusy[day][period]
        Map<String, boolean[][]> teacherBusy = new HashMap<>();
        for (String teacher : teacherSubject.keySet()) {
            teacherBusy.put(teacher, new boolean[days.length][periods.length]);
        }

        // For each class, assign randomly but with constraints
        for (String cls : classes) {
            DefaultTableModel model = classTables.get(cls);

            // For each day reset dailySubjects to avoid same subject more than once a day in same class
            for (int d = 0; d < days.length; d++) {
                Set<String> dailySubjects = new HashSet<>();
                for (int p = 0; p < periods.length; p++) {
                    int col = p + 1;
                    String colName = model.getColumnName(col);
                    // Skip LUNCH
                    if (colName.contains("LUNCH")) {
                        model.setValueAt("LUNCH", d, col);
                        continue;
                    }

                    // Build available teacher list for this slot
                    List<String> avail = new ArrayList<>();
                    for (String teacher : teacherSubject.keySet()) {
                        String subj = teacherSubject.get(teacher);
                        // teacher must have remaining weekly load
                        Integer rem = teacherWeeklyLimit.getOrDefault(teacher, 0);
                        if (rem <= 0) continue;
                        // teacher must not be busy at this day/period (avoid double booking across classes)
                        if (teacherBusy.get(teacher)[d][p]) continue;
                        // subject not already assigned for this class this day
//                        if (dailySubjects.contains(subj)) continue;
                        avail.add(teacher);
                    }

                    if (avail.isEmpty()) {
                        // No suitable teacher — leave blank or mark conflict
                        model.setValueAt("!!CONFLICT!!UNASSIGNED", d, col);
                    } else {
                        // pick teacher weighted by remaining load (more remaining -> higher chance)
                        String pick = weightedPickByRemainingLoad(avail);
                        String subj = teacherSubject.get(pick);
                        model.setValueAt(subj + " (" + pick + ")", d, col);
                        // mark busy and decrement weekly load
                        teacherBusy.get(pick)[d][p] = true;
                        teacherWeeklyLimit.put(pick, teacherWeeklyLimit.get(pick) - 1);
                        dailySubjects.add(subj);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Timetables generated. Conflicts shown in pink or labeled 'UNASSIGNED'.");
    }

    private String weightedPickByRemainingLoad(List<String> avail) {
        // sum weights
        int total = 0;
        Map<String, Integer> w = new HashMap<>();
        for (String t : avail) {
            int weight = Math.max(1, teacherWeeklyLimit.getOrDefault(t, 1)); // at least 1
            w.put(t, weight);
            total += weight;
        }
        int r = rand.nextInt(total);
        for (String t : avail) {
            r -= w.get(t);
            if (r < 0) return t;
        }
        return avail.get(0);
    }

    private void showTeacherTimetableDialog() {
        // Build a map teacher -> table model
        Map<String, DefaultTableModel> teacherModels = new LinkedHashMap<>();
        for (String teacher : teacherSubject.keySet()) {
            String[] colNames = new String[periods.length + 1];
            colNames[0] = "Day";
            System.arraycopy(periods, 0, colNames, 1, periods.length);
            String[][] data = new String[days.length][colNames.length];
            for (int i = 0; i < days.length; i++) {
                data[i][0] = days[i];
                for (int j = 1; j < colNames.length; j++) data[i][j] = "";
            }
            teacherModels.put(teacher, new DefaultTableModel(data, colNames));
        }

        // Fill teacher models by scanning class tables
        for (String cls : classes) {
            DefaultTableModel cm = classTables.get(cls);
            for (int r = 0; r < cm.getRowCount(); r++) {
                for (int c = 1; c < cm.getColumnCount(); c++) {
                    Object val = cm.getValueAt(r, c);
                    if (val == null) continue;
                    String text = val.toString();
                    if (text.isEmpty() || text.startsWith("!!CONFLICT!!")) continue;
                    // expect "Subject (Teacher)"
                    int idx = text.lastIndexOf(" (");
                    if (idx > 0) {
                        String teacher = text.substring(idx + 2, text.length() - 1);
                        String subj = text.substring(0, idx);
                        DefaultTableModel tm = teacherModels.get(teacher);
                        if (tm != null) {
                            // append class info to cell
                            String prev = tm.getValueAt(r, c) == null ? "" : tm.getValueAt(r, c).toString();
                            if (!prev.isEmpty()) prev += " | ";
                            tm.setValueAt(prev + subj + " - " + cls, r, c);
                        }
                    }
                }
            }
        }

        // Create dialog with tabs for each teacher
        JTabbedPane tp = new JTabbedPane();
        for (Map.Entry<String, DefaultTableModel> e : teacherModels.entrySet()) {
            JTable table = new JTable(e.getValue());
            styleTable(table);
            tp.addTab(e.getKey() + " [" + teacherSubject.get(e.getKey()) + "]", new JScrollPane(table));
        }

        JOptionPane.showMessageDialog(this, tp, "Teacher Timetables", JOptionPane.PLAIN_MESSAGE);
    }

    private void saveCurrentTabAsCSV() {
        int idx = tabbedPane.getSelectedIndex();
        if (idx < 0) return;
        String cls = tabbedPane.getTitleAt(idx);
        DefaultTableModel model = classTables.get(cls);

        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File(cls + "_Timetable.csv"));
        int ret = chooser.showSaveDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION) return;
        File f = chooser.getSelectedFile();
        try (PrintWriter pw = new PrintWriter(f)) {
            // header
            for (int c = 0; c < model.getColumnCount(); c++) {
                pw.print(escapeCSV(model.getColumnName(c)));
                if (c < model.getColumnCount() - 1) pw.print(",");
            }
            pw.println();
            // rows
            for (int r = 0; r < model.getRowCount(); r++) {
                for (int c = 0; c < model.getColumnCount(); c++) {
                    Object val = model.getValueAt(r, c);
                    pw.print(escapeCSV(val == null ? "" : val.toString()));
                    if (c < model.getColumnCount() - 1) pw.print(",");
                }
                pw.println();
            }
            JOptionPane.showMessageDialog(this, "Saved CSV to: " + f.getAbsolutePath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    private String escapeCSV(String s) {
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            s = s.replace("\"", "\"\"");
            return "\"" + s + "\"";
        }
        return s;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            time app = new time();
            app.setVisible(true);
        });
    }
}

