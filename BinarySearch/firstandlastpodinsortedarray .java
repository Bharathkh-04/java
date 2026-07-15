package binarysearch;

import java.util.Arrays;

public class firstandlastpodinsortedarray {
public static void main(String[] args) {
	
	int arr[]= {5,7,7,8,8,10};
	int target=6;
	System.out.println(Arrays.toString(searchRange(arr,target)));
}
public static int[] searchRange(int[] nums, int target) {
	return new int[] {first(nums,target),last(nums,target)};
	
}
static int first(int arr[],int target)
{
	int start=0;
	int stop=arr.length-1;
	int ans=-1;
	while(start<=stop)
	{
		int mid=start+(stop-start)/2;
		if(arr[mid]==target)
		{
			ans=mid;
			stop=mid-1;
		}
		else if(arr[mid]<target)
		{
			start=mid+1;
		}
		else
		{
			stop=mid-1;
		}
	}
	return ans;
}
static int last(int arr[],int target)
{
	int start=0;
	int stop=arr.length-1;
	int ans=-1;
	while(start<=stop)
	{
		int mid=start+(stop-start)/2;
		if(arr[mid]==target)
		{
			ans=mid;
			start=mid+1;
		}
		else if(arr[mid]<target)
		{
			start=mid+1;
		}
		else
		{
			stop=mid-1;
		}
	}
	return ans;
}
}
