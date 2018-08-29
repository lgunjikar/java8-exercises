package com.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordering {

	public static void main(String[] args) {
		
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
		
		System.out.print("listOfIntegers: ");
		listOfIntegers.stream()
		.forEach(e -> System.out.print(e+" "));
		
		System.out.println("");
		
		System.out.println("listOfIntegers sorted in reverse order:");
		
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer>  reveresed = normal.reversed();
		
		Collections.sort(listOfIntegers, reveresed);
		
		listOfIntegers.stream()
		.forEach(e -> System.out.print(e +" "));
		System.out.println("");
		
		System.out.println("Parallel stream");
		listOfIntegers.parallelStream()
		.forEach(e -> System.out.print(e + " "));
		System.out.println("");
		
		System.out.println("Another parallel stream:");
		listOfIntegers.parallelStream()
		.forEach(e -> System.out.print(e + " "));
		System.out.println("");
		
		System.out.println("With forEachOrdered:");
		listOfIntegers.parallelStream()
		.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
	}

}
