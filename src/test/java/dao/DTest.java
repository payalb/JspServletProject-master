package dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class DTest {
//	A1 obj= new A1();
	
/*	
	@Test
	public void m1() {
		assertEquals(3,obj.m1());
	}
	*/
	@Mock A1 a1Obj;
	B1 b1Obj= new B1();
	@Test
	public void m2() {
		b1Obj.obj= a1Obj;
		when(a1Obj.m1()).thenReturn(2);
		assertEquals("positive",b1Obj.m2());
	}
}


final class A1{
	
	int  m1() {
		return 3;
	}
}
/*class AMock extends A1{
	int  m1() {}
}
*/
class B1{
	
	A1 obj= new A1();
	String m2() {
		int x=obj.m1();
		if(x>0) {
			return "positive";
		}else {
			return "not positive";
		}
	}
}