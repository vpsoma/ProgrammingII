package javaProg2;

import java.util.ArrayList;

public class NewPurchases extends Csv2 {

	// Creation of a list with the new fees of our customers
	private static ArrayList<NewPurchases> NewFees = new ArrayList<NewPurchases>();
	// The data that we need
	private static NewPurchases newF;
	private static String newName;
	private static String newMonth;
	private static String newFees;
	// Creation of a list with the new customers
	private static ArrayList<NewPurchases> NewCustomers = new ArrayList<NewPurchases>();

	// Checks if the new purchases are from the old customers or not
	public static void findCustomers() {
		/*
		 * Checks if the customer already exists 
		 * if yes, we add his new fees to a new list 
		 * if not, we add the new customer to another list
		 */
		for (int i = 0; i < name.size(); i++) {
			boolean found = false;
			int spot = -1;
			int j = 0;
			Dbconnection a = new Dbconnection();
			do {
				a.getTotalFees().get(j);
				if (name.get(j) == Dbconnection.getName()) {
					found = true;
					spot = j;
				}
				j = j + 1;
			} while (found == false || j < a.getTotalFees().size());
			if (found = true) {
				newName = name.get(spot);
				newMonth = month.get(spot);
				newFees = fees.get(spot);
				newF = new NewPurchases(newName, newMonth, newFees, NewFees);
			} else {
				newName = name.get(i);
				newMonth = month.get(i);
				newFees = fees.get(i);
				newF = new NewPurchases(newName, newMonth, newFees, NewCustomers);
			}
		}
	}

	// Constructor with the arguments that the list contains
	public NewPurchases(String name, String month, String fees, ArrayList<NewPurchases> list) {
		name = newName;
		month = newMonth;
		fees = newFees;
		// Adds data to the proper list
		newF.addData(list).add(this);
	}

	// Returns the proper list
	public ArrayList<NewPurchases> addData(ArrayList<NewPurchases> list) {
		return list;
	}

}
