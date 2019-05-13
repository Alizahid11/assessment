package task2;

import java.util.ArrayList;
import java.util.List;

public class Stream {

	public static void main(String[] abc) {
		List<Person> personList = new ArrayList<Person>();
		
		
		
		
//		personList.add(new Person("Alice",Gender.Female));
//		personList.add(new Person("Bob",Gender.Male));
//		personList.add(new Person("Annie",Gender.Female));
//		personList.add(new Person("Bilal",Gender.Male));
//		personList.add(new Person("Jack",Gender.Male));
//		personList.add(new Person("Tanya",Gender.Female));
//		
//		System.out.println(".......Filtered based on FEMALE........");
//		
//		personList.stream().filter(p -> p.getGender().equals(Gender.Female)).forEach(System.out::println);
//		
//		System.out.println("\n-------Filtered based on Male-------");
//		
//		personList.stream().filter(p -> p.getGender().equals(Gender.Male)).forEach(System.out::println);
//		
		
		Family fam = new Family();
		
//		fam.person.add(new Person("Humza"));
//		fam.male("Humza");
//		
		
		System.out.println(fam.setParentOf("Frank", "Morgan"));
		System.out.println(fam.setParentOf("Frank", "Dylan"));
		System.out.println(fam.male("Dylan"));
		System.out.println(fam.setParentOf("Joy", "Frank"));
		System.out.println(fam.male("Frank"));
		System.out.println(fam.male("Morgan"));
		System.out.println(fam.setParentOf("July", "Morgan"));
		System.out.println(fam.isMale("Joy"));
		System.out.println(fam.isFemale("Joy"));
		for(int i = 0; i < fam.getChildrenOf("Morgan").length; i++)
			System.out.println(fam.getChildrenOf("Morgan")[i]);
		System.out.println(fam.setParentOf("Jennifer", "Morgan"));
		for(int i = 0; i< fam.getChildrenOf("Morgan").length; i++)
			System.out.println(fam.getChildrenOf("Morgan")[i]);
		for(int i = 0; i< fam.getChildrenOf("Dylan").length; i++)
			System.out.println(fam.getChildrenOf("Dylan")[i]);
		System.out.println(fam.getParentsOf("Frank")[1]);
		System.out.println(fam.setParentOf("Morgan", "Frank"));
		
		
		
	}
	
}
