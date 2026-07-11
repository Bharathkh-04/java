package ArraysDemo;

import java.util.Arrays;
import java.util.Iterator;

public class LinearsearchStrings {
public static void main(String[] args) {

	System.out.println(Linear2(new String[] {"Ram","ashok", "bhuvi"},"ram"));
	System.out.println(searchcharstring5("bharath",'h'));
	
//	String s="ram";
//	char c[]=s.toCharArray();
//	System.out.println(Arrays.toString(c));
}
static String Linear1(String[] arr,String target)
{
	
	for (int i = 0; i < arr.length; i++) {
		if(arr[i].equals(target))
		{
			return "Index found"+i;
		}
	}
	return "string not found";
}

static String Linear2(String[] arr,String target)
{
	target=target.toLowerCase();
	for (int i = 0; i < arr.length; i++) {
		if(arr[i].toLowerCase().equals(target))
		{
			return "Index found"+i;
		}
	}
	return "string not found";
}

static boolean searchcharinstring(String str,char target)
{
	char ch[]=new char[str.length()];
	for(int i=0;i<str.length();i++)
	{
		ch[i]=str.charAt(i);
		if(ch[i]==target)
			return true;
	}
	return false;
}
static boolean searchcharstring2(String str,char target)//boolean return type
{
	char c[]=str.toCharArray();
	for (int i = 0; i < c.length; i++) {
		if(c[i]==target)
			return true;
	}
	return false;
	//System.out.println(Arrays.toString(c));
}
static String searchcharstring3(String str,char target)
{
	char c[]=str.toCharArray();//strore string into a character array
	for (int i = 0; i < c.length; i++) {
		if(c[i]==target)//compare each element in char array with target
			return "found at index"+ i;
	}
	return "not found";
	//System.out.println(Arrays.toString(c));
}

static boolean searchcharstring4(String str,char target)
{
	for (int i = 0; i < str.length(); i++) {
		if(str.charAt(i)==target)//compare current character in string with target
			return true;
	}
	return false;
}
static boolean searchcharstring5(String str,char target)
{
	for (int ch:str.toCharArray()) {
		if(ch==target)//compare current character in string with target
			return true;
	}
	return false;
}
}
