package com.demo.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Interference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> listOfStrings = new ArrayList<>(Arrays.asList("One", "Two"));
			String concatenatedString = listOfStrings.stream()
					.peek(s -> listOfStrings.add("Three"))
					.reduce((a,b) -> a +" "+b)
					.get();
			System.out.println("Concatenated String: "+ concatenatedString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
