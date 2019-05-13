package task2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {
	
	private Family fam = new Family();

	@Test
	public void test1() {
		assertTrue(fam.setParentOf("Frank","Morgan" ));
		assertTrue(fam.setParentOf("Frank","Dylan" ));
		assertTrue(fam.male("Dylan"));
		assertTrue(fam.setParentOf("Joy","Frank" ));
		assertTrue(fam.male("Frank"));
		assertFalse(fam.male("Morgan"));
		assertTrue(fam.setParentOf("July","Morgan" ));
		assertFalse(fam.isMale("Joy"));
		assertFalse(fam.isFemale("Joy"));
		
		String[] names = {"Frank", "July"};
		
		//assertEquals(fam.getChildOf("Morgan", names);
		
		assertTrue(fam.setParentOf("Jennifer", "Morgan"));
		
		String[] names2 = {"Frank", "Jennifer", "July"};
		//assertEquals(fam.getChildOf("Morgan"), names2;
		//assertEquals(fam.getChildOf("Dylan"), "Frank";
		
		
		String[] names3 = {"Dylan", "Morgan"};
		
		//assertEquals(fam.getChildOf("Morgan"), names3;
		
		assertFalse(fam.setParentOf("Morgan", "Frank"));
		
		
	}

}
