package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

public class ATest {

	A obj= new A();
	void m1Test() {
		assertTrue(0<=obj.m1() && obj.m1()<=1);
	}
}

class A{
	double m1() {
		return Math.random();
	}
}
class B{
	A a= new A();
	
	double m2() {
		double x= a.m1();//mock the functionality 
		return x*2;
	}
}

