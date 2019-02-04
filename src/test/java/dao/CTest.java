package dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CTest {

	@Mock FileWriter writer;
	//@InjectMocks 
	C obj = new C();

	@Test
	public void m1() {
		assertEquals("both even", obj.mult(2, 2));
	}
	
	@Test
	public void m2() throws IOException {
		obj.writer= writer;
		obj.writeToFile();
		//verify(writer).write(Mockito.anyString());
	//	verify(writer).write("Hello wrold");
		verify(writer,times(2)).write(Mockito.anyString());
		verify(writer, times(2)).write(Mockito.anyInt());
	}
}

class C {


	String mult(int a, int b) {
		if (a % 2 == 0 && b % 2 == 0) {
			return "both even";
		} else if ((a % 2 == 0 && b % 2 != 0) || (a % 2 != 0 && b % 2 == 0)) {
			return "One odd, one even";
		} else {
			return "both odd";
		}
	}
	FileWriter writer = null;
	{
		try {
			writer= new FileWriter("abc.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void writeToFile() throws IOException {
			writer.write("Hello wrold");
			writer.write(20);
			writer.write('a');
			writer.write("Done");
		}

}