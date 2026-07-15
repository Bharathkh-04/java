package binarysearch;

public class ceiling {
public static void main(String[] args) {
	int tar=1;
	int arr1[]= {2,3,5,9,14,15,17,18};
	char a[]= {'x','x','y','y'};
	char target='z';
	System.out.println(floor(arr1,tar));
	System.out.println(ceil1(a,target));
}
static int ceil(int arr[],int target)
{
	if (target > arr[arr.length - 1]) {
        return Integer.MIN_VALUE; // No ceiling exists
    }
	int start=0;
	int stop=arr.length-1;
	while(start<stop)
	{
		int mid=start+(stop-start)/2;
		if(arr[mid]==target)
		{
			return arr[mid];
		}
		else if(arr[mid]<target)
		{
			start=mid+1;
		}
		else
		{
			stop=mid;
		}
	}
	return arr[start];
}
static int floor(int arr[],int target)
{
	if (target<arr[0]) {
        return -1; // No ceiling exists
    }
	int start=0;
	int stop=arr.length-1;
	while(start<=stop)
	{
		int mid=start+(stop-start)/2;
		if(arr[mid]==target)
		{
			return arr[mid];
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
	return arr[stop];
}
static char ceil1(char arr[],char target)
{
	if (target > arr[arr.length - 1]) {
        return arr[0]; // No ceiling exists
    }
	int start=0;
	int stop=arr.length-1;
	while(start<stop)
	{
		int mid=start+(stop-start)/2;
		if(arr[mid]==target)
		{
			return arr[mid];
		}
		else if(arr[mid]<target)
		{
			start=mid+1;
		}
		else
		{
			stop=mid;
		}
	}
	return arr[start];
}
}
