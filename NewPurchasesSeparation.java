package javaProg2;

import java.util.ArrayList;

/**
 * Separation of the customers. This class checks if the purchases from the csv
 * file have been made by existing or new customers and saves the data into two
 * separated lists based on this treaty.
 * 
 * @author Ioanna Martini
 *
 */

public class NewPurchasesSeparation extends CsvNewPurchases {

	/** Creation of a list with the new fees of the customers */
	static ArrayList<NewPurchasesSeparation> OldCustomers;
	// The data that we need
	private static NewPurchasesSeparation newF;
	private static String newName;
	private static String newMonth;
	private static String newFees;
	private static Float newfees;
	private static String newMail;
	private static double nf = 0;

	private static String offeredName;

	/** Creation of a list with the new customers */
	private static ArrayList<NewPurchasesSeparation> NewCustomers = new ArrayList<NewPurchasesSeparation>();

	/** Checks if the new purchases are from existing customers or not */
	public static void separateCustomers() {

		OldCustomers = new ArrayList<NewPurchasesSeparation>();

		/*
		 * Checks if the customer already exists if yes, adds his new fees to a new list
		 * if not, adds the new customer to another list
		 */
		for (int i = 0; i < name.size(); i++) {
			boolean found = false;
			int spot = 0;
			int j = 0;
			// Databaseconnection a = new Databaseconnection();
			do {
				if (name.get(i) == Databaseconnection.getTotalFees().get(j).getName()) {
					found = true;
					spot = j;
				}
				j = j + 1;
			} while (found == false && j < Databaseconnection.getTotalFees().size());

			/*
			 * if the name was found to the initial list(totalFees), it adds the customer's
			 * data to the OldCustomers list because he already exists.
			 */
			if (found = true) {
				newName = name.get(spot);
				newMonth = month.get(spot);
				newFees = fees.get(spot);
				nf = Double.parseDouble(newFees);
				newMail = mail.get(spot);
				newF = new NewPurchasesSeparation(newName, newMonth, nf, newMail);
			}
			/*
			 * if the name doesn't exist in the initial list (totalFees), this is a purchase
			 * from a new customer so it adds the customer's data to the NewCustomers list.
			 */
			else {
				newName = name.get(i);
				newMonth = month.get(i);
				newFees = fees.get(i);
				newMail = mail.get(spot);
				newF = new NewPurchasesSeparation(newName, newMonth, newFees, newMail);
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

	public static Float getNewfees() {
		return newfees;
	}

	public static void setNewfees(Float newfees) {
		NewPurchasesSeparation.newfees = newfees;
	}

	public static String getOfferedName() {
		return offeredName;
	}

	public static void setOfferedName(String offeredName) {
		NewPurchasesSeparation.offeredName = offeredName;
	}

	// Constructor with the arguments that the list OldCustomers contains
	public NewPurchasesSeparation(String name, String month, double newf, String mail) {
		name = newName;
		month = newMonth;
		newf = nf;
		mail = newMail;
		// Adds data to the proper list
		OldCustomers.add(this);
	}

	// Constructor with the arguments that the list NewCustomers contains
	public NewPurchasesSeparation(String name, String month, String fees, String mail) {
		name = newName;
		month = newMonth;
		fees = newFees;
		mail = newMail;
		// Adds data to the proper list
		NewCustomers.add(this);
	}

	/** Default constructor */
	public NewPurchasesSeparation() {

	}

	// Constructor
	public NewPurchasesSeparation(String newName, String newMail, String newFees) {
		this.newName = newName;
		this.newMail = newMail;
		this.newFees = newFees;
	}

	// Constructor
	/**
	 * 
	 * @param name
	 * @param month
	 * @param fees
	 * @param mail
	 */
	public NewPurchasesSeparation(String name, String month, Float fees, String mail) {
		name = newName;
		month = newMonth;
		fees = newfees;
		mail = newMail;
	}
}
