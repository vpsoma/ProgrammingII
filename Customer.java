import java.util.ArrayList;

/**
 * 
 * @author Vasiliki Chalkiopoulou
 *
 */
public class Customer extends NewPurchasesSeparation {
	// customers that deserve to take an offer.
	static ArrayList<NewPurchasesSeparation> newoffered;
	static ArrayList<Double> totalfee;
	ArrayList<Integer> firstcase;
	ArrayList<Integer> counterfees = new ArrayList<Integer>();
	ArrayList<NewPurchasesSeparation> offered = new ArrayList<NewPurchasesSeparation>();

	public void addTheNewFees() {

		// A list that contains the total fees of every old customer.
		totalfee = new ArrayList<Double>();
		// initializing the list with the total fees of the previous year for every
		// customer
		for (int h = 0; h < Databaseconnection.totalFees.size(); h++) {
			totalfee.add(Databaseconnection.totalFees.get(h).getT_fees());
		}

		// A list that shows with 1 the customers that reduced a lot their purchases and
		// with 0 the one's who did not
		firstcase = new ArrayList<Integer>();
		// initializing the list with 0
		for (int l = 0; l < Databaseconnection.totalFees.size(); l++) {
			firstcase.add(0);
		}

		// A loop getting every customer.
		for (int i = 0; i < getOldCustomers().size(); i++) {
			// finds the position of the customer at the initial list and add his new
			// purchase to the same position
			// into the totalfee list.
			for (int k = 0; k < Databaseconnection.totalFees.size(); k++) {
				if (NewPurchasesSeparation.getOldCustomers().get(i).getNewName() == Databaseconnection.totalFees.get(k)
						.getName()) {
					double a = Double.parseDouble(NewPurchasesSeparation.getOldCustomers().get(i).getNewFees())
							+ totalfee.get(k);
					totalfee.set(k, a);

					// checks if the new purchase is smaller that the minimun purchase of the
					// previous year
					if (Double.parseDouble(
							NewPurchasesSeparation.getOldCustomers().get(i).getNewFees()) < Databaseconnection.totalFees
									.get(k).getMin_fees()) {
						firstcase.set(k, 1);
					}
					break;
				}
			}
		}
	}

	public void findsCustomersThatDiserveAnOffer() {

		NewPurchasesSeparation newf;
		newoffered = new ArrayList<NewPurchasesSeparation>();
		boolean found = false;
		int sizeoffered = offered.size();

		// if no one has get an offer, it sends for an offer the customers that have
		// reduced a lot their purchases
		if (sizeoffered == 0) {
			// for every customer with the firstcase=1 makes an object and adds it into the
			// list newoffered
			for (int i = 0; i < firstcase.size(); i++) {
				if (firstcase.get(i) == 1) {
					newf = new NewPurchasesSeparation(NewPurchasesSeparation.getOldCustomers().get(i).getNewName(),
							NewPurchasesSeparation.getOldCustomers().get(i).getNewMail(), "%d" + totalfee.get(i));
					newoffered.add(newf);
				}
			}
		}
		// else it sends for an offer the customers that have reduced a lot their
		// purchases and that have not taken an offer before
		else {
			for (int i = 0; i < firstcase.size(); i++) {
				if (firstcase.get(i) == 1) {
					for (int j = 0; j < sizeoffered; j++) {
						if (offered.get(j).getOfferedName() == NewPurchasesSeparation.getOldCustomers().get(i)
								.getNewName()) {
							found = true;
							break;
						}
					}
					if (found == false) {
						newf = new NewPurchasesSeparation(NewPurchasesSeparation.getOldCustomers().get(i).getNewName(),
								NewPurchasesSeparation.getOldCustomers().get(i).getNewMail(), "%d" + totalfee.get(i));
						newoffered.add(newf);
					}
				}
			}
		}
	}

	ArrayList<NewPurchasesSeparation> moreoldcustomers = new ArrayList<NewPurchasesSeparation>();
	ArrayList<NewPurchasesSeparation> newoldcustomers;

