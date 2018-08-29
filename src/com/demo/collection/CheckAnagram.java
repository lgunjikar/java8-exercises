package com.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAnagram {

	public static void main(String[] args) {

		Map<String, List<String>> m = new HashMap<String, List<String>>();

		try {
			String[] wordArray = { "insert", "inerts", "inters", "nitres",
					"sinter", "least", "setal", "slate", "stale", "steal",
					"stela", "taels", "tales", "teals", "tesla" };
			for (String word : wordArray) {
				String alpha = alphabetize(word);
				List<String> l = m.get(alpha);
				if (l == null)
					m.put(alpha, l = new ArrayList<String>());
				l.add(word);
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		// Print all permutation groups above size threshold
		for (List<String> l : m.values())
			System.out.println(l.size() + ": " + l);

		System.out.println("isAnagram(insert,inerts):"
				+ isAnagram("inerts", "insert"));
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

	public static boolean isAnagram(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		} else if (str1.length() != str2.length()) {
			return false;
		}

		return alphabetize(str1).equals(alphabetize(str2));
	}

}
