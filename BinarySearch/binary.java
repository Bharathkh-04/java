package binarysearch;

public class binary {
public static void main(String[] args) {
	//int arr[]= {1,2,3,78,89,98,102,105,203,304};
	
	int arr[]= {304,203,105,102,98,89,78,3,2,1};
	//int start=0;
	int target=3;
	System.out.println(bin(arr,target));
//	int stop=arr.length-1;
//	boolean found=false;
//	
//	while(start<=stop)
//	{ int mid=(start+stop)/2;
//		
//	if(arr[mid]==target)
//	{
//		System.out.println("element found at "+mid);
//		found=true;
//		break;
//	}
//	else if(target>arr[mid])
//		{
//		stop=mid-1;
//		}
//		else if(target<arr[mid])
//		{
//			start=mid+1;
//		}
//		
//		
//	}
//	if(!found)//intially false apro true ah change agiruch then (!true)==> false  ==>  if(false)dont execute if(true) then execute
//	{
//	System.out.println("not found");
//	}
	
}

static int bin(int arr[],int target)
{
	int start=0;
	int stop=arr.length-1;
	
	if(arr[0]<arr[arr.length-1])
	{
		while(start<=stop)
		{
			int mid=start+(stop-start)/2;
			if(target<arr[mid])
			{
				stop=mid-1;
			}
			else if(target>arr[mid])
			{
				start=mid+1;
			}
			else
				return mid;
		}
	}
	else
	{
	while(start<=stop)
	{
		int mid=start+(stop-start)/2;
		if(target>arr[mid])
		{
			stop=mid-1;
		}
		else if(target<arr[mid])
		{
			start=mid+1;
		}
		else
			return mid;
	}
	}
	return -1;
}
}
