package dbUtility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitBasic {

	@BeforeClass
	public static void m1() {
		System.out.println(1);
	}

	@Before
	public void m2() {
		System.out.println(2);
	}
	
	@Test
	public void m3() {
		System.out.println(3);
	}
	@Test
	public void m4() {
		System.out.println(4);
	}
	@After
	public void m5() {
		System.out.println(5);
	}
	@AfterClass
	public static void m6() {
		System.out.println(6);
	}
	
}
