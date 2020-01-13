package javaprog21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csvproducts {
	public static void main(String[] args) {
		String csvFile="C:\\Users\\PCV\\Documents\\свокг";
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList <String> name = new ArrayList <String>();
        ArrayList <String> date = new ArrayList <String>();
        ArrayList <String> quantity = new ArrayList <String>();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] products = line.split(cvsSplitBy);
                name.add(products[0]);
                date.add(products[1]);
                quantity.add(products[2]);
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
