package dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BTest {

	@Mock
	A a; // a has no impl for any method, all methods re empty body
	@InjectMocks
	B obj = new B();

	@Test
	public void m2() {
		when(a.m1()).thenReturn(3.4);
		assertEquals(6.8, obj.m2(), 0.0); /// 6.88888 : 6.8 : 0.1
	}
}