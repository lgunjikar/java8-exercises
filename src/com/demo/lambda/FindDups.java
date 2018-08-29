package com.demo.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDups {

	public static void main(String[] args) {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		System.out.println("Distinct Words Using JDK 8 Aggregate Operations: "
				+ usingJava8Aggregate(array));
		System.out.println("Distinct Words Using the for-each Construct: "
				+ usingForEach(array));
	}

	private static Set<String> usingJava8Aggregate(String[] array) {

		return Arrays.asList(array).stream().collect(Collectors.toSet());
	}

	private static Set<String> usingForEach(String[] array) {

		Set<String> s = new HashSet<String>();

		for (String string : array) {
			s.add(string);
		}
		return s;
	}
}
