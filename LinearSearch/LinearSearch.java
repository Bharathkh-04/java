package ArraysDemo;

public class LinearSearch {
public static void main(String[] args) {
	LinearSearch obj=new LinearSearch();
	
	//System.out.println(obj.Linear(new int[]{2,2,3,4},4));
	System.out.println(obj.linear1(new int[]{2,2,3,4},4));
	System.out.println(linear6(new int[] {22,45,56,34,3,4},89));
}

public int linear1(int arr[],int search)
{	int temp=search;
	for(int i=0;i<arr.length;i++)
	{
		if(temp==arr[i])
		{
			return i;
		}
	}
	return -1;
}

public int linear2(int arr[],int search)
{
	for(int num:arr)
	{
		if(search==num)
		{
			return num;//to print number or element
		}
	}
	return -1;
}

public int linear3(int arr[],int search)
{
int index=0;
for(int num:arr)
{
	if(search==num)
	{
		return index;//to return the index using for each loop
	}
	index++;
}
return -1;
}

static int linear4(int arr[],int target)//static method no need for creation of object
{
	if(arr.length==0)
	{
		return -1;
	}
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]==target)
			return i;
	}
	return -1;
}
static boolean linear5(int arr[],int target)//static method no need for creation of object
{
	if(arr.length==0)
	{
		return false;
	}
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]==target)
			return true;
	}
	return false;
}
static int linear6(int arr[],int target)//static method no need for creation of object
{
	if(arr.length==0)
	{
		return Integer.MAX_VALUE;//instead of -1 ipo -1 dhan target value ah iruntha ? so Integer.max_value pota minimum integer value return agum
	}
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]==target)
			return i;
	}
	return Integer.MAX_VALUE;
}
}
