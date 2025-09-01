import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
           if (n > 1) { 
            int temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
