package task2;

import java.util.ArrayList;
import java.util.List;

enum Gender {
	Male, Female
}
	public class Person 
	{
		String name;
		private Gender gender;
		
		List<Person> parents = new ArrayList<Person>();
		List<Person> children= new ArrayList<Person>();
		List<Person> spouse = new ArrayList<Person>();
		
		String genderStr = "";
		
		public Person() {
			
		}
		
		public Person(String name) {
			
			this.name = name;
		}
		
		
		
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
	public String toString() {
		return "Person[name="+ name +", gender = "+gender+"]";
	}
	}
	
	
