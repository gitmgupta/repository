package com.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import cucumber.api.java.it.E;

public class QueueTest {
	public static void priorityQueueTest() {
		Queue<String> queue = new PriorityQueue<String>();
		queue.offer("Manish");
		queue.add("Manish");
		queue.offer("Manish");

		Iterator<String> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println(queue.size());
	}

	public static void main(String[] args) {
		priorityQueueTest();
	}
}
