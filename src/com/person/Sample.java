package com.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sample {

	public static List<Person> createPeople()
	{
		return Arrays.asList(

				new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32),
				new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72),
				new Person("Jill", Gender.FEMALE, 12)
				);
	}


	public static void main(String[] args) {

		List<Person> people = createPeople();

		//get, in uppercase, the names of all female older than 18

		List<String> filteredPerson = people.stream()
				.filter(person -> person.getAge() > 18)
				.filter(person -> person.getGender()==Gender.FEMALE)
				.map(person -> person.getName().toUpperCase())
				.collect(Collectors.toList());

		filteredPerson.forEach(getPerson -> System.out.println(getPerson));


		// find the sum of age of all the persons
         
		System.out.println("Sum of ages :"+
		
				people.stream()
				      .mapToInt(Person::getAge)
				      .reduce(0, (addResult, age) -> addResult + age)
				
				);
		
		// Another way
		System.out.println("Sum of ages :"+
				
				people.stream()
				      .mapToInt(Person::getAge)
				      .sum()
				
				);
		
		
		//Max age person
		
		System.out.println("Oldest person: "+
		
				people.stream()
				      .max((person1,person2) -> person1.getAge() > person2.getAge() ? 1 : -1)
			
				);
		
		
		//Count all the number of persons whose age is less than 18
		
		System.out.println("No of people whose age is less than 18 :"+
		
				people.stream()
				      .filter(person -> person.getAge() < 18)
				      .count()
				
				
				);
		
		//Best way to get the list of names
		
		List<String> names = people.stream()
				                   .filter(person -> person.getAge() > 17)
				                   .map(person -> person.getName().toUpperCase())
				                   // Collect does all the multithreading issues handling
				                   .collect(
				                		     () -> new ArrayList<>(),
				                		     (list, name) -> list.add(name),
				                		     (list1 , list2) -> list1.addAll(list2)
				                		   );

		System.out.println("List of names "+ names);
		
		//Or,
		
		List<String> namesAgain = people.stream()
                .filter(person -> person.getAge() > 17)
                .map(person -> person.getName().toUpperCase())
                // Collect does all the multithreading issues handling
                .collect(Collectors.toList());
		
		System.out.println("namesAgain : "+ namesAgain);
		
		// To get the names of persons as SET
		
		Set<String> namesSet = people.stream()
                .filter(person -> person.getGender() == Gender.MALE)
                .map(Person::getName)
                // Collect does all the multithreading issues handling
                .collect(Collectors.toSet());
		
		System.out.println("namesSet : "+ namesSet);
		
		

	}

}
