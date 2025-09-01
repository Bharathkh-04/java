import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        char ch=sc.next().charAt(0);
        int count=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(arr[i]==ch)count++;
        }System.out.println(count);
    }
}
