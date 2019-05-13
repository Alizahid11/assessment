package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//If a given name isn't in the family tree, create the person.
public class Family {

	List <Person> person = new ArrayList<Person>();


	public Family() {

	}


	public boolean male(String name) {

		if(Check(name)) {					 //Check if the person is there.

			Person newPerson = getMember(name); 			//Store the person in a variable;

			//Check 
			if(checkSpouseMale(name)) {
				return false;
			}
			else if(newPerson.genderStr.equals("")) {
				newPerson.genderStr = "Male";

				return true;
			} 
			else { return false; } 
		}
		else {
			person.add(new Person(name));
			Person newPerson = getMember(name);
			newPerson.genderStr = "Male";

			return true;
		}

	}

	public boolean female(String name) {

		if(Check(name)) {					 //Check if the person is there.

			Person newPerson = getMember(name); 			//Store the person in a variable;

			//Check 
			if(checkSpouseFemale(name)) {
				return false;
			}
			else if(newPerson.genderStr.equals("")) {
				newPerson.genderStr = "Female";

				return true;
			} 
			else { return false; } 
		}
		else {
			person.add(new Person(name));
			Person newPerson = getMember(name);
			newPerson.genderStr = "Female";

			return true;
		}
	}

	//Check if male, if true return it.
	public boolean isMale(String name) {

		if(Check(name)) { 													//Check name

			Person member = getMember(name); 								//Store in a variable;

			if(member.genderStr.equals("Male")) { 						//If their gender = Male, return true;
				return true;
			}
			else { return false; }									 //Else return false;

		} else { 											//If they aren't a family member, make them and still return false;
			person.add(new Person(name));
			Person newMember = getMember(name);
			return false;
		}	
	}


	public boolean isFemale(String name) {
		if(Check(name)) {
			Person member = getMember(name);
			if (member.genderStr.equals("Female")) {
				return true;
			}
			else {return false;
			}
		}else {
			person.add(new Person(name));
			Person newMember = getMember(name);
			return false;
		}

	}
	//Set Parents
	public boolean setParentOf(String childName, String parentName) {
										//Check if parents are in the family
		if(Check(parentName)) { 
											//Store parent in a Person.
			Person newParent = getMember(parentName);

									//IF true, check if child is in the family
			if (Check(childName)) {
														//Store child in a Person
				Person newChild = getMember(childName);
						//IF TRUE, Then check how many parents the child already has
				
				
				if(isChild(parentName, childName)) {
					return false;
				}
				else {
					if(newChild.parents.size()==0){
						newChild.parents.add(newParent);
						newParent.children.add(newChild);
						return true;					//If they have 1, check it's gender. CAN'T be the same as the current parent.

					}
					else if (newChild.parents.size()==1){
						if (newChild.parents.get(0).genderStr.equals("")) {
							newChild.parents.add(newParent);
							newParent.children.add(newChild);
							
							newParent.spouse.add(newChild.parents.get(0));
							newChild.parents.get(0).spouse.add(newParent);
							
							
							return true;
						}
						else if (! newChild.parents.get(0).genderStr.equals(newParent.genderStr)) {
							newChild.parents.add(newParent);
							newParent.children.add(newChild);
							
							
							newParent.spouse.add(newChild.parents.get(0));
							newChild.parents.get(0).spouse.add(newParent);
							return true;
						}else { return false; }
					}
					else {
						return false;
					}
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
				//Store child in a Person
				Person newChild = getMember(childName);
				//IF TRUE, Then check how many parents the child already has
				if(newChild.parents.size()==0){
					newChild.parents.add(newParent);
					newParent.children.add(newChild);
					return true;					//If they have 1, check it's gender. CAN'T be the same as the current parent.

				}
				else if (newChild.parents.size()==1){
					if (newChild.parents.get(0).genderStr.equals("")) {
						newChild.parents.add(newParent);
						newParent.children.add(newChild);
						newParent.spouse.add(newChild.parents.get(0));
						newChild.parents.get(0).spouse.add(newParent);
						return true;
					}
					else if (! newChild.parents.get(0).genderStr.equals(newParent.genderStr)) {
						newChild.parents.add(newParent);
						newParent.children.add(newChild);
						newParent.spouse.add(newChild.parents.get(0));
						newChild.parents.get(0).spouse.add(newParent);
						return true;
					}else { return false; }
				}
				else {
					return false;
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


		//If they have 2, return false, no more parents.

		//If they have 1, return true and add the parent.


		//ELSE Check if child is in the family

		//ELSE Make person
		//Check if child is in the family.
	}
	
	public String[] getParentsOf(String name) {
		String[] parents = new String[2];
		if(Check(name)) {
			Person child = getMember(name);
			List <Person> parentList = child.parents;
			
			List<String> names = parentList.stream().map(x -> x.name).sorted().collect(Collectors.toList());
			parents = names.parallelStream().toArray(String[]::new);
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
		//Checks if the name in question is already in the Family Tree.
		boolean ishere = person.stream().anyMatch(x-> x.getName().equals(name));

		return ishere;
	}

	public Person getMember(String name) {
		List<Person> person2 = person.stream().filter(x -> x.getName().equals(name))
				.collect(Collectors.toList());

		return person2.get(0);
	}
	public boolean isChild(String childName, String parentName) {
		Person parent = getMember(parentName);
		
		boolean ishe= parent.children.stream().anyMatch(x -> x.getName().equals(childName));
		
		return ishe;
	}




}
