package com.demo.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	Person(String name, LocalDate birthday, Sex gender, String email) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = email;
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public static void main(String... args) {
		List<Person> roster = new ArrayList<Person>();
		Person abc = new Person("ABC", LocalDate.of(1990, 12, 12), Sex.MALE, "abc@gmail.com");
		roster.add(abc);
		Person pqr = new Person("PQR", LocalDate.of(1992, 11, 11), Sex.FEMALE, "pqr@gmail.com");
		roster.add(pqr);
		Person xyz = new Person("XYZ", LocalDate.of(2014, 10, 10), Sex.MALE, "xyz@gmail.com");
		roster.add(xyz);

		System.out.println("Members of the collection (for-each loop):");
		for (Person person : roster) {
			System.out.println(person.getName());
		}

		System.out.println("Members of the collection (bulk data operations):");
		roster.stream().forEach(e -> System.out.println(e.getName()));
		System.out.println("Male members of the collection (bulk data operations):");
		roster.stream().filter(e -> e.getGender() == Sex.MALE).forEach(e -> System.out.println(e.getName()));

		System.out.println("Male members of the collection (for-each loop):");
		for (Person p : roster) {
			if (p.getGender() == Person.Sex.MALE) {
				System.out.println(p.getName());
			}
		}

		double average = roster.stream().filter(e -> e.getGender() == Sex.MALE).mapToInt(Person::getAge).average()
				.getAsDouble();

		System.out.println("Average age of male members (bulk data operations): " + average);
		
		Integer totalAge = roster
							.stream()
							.mapToInt(Person::getAge)
							.sum();
		System.out.println("Total age of all the members :" + totalAge);
		
		Integer totalAgeReduce = roster
								.stream()
								.map(Person::getAge)
								.reduce(0, (a,b) -> (a+b));
		
		System.out.println("Total age of all the members using reduce :" + totalAgeReduce);
		
		Averager averageCollect = roster.stream()
				.filter(p -> p.getGender() == Sex.MALE)
				.map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);
		
		System.out.println("Average age of male members: " + averageCollect.average());
		
		List<String> namesOfMaleMembersCollect = roster
				.stream()
				.filter(p -> p.getGender() == Sex.MALE)
				.map(p -> p.getName())
				.collect(Collectors.toList());
		
		System.out.println("NamesOfMaleMembersCollect :" + namesOfMaleMembersCollect);
		
		Map<Person.Sex, List<Person>> byGender =
				roster
				.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		
		System.out.println("groupingBy::byGender:" + byGender);
				
		Map<Person.Sex, List<String>> namesByGender =
				roster
				.stream()
				.collect(Collectors.groupingBy(Person::getGender,
						Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("groupingBy::namesByGender:" + namesByGender);
		
		Map<Person.Sex, Integer> totalAgeByGender =
				roster
				.stream()
				.collect(Collectors.groupingBy(Person::getGender,
						Collectors.reducing(
								0,
								Person::getAge,
								Integer::sum)));
		System.out.println("totalAgeByGender:" + totalAgeByGender);
		
		Map<Person.Sex, Double> averageAgeByGender =
				roster
				.stream()
				.collect(Collectors.groupingBy(
						Person::getGender,
						Collectors.averagingInt(Person::getAge)));
		
		System.out.println("averageAgeByGender:" + averageAgeByGender);
		
		
		double averageByParallelStream = roster
			    .parallelStream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		
		System.out.println("Average age of male members byParallelStream:" + averageByParallelStream);
		
		ConcurrentMap<Person.Sex, List<Person>> byGenderByParallelStream =
				roster
				.parallelStream()
				.collect(Collectors.groupingByConcurrent(Person::getGender));
		
		System.out.println("byGenderByParallelStream:" + byGenderByParallelStream);
	}
}
