import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int a[][]=new int[r][c];
        int temp[][]=new int[c][r];
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
              temp[j][i]=a[i][j]; 
           
            }
        }
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                System.out.print(temp[i][j]+" ");
            }System.out.println();
        }
    }
}
