package javaProg2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DatabaseconnectionTest {

	private static Double t_fees;
	private static Double min_fees;
	private static String mail;
	private static String name;

	@Test
	public void test() {
		//Given
				t_fees = 8830.7;
				min_fees = 503.6;
				mail = "nikiboura@gmail.com";
				name = "Niki Boura";
				
				//When
				Databaseconnection.main();
				Databaseconnection b = new Databaseconnection();
				String name1 = b.getName();
				String mail1 = b.getMail();
				Float min_fees1 = b.getMin_fees();
				Float t_fees1 = b.getT_fees();
				String input = name1 + mail1 + min_fees1 + t_fees1;
				String expected = name + mail + min_fees + t_fees;
				
				//Then
				assertEquals(expected, input);
			
	}

}
