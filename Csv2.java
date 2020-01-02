package javaProg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Import data from csv file.
 * This class takes the new purchases of the company from a csv file,
 * separates the name,mail,fees and the month of each purchase
 * and saves them to separate lists.
 * 
 */

public class Csv2 {

	/** Statement of the static fields */
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<String> month = new ArrayList<String>();
	static ArrayList<String> fees = new ArrayList<String>();
	static ArrayList<String> mail = new ArrayList<String>();

	/** Separation of the elements of each line and storage in lists */
	public static void getsCvData(String[] args) {
		String csvFile = "C:\\Users\\ioann\\Documents";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] newPurchase = line.split(cvsSplitBy);
				name.add(newPurchase[0]);
				month.add(newPurchase[1]);
				fees.add(newPurchase[2]);
				mail.add(newPurchase[3]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
