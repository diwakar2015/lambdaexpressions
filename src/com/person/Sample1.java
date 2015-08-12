package com.person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample1 {
	
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
		
		List<Person> people = Sample1.createPeople();
		
		//Get map of name and person from the list
		
		Map<String, Person> personMap = people.stream()
				                              .collect(
				                            		  Collectors.toMap(
				                            				  person -> person.getName()+":"+ person.getAge(),
				                            				  person -> person)
				                            		  );	
		System.out.println("MAP:  "+personMap);
		
		
		// Get the list of person whose names are same
		
		Map<String,List<Person>> nameMapList = people.stream()
				                      
				                                     .collect(Collectors.groupingBy(Person::getName));
		
		System.out.println("namesList is >>");
		
		//Iterate over map
		nameMapList.forEach((k,v) -> System.out.println("Key: "+ k + " Value: "+v));
		
		
	}

}
