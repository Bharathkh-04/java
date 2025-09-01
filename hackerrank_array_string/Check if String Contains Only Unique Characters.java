import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        boolean flag=false;
        int character[]=new int[256];
        for(int i=0;i<n;i++)
            character[s.charAt(i)]++;
        for(int i=0;i<n;i++)
        {
            if(character[s.charAt(i)]>1)
            {
                //System.out.print(s.charAt(i));
                flag=true;
                character[s.charAt(i)]=0;
            }
        }
        if(flag)
            System.out.println("No");
        else
            System.out.println("Yes");
    
    }
}
