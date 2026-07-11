class Solution {  //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    public int findNumbers(int[] nums) {
        int countev=0;
	int countodd=0;
	for(int a:nums)
	{
	int digits = (int) Math.log10(a) + 1;
	if(digits%2==0)
	{
		countev++;
	}
	else
		countodd++;
	}
	return countev;
    }
}
