package ArraysDemo;

public class minnumber {
public static void main(String[] args) {
	int a[]= {56,34,23,90,22,-1};
	System.out.println(Minimum(a));
}
static int Minimum(int arr[])
{
	int min=arr[0];
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i]<min)
			min=arr[i];
	}
	return min;
}
}
