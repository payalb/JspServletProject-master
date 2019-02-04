package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATest {


	@Mock PrintStream stream;	
	
	@InjectMocks A obj= new A();
	@Test
	public void m1Test() {
		assertTrue(0<=obj.m1() && obj.m1()<=1);
	}
	//verify(mock, times(5)).someMethod("was called five times");
	@Test
	public void m2Test() {
		System.setOut(stream);
		obj.m2();
		verify(stream, times(2)).println(anyDouble());
	}
	
	@Test
	public void testM3() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//Reflection
		Class<A> cObj=(Class<A>) obj.getClass();
		Method method=cObj.getDeclaredMethod("m3");
		method.setAccessible(true);
		int o=(int) method.invoke(obj);
		assertEquals(3, o);
	}
	
	@Test
	public void m4() {
		assertEquals(5,A.m4());
	}
}

class A{
	double m1() {// It is returning a value
		return Math.random(); //I can capture the returned value and do assert
	}
	
	void m2() { //verify: whether the method was called, how many times was it called
		double d= Math.random();
		System.out.println(d);
		System.out.println(d*2);
	}
	
	private int m3() {
		return 3;
	}
	
	static int m4() {
		return 5;
	}
}
class B{
	A a= new A();
	
	double m2() {
		double x= a.m1();//mock the functionality of A class
		return x*2;
	}
}

