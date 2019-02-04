package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(A1.class)
public class B1Test {

	@Mock A1 a1Obj;
	B1 b1Obj= new B1();
	@Test
	public void m2() {
		/*A1 a1Obj=PowerMockito.mock(A1.class);*/
		b1Obj.obj= a1Obj;
		PowerMockito.when(a1Obj.m1()).thenReturn(2);
		assertEquals("positive",b1Obj.m2());
	}
}