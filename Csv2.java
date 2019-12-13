package javaProg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv2 {
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<String> month = new ArrayList<String>();
	static ArrayList<String> fees = new ArrayList<String>();
	
	public static void main(String[] args) {
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
