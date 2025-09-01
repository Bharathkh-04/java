class Solution {
    public String toggleCase(String s) {
        // code here
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            ans+=(char)(s.charAt(i)-32);
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            ans+=(char)(s.charAt(i)+32);
        }return ans;
    }
}
