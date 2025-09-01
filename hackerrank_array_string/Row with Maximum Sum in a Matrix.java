import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int sum=0;
        int max=Integer.MIN_VALUE;
        boolean flag=false;
        int index=0;
        int a[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                sum+=a[i][j];
            }
            if(sum>max)
            {
                max=sum;
                index=i;
                flag=true;
            }
        }
        if(flag==true)
        {
        System.out.println(index+1);
        }
    }
}