	/**
	 * 
	 * @return
	 */
	public void findMoreOldCustomers() {

		// It contains the name of every customer.
		String name;

		// It counts if a customer has made more than 10 months purchases.
		int i = 0;

		// It is a counter and it helps to reach every time the length of the
		// NewCustomers.
		int j = 0;

		// That's the primary length of the list NewCustomers before any customer be
		// deleted.
		int lengthoriginal = NewPurchasesSeparation.getNewCustomers().size();

		// A list that contains the position that a customer has appeared at the list
		// NewCustomers.
		ArrayList<Integer> counter = new ArrayList<Integer>();

		// A list that contains the customers that have to be transfered to the base.
		newoldcustomers = new ArrayList<NewPurchasesSeparation>();
		NewPurchasesSeparation newobject;

		// A variable that helps us reach the primary length of the NewCustomers.
		int sum = 0;

		// A variable that contains the length of the new NewCustomers list.
		int length;

		// That's the float type of the String newFees that the NewCustomer list
		// contains.
		float amount;
		NewPurchasesSeparation newf;

		// Take the first name of the list NewCustomers.
		do {
			length = NewPurchasesSeparation.getNewCustomers().size();
			i = 0;
			j = 0;
			name = NewPurchasesSeparation.getNewCustomers().get(i).getNewName();

			// Checking if the name already exists for 10times, meaning if that person has
			// gotten more than 10 months purchases.
			do {
				if (name == NewPurchasesSeparation.getNewCustomers().get(j).getNewName()) {
					i++;
					counter.add(j);
				}
				j++;
			} while (j - 1 == length);

			sum = +j;

			/*
			 * If the person has done more than 10 monthly purchases he has to be transfered
			 * into another list, called newoldcustomers and he has to be deleted from the
			 * list NewCustomers.
			 */
			if (i >= 10) {
				for (int a = 0; a <= counter.size(); a++) {
					amount = Float
							.parseFloat(NewPurchasesSeparation.getNewCustomers().get(counter.get(a)).getNewFees());
					newobject = new NewPurchasesSeparation(NewPurchasesSeparation.getNewCustomers().get(j).getNewName(),
							NewPurchasesSeparation.getNewCustomers().get(j).getNewMonth(), amount,
							NewPurchasesSeparation.getNewCustomers().get(j).getNewMail());
					newoldcustomers.add(newobject);
					moreoldcustomers.add(newobject);
					NewPurchasesSeparation.getNewCustomers().remove(counter.get(a));
				}
			}
			for (int a = 0; a <= counter.size(); a++) {
				counter.remove(a);
			}
		} while (sum < lengthoriginal);
	}

	/**
	 * 
	 * @param OldCustomers
	 * @param moreoldcustomers
	 */
	public void printAllOldCustomers(ArrayList<NewPurchasesSeparation> OldCustomers,
			ArrayList<NewPurchasesSeparation> moreoldcustomers) {
		for (int i = 0; i <= OldCustomers.size(); i++) {
			System.out.print("Name: " + NewPurchasesSeparation.getOldCustomers().get(i).getNewName());
			System.out.println("Email: " + NewPurchasesSeparation.getOldCustomers().get(i).getNewMail());
		}
		findMoreOldCustomers();
		for (int i = 0; i < moreoldcustomers.size(); i++) {
			System.out.print("Name: " + moreoldcustomers.get(i).getNewName());
			System.out.println("Email: " + moreoldcustomers.get(i).getNewMail());
		}
	}

	/**
	 * 
	 * @param offered
	 */
	public void printOfferedCustomers(ArrayList<NewPurchasesSeparation> offered) {
		for (int i = 0; i <= offered.size(); i++) {
			System.out.print("Name: " + offered.get(i).getNewName());
			System.out.println("Email: " + offered.get(i).getNewMail());
		}
	}
}
