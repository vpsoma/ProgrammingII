package javaProg2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test on Databaseconnection class. This class checks if the
 * Databaseconnection class receive the correct data from the data base and if
 * it saves them into the "totalFees" list.
 * 
 * @author Ioanna Martini
 *
 */

public class DatabaseconnectionTest {

	/** Statement of the static fields */
	private static Double t_fees;
	private static Double min_fees;
	private static String mail;
	private static String name;

	@Test
	public void test() {
		// Given
		t_fees = 8830.7;
		min_fees = 503.6;
		mail = "nikiboura@gmail.com";
		name = "Niki Boura";

		// When
		Databaseconnection.dbconnection();
		Databaseconnection b = new Databaseconnection();
		String name1 = b.getName(); // It returns the last name that the list "totalFees" contains.
		String mail1 = b.getMail(); // It returns the last mail that the list "totalFees" contains.
		Double min_fees1 = b.getMin_fees(); // It returns the last minimum fee that the list "totalFees" contains.
		Double t_fees1 = b.getT_fees(); // It returns the last summary of fees that the list "totalFees" contains.
		String input = name1 + mail1 + min_fees1 + t_fees1;
		String expected = name + mail + min_fees + t_fees;

		// Then
		assertEquals(expected, input);

	}

}
