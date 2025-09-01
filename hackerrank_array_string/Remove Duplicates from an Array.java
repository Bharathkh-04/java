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
        for(int i=0;i<n;i++)
        {
            boolean duplicate=false;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
