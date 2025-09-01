import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        s=s.toLowerCase();
        boolean flag=true;
        for(int i=0;i<n;i++)
        {
            if(!(s.charAt(i)>'0' && s.charAt(i)<'9'))
            {
            flag=false;
            break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
