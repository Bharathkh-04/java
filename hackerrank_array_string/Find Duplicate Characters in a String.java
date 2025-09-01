import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int character[]=new int[256];
        String s=sc.nextLine();
        int n=s.length();
//         char ch[]=s.toCharArray();
//         boolean flag=false;
       
//         for(int i=0;i<n;i++)
//         {  char character=ch[i];
//           int count=0;
//           for(int j=i+1;j<n;j++)
//           {
//               if(ch[j]==character)
//               {
//                    count++;
//                   System.out.print(character+" ");
//                   flag=true;
//                   break;
//                }
              
//           }
             
//         }
//         if(flag!=true)
//         {
//             System.out.println("No duplicates");
//         }
        boolean flag=false;
        for(int i=0;i<n;i++)
            character[s.charAt(i)]++;
        for(int i=0;i<n;i++)
        {
            if(character[s.charAt(i)]>1)
            {
                System.out.print(s.charAt(i)+" ");
                flag=true;
                character[s.charAt(i)]=0;
            
            }
                
        }
        if(flag!=true)
            System.out.println("No duplicates");
            
    }
}
