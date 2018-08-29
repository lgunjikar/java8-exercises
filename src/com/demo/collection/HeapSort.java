package com.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {

	public static void main(String[] args) {
		String[] stringArray = { "i", "came", "i", "saw", "i", "left" };
		List<String> list = Arrays.asList(stringArray);
		System.out.println("List before sort: " + list);
		System.out.println("List after sort: " + heapSort(list));		
		
	}
	
	private static <E> List<E> heapSort(Collection<E> c) {
		Queue<E> queue = new PriorityQueue<E>(c);
		List<E> result = new ArrayList<E>();

		while (!queue.isEmpty())
			result.add(queue.remove());

		return result;
	}	

}
