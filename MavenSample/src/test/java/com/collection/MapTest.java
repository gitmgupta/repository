package com.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void HashMapTest() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "Manish");
		map.put(2, "Rajesh");
		map.put(null, "Values");
		map.put(null, null);
		map.put(3, "Manish");

		Set set = map.entrySet();
		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

	public static void HashTableTest() {
		Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
		  
		  hm.put(100,"Amit");  
		  hm.put(102,"Ravi");  
		  hm.put(101,"Vijay");  
		  hm.put(103,"Rahul");  
		  hm.put(104, "Rahul");
		 // hm.put(null,"null");
		  
		  for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		  System.out.println("============================");
		  hm.remove(101);
		  
		  for(Map.Entry m:hm.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			  }  
		 
	}
	
	
	public static void test() {
		int i = 10;
		i=i++ + i;
		System.out.println("First level: "+i);
		System.out.println("Second level:" + i++);
		System.out.println("Second level:" + i);
	}
	
	public static void main(String[] args) {
		HashTableTest();
	}
}
