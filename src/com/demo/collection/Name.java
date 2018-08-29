package com.demo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Name implements Comparable<Name> {

	private String firstName;
	private String lastName;

	Name(String firstName, String lastName) {
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstName.hashCode();
		result = prime * result + lastName.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Name))
			return false;
		Name n = (Name) obj;
		return n.firstName.equals(firstName) && n.lastName.equals(lastName);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(Name n) {
		int lastCmp = lastName.compareTo(n.lastName);
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}

	public static void main(String[] args) {

		Name nameArray[] = { new Name("John", "Smith"), new Name("Karl", "Ng"),
				new Name("Jeff", "Smith"), new Name("Tom", "Rich") };

		List<Name> namesList = Arrays.asList(nameArray);
		Collections.sort(namesList);
		System.out.println(namesList);
	}
}
