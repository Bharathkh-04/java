package binarysearch;

import java.util.Arrays;

public class specialnum {
public static void main(String[] args) {
	int arr[][]= {
			{1,0,0},
			{0,0,1},
			{1,0,0}
	};
	int arrr[][]= {
			{0,0,0,1},
			{1,0,0,0},
			{0,1,1,0},
			{0,0,0,0}
	};

System.out.println(numSpecial(arrr));
}
static int numSpecial(int[][] arr) {
	
	
	
	int rowcount[]=new int[arr.length];
	int colcount[]=new int[arr[0].length];
	for(int i=0;i<arr.length;i++)
	{int count=0;
		for(int j=0;j<arr[i].length;j++)
		{
			if(arr[i][j]==1)
			{
				count++;
			}
			
		}rowcount[i]=count;
	}
	for (int j = 0; j < arr[0].length; j++) {
		int c=0;
	    for (int i = 0; i < arr.length; i++) {
	        if(arr[i][j]==1)
	        {
	        c++;	
	        }
	    }
	    colcount[j]=c;
	    
	}
	int ans=0;
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[0].length;j++)
	{
		if(rowcount[i]==1 && colcount[j]==1 && arr[i][j]==1)
		{
			ans++;
		}
	}
	
	}
//	System.out.println(ans);
//	System.out.println(Arrays.toString(colcount));
//	System.out.println(Arrays.toString(rowcount));
	return ans;
}
}
