package ArraysDemo;

import java.util.HashMap;
import java.util.Map;


public class morethan25percent {
public static void main(String[] args) {
	int arr[]= {1,2,2,6,6,6,6,7,10};
	HashMap<Integer,Integer> map=new HashMap<>();
	for(int num:arr)
	{
		if(map.containsKey(num))
		{
			map.put(num,map.get(num)+1);
		}
		else
			map.put(num,1);
	}
//	for (int key : map.keySet()) {
//	    System.out.println(key + " -> " + map.get(key));
//	    if((map.get(key))/arr.length>=0.25)
//{
//	System.out.println(map);
//}
//	}
//	System.out.println(map);
//	
	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

	    if (entry.getValue() > arr.length / 4) {
	        System.out.println( entry.getKey());
	    }
	}

	//System.out.println(-1);
}
}

