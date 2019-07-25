package com.collection;

import java.util.*;

public class ListTest {

	public static void ArrayListTest() {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("Manish");
		arraylist.add("28");
		arraylist.add(null);
		arraylist.add("Manish");
		arraylist.add(0, "Replace");
		
		Iterator iterator = arraylist.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(arraylist.size());
	}

	public static void LinkedListTest() {
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("Rahul");
		linkedlist.add("Manish");
		linkedlist.addFirst("Mangesh");
		linkedlist.addLast("Sushant");
		linkedlist.add("middle");

		Iterator itr = linkedlist.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("=====================");

		System.out.println(linkedlist.remove());
		System.out.println("====After removed=====");
		Iterator itr2 = linkedlist.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		linkedlist.add(2, null);
		System.out.println("====After null=====");
		Iterator itr3 = linkedlist.iterator();
		while (itr3.hasNext()) {
			System.out.println(itr3.next());
		}
	}

	public static void StackTest() {
		Stack<String> stack = new Stack<String>();
		stack.push("Manish");
		stack.push("Manish");
		stack.push("Suraj");
		stack.push(null);
		System.out.println("======With Iterator=========");
		Iterator itr3 = stack.iterator();
		while (itr3.hasNext()) {
			System.out.println(itr3.next());
		}
		System.out.println("======With for each=========");
		for (Object str : stack) {
			System.out.println(str);
		}

		stack.pop();
		System.out.println("======After Pop=========");
		for (Object str : stack) {
			System.out.println(str);
		}
		
		System.out.println("Stack is empty? "+stack.empty());
		System.out.println(stack.peek());
		System.out.println("======After peek=========");
		for (Object str : stack) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		StackTest();
	}
}
