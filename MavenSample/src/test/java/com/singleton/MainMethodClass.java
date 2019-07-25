package com.singleton;

public class MainMethodClass {
	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		x.s = (x.s).toUpperCase(); 
		System.out.println(x.s + " "+ x.count);
		System.out.println(y.s + " "+ x.count);
		System.out.println(z.s + " "+ x.count);

		
	}
}
