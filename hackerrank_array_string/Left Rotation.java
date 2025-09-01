import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int d=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        //int b=0;
        while(d>0)
        {
        int temp=a[0];
        for(int i=1;i<n;i++)
        {
            a[i-1]=a[i];
            
        }
        a[n-1]=temp;
        d--;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
