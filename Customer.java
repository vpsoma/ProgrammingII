import java.util.ArrayList;
/**
 * 
 * @author Vasiliki Chalkiopoulou
 *
 */
public class Customer extends NewPurchases {
	// Creation of a list of customers which obtains the customers that deserve to
	// take an offer.
	static ArrayList<NewPurchases> newoffered;
	ArrayList<NewPurchases> offered = new ArrayList<NewPurchases>();
	ArrayList <String> totalfee;
	ArrayList <Integer> counterfees=new ArrayList <Integer>();
	/**
	 * The method doesn't return something.
	 * It has been created in order to help another class or method
	 * to accomplish its purpose. 
	 * @param totalFees
	 * @param newoffered
	 * @param OldCustomers
	 */
	public void findLoyals(ArrayList<Dbconnection> totalFees,ArrayList<NewPurchases> OldCustomers) {
		NewPurchases newf;
		newoffered = new ArrayList<NewPurchases>();
		
		//A list that contains the total fees of every old customer.
		totalfee=new ArrayList <String>();
		
		// A loop getting every customer.
		for (int i = 0; i < getOldCustomers().size(); i++) {
			//A variable that contains the size of the list offered.
			int sizeoffered = offered.size();
			
			//A variable useful in the research to find if a customer has already taken an offer.
			boolean found = false;
			int counter = 0;
			int position;
			// Find out which customer has already taken an offer.
			do {
				if (NewPurchases.getOldCustomers().get(counter).getNewName() == offered.get(i).getNewName()) {
					found = true;
				}
			} while (found = false && i == sizeoffered);

			//If the customer hasn't already taken an offer, we calculate his total fees.
			if (found == false) {
				position = 0;
				
				//A variable that transforms into float his integer fees of the current month.
				float amount = Float.parseFloat(NewPurchases.getOldCustomers().get(counter).getNewFees());
				
				//Adding the customers that tend to leave in a list by saving their name,email and total fees.
				float a=0f;
				for (position = 0; position < totalFees.size(); position++) {
					if (totalFees.get(position).getName() == NewPurchases.getOldCustomers().get(counter).getNewName()) {
						a=Float.parseFloat(NewPurchases.getOldCustomers().get(counter).getNewFees())+Float.parseFloat(totalfee.get(position));
						totalfee.set(position,"a");
						break;
					}
				}
				
				//Creating an object type Dbconnection in order to add his fees from the data base into the list.
				Dbconnection object=new Dbconnection();
				if (amount < totalFees.get(position).getMin_fees()) {
					if(counterfees.get(position)==0) {
						a=a+object.getTotalFees().get(position).getT_fees();
						newf = new NewPurchases(NewPurchases.getOldCustomers().get(counter).getNewName(),
								NewPurchases.getOldCustomers().get(counter).getNewMail(),
								totalfee.get(position));
						newoffered.add(newf);
						counterfees.set(position,1);
					}else {
						newf = new NewPurchases(NewPurchases.getOldCustomers().get(counter).getNewName(),
								NewPurchases.getOldCustomers().get(counter).getNewMail(),
								totalfee.get(position));
						newoffered.add(newf);
					}
				}
			}
			counter++;
		}
	}
	ArrayList<NewPurchases> moreoldcustomers=new ArrayList<NewPurchases>();
	ArrayList<NewPurchases> newoldcustomers;
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
		int lengthoriginal = NewPurchases.getNewCustomers().size();

		// A list that contains the position that a customer has appeared at the list
		// NewCustomers.
		ArrayList<Integer> counter = new ArrayList<Integer>();

		// A list that contains the customers that have to be transfered to the base.
		newoldcustomers = new ArrayList<NewPurchases>();
		NewPurchases newobject;

		// A variable that helps us reach the primary length of the NewCustomers.
		int sum = 0;

		// A variable that contains the length of the new NewCustomers list.
		int length;

		// That's the float type of the String newFees that the NewCustomer list
		// contains.
		float amount;
		NewPurchases newf;

		// Take the first name of the list NewCustomers.
		do {
			length = NewPurchases.getNewCustomers().size();
			i = 0;
			j = 0;
			name = NewPurchases.getNewCustomers().get(i).getNewName();

			// Checking if the name already exists for 10times, meaning if that person has
			// gotten more than 10 months purchases.
			do {
				if (name == NewPurchases.getNewCustomers().get(j).getNewName()) {
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
					amount = Float.parseFloat(NewPurchases.getNewCustomers().get(counter.get(a)).getNewFees());
					newobject = new NewPurchases(NewPurchases.getNewCustomers().get(j).getNewName(),
							NewPurchases.getNewCustomers().get(j).getNewMonth(), amount,
							NewPurchases.getNewCustomers().get(j).getNewMail());
					newoldcustomers.add(newobject);
					moreoldcustomers.add(newobject);
					NewPurchases.getNewCustomers().remove(counter.get(a));
				}
			}
			for (int a = 0; a <= counter.size(); a++) {
				counter.remove(a);
			}
		} while (sum < lengthoriginal);
	}
	
	public void printAllOldCustomers() {
		for (int i=0 ; i<=NewPurchases.getOldCustomers().size() ; i++) {
			System.out.print("Name: " + NewPurchases.getOldCustomers().get(i).getNewName());
			System.out.println("Email: " + NewPurchases.getOldCustomers().get(i).getNewMail());
		}
		findMoreOldCustomers();
		for (int i=0; i<moreoldcustomers.size();i++) {
			System.out.print("Name: " + NewPurchases.getNewCustomers().get(i).getNewName());
			System.out.println("Email: " + NewPurchases.getNewCustomers().get(i).getNewMail());
		}
	}
	
	public void printOfferedCustomers() {
		for (int i=0 ; i<=offered.size() ; i++) {
			System.out.print("Name: " + offered.get(i).getNewName());
			System.out.println("Email: " + offered.get(i).getNewMail());
		}
	}
}