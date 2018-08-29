package com.demo.collection;

import java.util.HashSet;
import java.util.Set;

public class FindDups2 {

	public static void main(String[] args) {
		String[] stringArray = { "i", "came", "i", "saw", "i", "left" };
		Set<String> uniques = new HashSet<String>();
		Set<String> duplicates = new HashSet<String>();

		for (String string : stringArray) {

			if (!uniques.add(string)) {
				duplicates.add(string);
			}
		}
		uniques.removeAll(duplicates);

		System.out.println("Unique words : " + uniques);
		System.out.println("Duplicate words : " + duplicates);
	}

}
