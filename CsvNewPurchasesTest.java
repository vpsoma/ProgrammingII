package javaProg2;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CsvNewPurchasesTest {

	@Test
	public void test() {
		// Given
		ArrayList<String> name_example = new ArrayList<String>();
		ArrayList<String> month_example = new ArrayList<String>();
		ArrayList<String> fees_example = new ArrayList<String>();
		ArrayList<String> mail_example = new ArrayList<String>();
		name_example.add("Eleni");
		month_example.add("1");
		fees_example.add("268");
		mail_example.add("Eleni@yahoo.gr");
		String path = "C:\\Users\\ioann\\OneDrive\\Υπολογιστής\\example_test.csv";

		// When
		CsvNewPurchases csv1 = new CsvNewPurchases();
		csv1.saveCsvData(path);
		String expected = name_example.get(0) + month_example.get(0) + fees_example.get(0) + mail_example.get(0);
		String input = CsvNewPurchases.name.get(0) + CsvNewPurchases.month.get(0) + CsvNewPurchases.fees.get(0)
				+ CsvNewPurchases.mail.get(0);

		// Then
		assertEquals(expected, input);
	}

}
