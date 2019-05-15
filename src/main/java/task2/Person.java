package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

enum Gender {
	Male, Female
}
public class Person 
{
	String name;
	Optional <Gender> gender;

	List<Person> parents = new ArrayList<Person>();
	List<Person> children= new ArrayList<Person>();
	List<Person> spouse = new ArrayList<Person>();



	public Person() {

	}

	public Person(String name) {

		this.name = name;
		this.gender = Optional.empty();
	}



	public Person(String name, Gender gender) {

		this(name);
		this.gender = Optional.of(gender);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Gender> getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = Optional.of(gender);
	}
	public String toString() {
		return "Person[name="+ name +", gender = "+gender.map(Object::toString).orElse("other")+"]";
	}
}


