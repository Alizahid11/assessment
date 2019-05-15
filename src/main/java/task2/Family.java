package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//If a given name isn't in the family tree, create the person.
public class Family {

	List <Person> person = new ArrayList<Person>();


	public Family() {

	}


	public boolean male(String name) {

		if(Check(name)) {					

			Person newPerson = getMember(name); 
			//System.out.println(newPerson);

			if(checkSpouseMale(name)) {
				return false;
			}
			else if(!newPerson.gender.isPresent()) {

				newPerson.gender = Optional.of(Gender.Male);

				return true;
			} 
			else { return false; } 
		}
		else {
			person.add(new Person(name));
			Person newPerson = getMember(name);
			newPerson.gender = Optional.of(Gender.Male);

			return true;
		}

	}

	public boolean female(String name) {

		if(Check(name)) {					 

			Person newPerson = getMember(name); 			
			//Check 
			if(checkSpouseFemale(name)) {
				return false;
			}
			else if(!newPerson.gender.isPresent()) {
				newPerson.gender = Optional.of(Gender.Female);

				return true;
			} 
			else { return false; } 
		}
		else {
			person.add(new Person(name));
			Person newPerson = getMember(name);
			newPerson.gender = Optional.of(Gender.Female);

			return true;
		}
	}
	//Check if male, if true return it.
	public boolean isMale(String name) {

		if(Check(name)) { 													//Check name

			Person member = getMember(name); 								//Store in a variable;

			return	member.gender.map(g -> g.equals(Gender.Male)).orElse(false); 						//If their gender = Male, return true;


			//Else return false;

		} else { 											//If they aren't a family member, make them and still return false;
			person.add(new Person(name));
			return false;
		}	
	}


	public boolean isFemale(String name) {
		if(Check(name)) {
			Person member = getMember(name);
			return	member.gender.map(g -> g.equals(Gender.Female)).orElse(false);

		}else {
			person.add(new Person(name));
			return false;
		}

	}

	public boolean setParentOf(String childName, String parentName) {

		if(Check(parentName)) { 

			Person newParent = getMember(parentName);


			if (Check(childName)) {

				Person newChild = getMember(childName);


				if(isChild(parentName, childName)) {return false; }
				else {
					if(newChild.parents.size()==0){
						newChild.parents.add(newParent);
						newParent.children.add(newChild);
						return true;					
					}
					else if (newChild.parents.size()==1){
						if (!newChild.parents.get(0).gender.isPresent()) {
							newChild.parents.add(newParent);
							newParent.children.add(newChild);

							newParent.spouse.add(newChild.parents.get(0));
							newChild.parents.get(0).spouse.add(newParent);


							return true;
						}
						else if (!isSameGender(newChild.parents.get(0).gender, newParent.gender)) {
							newChild.parents.add(newParent);
							newParent.children.add(newChild);


							newParent.spouse.add(newChild.parents.get(0));
							newChild.parents.get(0).spouse.add(newParent);
							return true;
						}else { return false; }
					}
					else {
						return false;}
				}

			}
			else {
				person.add(new Person(childName));
				Person newChild = getMember(childName);
				newParent.children.add(newChild);
				newChild.parents.add(newParent);

				return true;
			}
		}
		else {
			person.add(new Person(parentName));
			Person newParent =getMember(parentName);

			if (Check(childName)) {

				Person newChild = getMember(childName);

				if(newChild.parents.size()==0){
					newChild.parents.add(newParent);
					newParent.children.add(newChild);
					return true;				
				}
				else if (newChild.parents.size()==1){
					newChild.parents.add(newParent);
					newParent.children.add(newChild);
					newParent.spouse.add(newChild.parents.get(0));
					newChild.parents.get(0).spouse.add(newParent);
					return true;
				}
				else if (!isSameGender(newChild.parents.get(0).gender, newParent.gender)) {
					newChild.parents.add(newParent);
					newParent.children.add(newChild);
					newParent.spouse.add(newChild.parents.get(0));
					newChild.parents.get(0).spouse.add(newParent);
					return true;
				}else { return false; }
			}

			person.add(new Person(childName));
			Person newChild = getMember(childName);
			newParent.children.add(newChild);
			newChild.parents.add(newParent);

			return true;
		}

	}




	public String[] getParentsOf(String name) {
		String[] parents = new String[2];
		if(Check(name)) {
			Person child = getMember(name);
			List <Person> parentList = child.parents;

			List<String> names = parentList.stream().map(x -> x.name).sorted().collect(Collectors.toList());
			parents = names.stream().toArray(String[]::new);
			return parents;
		}
		else {
			person.add(new Person(name));
			return parents;
		}
	}

	public String[] getChildrenOf(String name) {

		if(Check(name)) {
			Person parent = getMember(name);
			String[] childname = new String[parent.children.size()];

			List <String> names = parent.children.stream().map(x -> x.name).sorted().collect(Collectors.toList());
			childname = names.stream().toArray(String[]::new);
			return childname;
		}
		else {
			person.add(new Person(name));
			Person newparent = getMember(name);
			String[] childname = new String[newparent.children.size()];
			return childname;
		}
	}



	public boolean checkSpouseMale(String name) {
		Person spouse = getMember(name);
		if(spouse.spouse.size() > 0) {
			if(isMale(spouse.spouse.get(0).name)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}

	public boolean checkSpouseFemale(String name) {
		Person spouse = getMember(name);
		if(spouse.spouse.size() > 0) {
			if(isFemale(spouse.spouse.get(0).name)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}




	public boolean Check(String name) {
		boolean ishere = person.stream().anyMatch(x-> x.getName().equals(name));

		return ishere;
	}

	public Person getMember(String name) {
		List<Person> person2 = person.stream().filter(x -> x.getName().equals(name))
				.collect(Collectors.toList());

		return Optional.of(person2.get(0)).orElseGet(()->{
			Person newPerson = new Person(name);
			person.add(newPerson);
			return newPerson;
		});

	}
	public boolean isChild(String childName, String parentName) {
		Person parent = getMember(parentName);

		boolean ishe= parent.children.stream().anyMatch(x -> x.getName().equals(childName));

		return ishe;
	}
	private boolean isSameGender(Optional<Gender> genA, Optional<Gender> genB) {
		if(genA.isPresent() && genB.isPresent()) {
			return genA.get().equals(genB.get());

		}else return false; 
	}



}
