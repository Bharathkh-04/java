import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int r=sc.nextInt();
    int a[][]=new int[r][r];
    int sum=0,secdia=0;
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<r;j++)
        {
            a[i][j]=sc.nextInt();
        }
    }
    for(int i=0;i<r;i++)
    {
        sum+=a[i][i];
    }//System.out.println(sum);
    for(int i=0;i<r;i++)
    {
        secdia+=a[i][r-1-i];
    }//System.out.println(secdia);
    int difference=Math.abs(secdia-sum);
        System.out.println(difference);
    }
}
