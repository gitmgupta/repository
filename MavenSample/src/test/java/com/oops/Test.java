package com.oops;

import java.io.IOException;

public class Test { 
	
	String s = "";
	StringBuffer sbf = new StringBuffer();
	
    public static void main(String args[ ]) throws IOException  { 
    	Derived obj1 = new Derived(); 
       // As per overriding rules this should call to class Derive's static  
       // overridden method. Since static method can not be overridden, it  
       // calls Base's display()  
//       obj1.display();   
//       obj1.BaseMethod();
//       obj1.display();
//       obj1.print();
         
       // Here overriding works and Derive's print() is called  
//       obj1.print();    
//       obj1.BaseMethod();
//       obj1.print();
//       
//       obj1.print();
//     obj1.test("Manish");
//     obj1.print();
    // obj1.test();
     
    } 
} 