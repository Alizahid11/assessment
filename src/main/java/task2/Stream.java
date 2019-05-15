package task2;

import java.util.ArrayList;
import java.util.List;

public class Stream {

	public static void main(String[] abc) {
		List<Person> personList = new ArrayList<Person>();

		Family fam = new Family();

		System.out.println(fam.setParentOf("Frank", "Morgan"));
		System.out.println(fam.setParentOf("Frank", "Dylan"));
		System.out.println(fam.male("Dylan"));
		System.out.println(fam.setParentOf("Joy", "Frank"));
		System.out.println(fam.male("Frank"));
		System.out.println(fam.male("Morgan"));
		System.out.println(fam.setParentOf("July", "Morgan"));
		System.out.println(fam.isMale("Joy"));
		System.out.println(fam.isFemale("Joy"));
		//for(int i = 0; i < fam.getChildrenOf("Morgan").length; i++)
			System.out.println(fam.getChildrenOf("Morgan"));
		System.out.println(fam.setParentOf("Jennifer", "Morgan"));
		//for(int i = 0; i< fam.getChildrenOf("Morgan").length; i++)
			System.out.println(fam.getChildrenOf("Morgan"));
		//for(int i = 0; i< fam.getChildrenOf("Dylan").length; i++)
			System.out.println(fam.getChildrenOf("Dylan"));
		System.out.println(fam.getParentsOf("Frank"));
		System.out.println(fam.setParentOf("Morgan", "Frank"));
		
		
		
	}
	
}
//		fam.setParentOf("Frank", "Morgan");       // true
//		fam.setParentOf("Frank", "Dylan");        // true
//		fam.male("Dylan");                        // true
//		fam.setParentOf("Joy", "Frank");          // true
//		fam.male("Frank");                        // true
//		fam.male("Morgan");                       // false
//		// (Morgan is a woman because she both is Frank's parent, but not his father) 
//		fam.setParentOf("July", "Morgan");        // true
//		// (The preceding assertion was rejected, so there is no conflict)
//		fam.isMale("Joy") || fam.isFemale("Joy"); // false
//		// (We know Joy is Frank's child, but we can't derive Joy's gender)
//		fam.getChildrenOf("Morgan");              // ["Frank", "July"]
//		fam.setParentOf("Jennifer", "Morgan");    // true
//		fam.getChildrenOf("Morgan");              // ["Frank", "Jennifer", "July"]
//		fam.getChildrenOf("Dylan");               // ["Frank"]
//		// (That is all we know for sure)
//		fam.getParentsOf("Frank");                // ["Dylan", "Morgan"]
//		fam.setParentOf("Morgan", "Frank");       // false
//		// (It is impossible to be the parent of your parent)


