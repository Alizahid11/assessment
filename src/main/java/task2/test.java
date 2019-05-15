package task2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	private Family fam = new Family();

	@Test
	public void test1() {
		assertTrue(fam.male("Morgan"));
	}

	@Test
	public void test2() {

		assertFalse(fam.isMale("Joy"));
		assertFalse(fam.isFemale("Joy"));
	}

	@Test
	public void test3() {
		assertTrue(fam.setParentOf("Frank","Morgan" ));
		assertTrue(fam.setParentOf("Frank","Dylan" ));
	}

	@Test
	public void test4() {
		assertTrue(fam.setParentOf("Morgan","Morgan" ));
		assertTrue(fam.setParentOf("Morgan","Dylan" ));
	}

	@Test
	public void test5() {
		assertTrue(fam.male("Dylan"));
		assertFalse(fam.male("Dylan"));

	}

	@Test
	public void test6() {
		assertTrue(fam.female("July"));
		assertFalse(fam.male("July"));

	}
	@Test
	public void test7() {
		assertTrue(fam.setParentOf("Joy","Frank" ));
		assertTrue(fam.setParentOf("July","Morgan" ));
	}

}







//		
//		String[] names = {"Frank", "July"};
//		
//		//assertEquals(fam.getChildOf("Morgan", names);
//		
//		assertTrue(fam.setParentOf("Jennifer", "Morgan"));
//		
//		String[] names2 = {"Frank", "Jennifer", "July"};
//		//assertEquals(fam.getChildOf("Morgan"), names2;
//		//assertEquals(fam.getChildOf("Dylan"), "Frank";
//		
//		
//		String[] names3 = {"Dylan", "Morgan"};
//		
//		//assertEquals(fam.getChildOf("Morgan"), names3;
//		
//		assertFalse(fam.setParentOf("Morgan", "Frank"));
//		
//		
//	}
//
//}
