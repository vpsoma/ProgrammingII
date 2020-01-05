import java.util.ArrayList;

public class NewPurchases extends Csv2 {

	// Creation of a list with the new fees of our customers
	private static ArrayList<NewPurchases> OldCustomers = new ArrayList<NewPurchases>();
	// The data that we need
	private static NewPurchases newF;
	private static String newName;
	private static String newMonth;
	private static String newFees;
	private static Float newfees;
	private static String newMail;
	private static int nf=0;
	// Creation of a list with the new customers
	private static ArrayList<NewPurchases> NewCustomers = new ArrayList<NewPurchases>();
	// Checks if the new purchases are from the old customers or not
	public static void findCustomers() {
		/*
		 * Checks if the customer already exists if yes, we add his new fees to a new
		 * list if not, we add the new customer to another list
		 */
		for (int i = 0; i < name.size(); i++) {
			boolean found = false;
			int spot = -1;
			int j = 0;
			Dbconnection a = new Dbconnection();
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
				nf=Integer.parseInt(newFees);
				newMail = mail.get(spot);
				newF = new NewPurchases(newName, newMonth, nf, newMail);
			} else {
				newName = name.get(i);
				newMonth = month.get(i);
				newFees = fees.get(i);
				newMail = mail.get(spot);
				newF = new NewPurchases(newName, newMonth, newFees, newMail);
			}
		}
	}

	// Creation of getters and setters

	public static ArrayList<NewPurchases> getOldCustomers() {
		return OldCustomers;
	}

	public static void setNewFees(ArrayList<NewPurchases> newFees) {
		OldCustomers = newFees;
	}

	public static String getNewName() {
		return newName;
	}

	public static void setNewName(String newName) {
		NewPurchases.newName = newName;
	}

	public static String getNewMonth() {
		return newMonth;
	}

	public static void setNewMonth(String newMonth) {
		NewPurchases.newMonth = newMonth;
	}

	public static String getNewFees() {
		return newFees;
	}

	public static void setNewFees(String newFees) {
		NewPurchases.newFees = newFees;
	}

	public static ArrayList<NewPurchases> getNewCustomers() {
		return NewCustomers;
	}

	public static void setNewCustomers(ArrayList<NewPurchases> newCustomers) {
		NewCustomers = newCustomers;
	}

	public static String getNewMail() {
		return newMail;
	}

	public static void setNewMail(String newMail) {
		NewPurchases.newMail = newMail;
	}

	// Constructor with the arguments that the list OldCustomers contains
		public NewPurchases(String name, String month, int newf, String mail) {
			name = newName;
			month = newMonth;
			newf=nf;
			mail = newMail;
			// Adds data to the proper list
			OldCustomers.add(this);
		}
	
	// Constructor with the arguments that the list NewCustomers contains
	public NewPurchases(String name, String month, String fees, String mail) {
		name = newName;
		month = newMonth;
		fees = newFees;
		mail = newMail;
		// Adds data to the proper list
		NewCustomers.add(this);
	}

	// Returns the proper list
	public ArrayList<NewPurchases> addData(ArrayList<NewPurchases> list) {
		return list;
	}
	
	//Default constructor
	public NewPurchases() {
		
	}
	
	//Constructor
	public NewPurchases(String newName, String newMail, String newFees) {
		this.newName=newName;
		this.newMail=newMail;
		this.newFees=newFees;
	}
	
	//Constructor
	/**
	 * 
	 * @param name
	 * @param month
	 * @param fees
	 * @param mail
	 */
	public NewPurchases(String name, String month, Float fees, String mail) {
		name = newName;
		month = newMonth;
		fees = newfees;
		mail = newMail;
	}

	public static Float getNewfees() {
		return newfees;
	}

	public static void setNewfees(Float newfees) {
		NewPurchases.newfees = newfees;
	}

}