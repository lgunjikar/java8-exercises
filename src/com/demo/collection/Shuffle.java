package com.demo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffle {

	public static void main(String[] args) {
		String[] stringArray = { "i", "came", "i", "saw", "i", "left" };
		List<String> list = Arrays.asList(stringArray);
		System.out.println("List before shuffle: " + list);
		Collections.shuffle(list);
		System.out.println("List after shuffle: " + list);

	}

}
