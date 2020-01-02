package javaProg2;

import java.util.ArrayList;

/**
 * Separation of the customers.
 * This class checks if the purchases from the csv file
 * have been made by existing or new customers
 * and saves the data into two separated lists 
 * based on this treaty.
 * 
 * @author Ioanna Martini
 *
 */

public class NewPurchasesSeparation extends CsvNewPurchases {

	/** Creation of a list with the new fees of the customers */
	private static ArrayList<NewPurchasesSeparation> OldCustomers = new ArrayList<NewPurchasesSeparation>();
	// The data that we need
	private static NewPurchasesSeparation newF;
	private static String newName;
	private static String newMonth;
	private static String newFees;
	private static String newMail;
	/** Creation of a list with the new customers */
	private static ArrayList<NewPurchasesSeparation> NewCustomers = new ArrayList<NewPurchasesSeparation>();

	/** Checks if the new purchases are from existing customers or not */
	public static void separateCustomers() {
		/*
		 * Checks if the customer already exists
		 * if yes, adds his new fees to a new list
		 * if not, adds the new customer to another list
		 */
		for (int i = 0; i < name.size(); i++) {
			boolean found = false;
			int spot = -1;
			int j = 0;
			Databaseconnection a = new Databaseconnection();
			do {
				if (name.get(j) == a.getTotalFees().get(j).getName()) {
					found = true;
					spot = j;
				}
				j = j + 1;
			} while (found == false || j < a.getTotalFees().size());
			if (found = true) {
				newName = name.get(spot);
				newMonth = month.get(spot);
				newFees = fees.get(spot);
				newMail = mail.get(spot);
				newF = new NewPurchasesSeparation(newName, newMonth, newFees, newMail, OldCustomers);
			} else {
				newName = name.get(i);
				newMonth = month.get(i);
				newFees = fees.get(i);
				newMail = mail.get(spot);
				newF = new NewPurchasesSeparation(newName, newMonth, newFees, newMail, NewCustomers);
			}
		}
	}

	/** Creation of getters and setters */

	public static ArrayList<NewPurchasesSeparation> getOldCustomers() {
		return OldCustomers;
	}

	public static void setNewFees(ArrayList<NewPurchasesSeparation> newFees) {
		OldCustomers = newFees;
	}

	public static String getNewName() {
		return newName;
	}

	public static void setNewName(String newName) {
		NewPurchasesSeparation.newName = newName;
	}

	public static String getNewMonth() {
		return newMonth;
	}

	public static void setNewMonth(String newMonth) {
		NewPurchasesSeparation.newMonth = newMonth;
	}

	public static String getNewFees() {
		return newFees;
	}

	public static void setNewFees(String newFees) {
		NewPurchasesSeparation.newFees = newFees;
	}

	public static ArrayList<NewPurchasesSeparation> getNewCustomers() {
		return NewCustomers;
	}

	public static void setNewCustomers(ArrayList<NewPurchasesSeparation> newCustomers) {
		NewCustomers = newCustomers;
	}

	public static String getNewMail() {
		return newMail;
	}

	public static void setNewMail(String newMail) {
		NewPurchasesSeparation.newMail = newMail;
	}

	/** Constructor with the arguments that the list contains */
	public NewPurchasesSeparation(String name, String month, String fees, String mail, ArrayList<NewPurchasesSeparation> list) {
		name = newName;
		month = newMonth;
		fees = newFees;
		mail = newMail;
		// Adds data to the proper list
		newF.addData(list).add(this);
	}
	
	/** Default constructor */
	public NewPurchasesSeparation() {
		
	}

	/** 
	 * Returns the proper list to the constructor
	 * in order to save the data to the proper list
	 * @param a list and 
	 * @return the same list to the constructor
	 */
	public ArrayList<NewPurchasesSeparation> addData(ArrayList<NewPurchasesSeparation> list) {
		return list;
	}

}
