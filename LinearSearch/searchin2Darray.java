package ArraysDemo;

import java.util.Arrays;
import java.util.Iterator;

public class searchin2Darray {
public static void main(String[] args) {
	int arr[][]= {
			{2,4,5,6},
			{34,56,232},
			{12,65,34,23,59,89}
	};
	System.out.println(Arrays.toString(search2d(arr,23)));
	System.out.println(Max(arr));
}

static int[] search2d(int arr[][],int target)
{
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0;  j<arr[i].length; j++) {
			if(arr[i][j]==target)
			{
				return new int[] {i,j};
			}
		}
	}
	return new int [] {-1,-1};
}
static int Max(int arr[][])
{ int max=arr[0][0];
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0;  j<arr[i].length; j++) {
			if(arr[i][j]>=max)
			{
				max=arr[i][j];
			}
		}
	}
	return max;
}
}
