package com.demo.collection;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {

	public static void main(String[] args) {
		String[] stringArray = { "if", "it", "is", "to", "be", "it", "is",
				"up", "to", "me", "to", "delegate" };
		Map<String, Integer> m = new HashMap<String, Integer>();

		for (String str : stringArray) {
			Integer frequency = m.get(str);
			m.put(str, (frequency == null) ? 1 : frequency + 1);
		}

		System.out.println("WordsFrequency : " + m);
	}

}
