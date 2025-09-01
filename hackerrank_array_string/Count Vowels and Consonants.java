import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        int vowel=0;
        int consonant=0;
        s=s.toLowerCase();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i'|| s.charAt(i)=='o' || s.charAt(i)=='u' ) vowel++;
            else if((s.charAt(i)!='a' || s.charAt(i)!='e' ||s.charAt(i)!='i' || s.charAt(i)!='o' ||s.charAt(i)!='u') && (s.charAt(i)>97 && s.charAt(i)<123)) consonant++;
        }System.out.print(vowel+" "+consonant);
    }
}
