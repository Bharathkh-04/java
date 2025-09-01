import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            System.out.print(s.charAt(i)+" ");
        }
    }
}
