package com.program;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInteger {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Number of element: ");
		int n = scn.nextInt();

		System.out.println("Enter " + n + "elements: ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);
		System.out.println("Enter the item to be search");
		int serachItem = scn.nextInt();

		int firstIndex = 0;
		int lastindex = arr.length - 1;
		int middleIndex = (firstIndex + lastindex) / 2;
		while (firstIndex <= lastindex) {
			if (arr[middleIndex] == serachItem) {
				System.out.println(serachItem + "found at " + middleIndex + "index position");
				break;
			} else if (arr[middleIndex] < serachItem) {
				firstIndex = middleIndex + 1;
			} else {
				lastindex = middleIndex - 1;
			}
			middleIndex = (firstIndex + lastindex) / 2;
		}
		if (firstIndex > lastindex) {
			System.out.println("Element not found");
		}
	}
}
