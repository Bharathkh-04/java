package ArraysDemo;

public class maxwealth {
public static void main(String[] args) {
	int a[][]= {
			{1,5},
			{7,3},
			{3,5}
	};
	int nums[]= {12,345,2,6,-23,7896};
	System.out.println(counteven(nums));
	//System.out.println(sum(a));
}

static int sum(int arr[][])
{	int max=Integer.MIN_VALUE;
	for(int i=0;i<arr.length;i++)
	{int sum=0;
	
		for(int j=0;j<arr[i].length;j++)
		{
			sum+=arr[i][j];
			
		}
		if(sum>max)
		{
			max=sum;
		}
	}
	return max;
}

static int counteven(int arr[])
{	int countev=0;
	int countodd=0;
	for(int a:arr)
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
