import java.util.ArrayList;
/**
 * 
 * @author Vasiliki Chalkiopoulou
 *
 */
public class Customer extends NewPurchasesSeparation {
	// Creation of a list of customers which obtains the customers that deserve to
	// take an offer.
	static ArrayList<NewPurchasesSeparation> newoffered;
	ArrayList<NewPurchasesSeparation> offered = new ArrayList<NewPurchasesSeparation>();
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
	public void findLoyals(ArrayList<Databaseconnection> totalFees,ArrayList<NewPurchasesSeparation> OldCustomers) {
		NewPurchasesSeparation newf;
		newoffered = new ArrayList<NewPurchasesSeparation>();
		
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
				if (NewPurchasesSeparation.getOldCustomers().get(counter).getNewName() == offered.get(i).getNewName()) {
					found = true;
				}
			} while (found = false && i == sizeoffered);

			//If the customer hasn't already taken an offer, we calculate his total fees.
			if (found == false) {
				position = 0;
				
				//A variable that transforms into float his integer fees of the current month.
				float amount = Float.parseFloat(NewPurchasesSeparation.getOldCustomers().get(counter).getNewFees());
				
				//Adding the customers that tend to leave in a list by saving their name,email and total fees.
				float a=0f;
				for (position = 0; position < totalFees.size(); position++) {
					if (totalFees.get(position).getName() == NewPurchasesSeparation.getOldCustomers().get(counter).getNewName()) {
						a=Float.parseFloat(NewPurchasesSeparation.getOldCustomers().get(counter).getNewFees())+Float.parseFloat(totalfee.get(position));
						totalfee.set(position,"a");
						break;
					}
				}
				
				//Creating an object type Databaseconnection in order to add his fees from the data base into the list.
				Databaseconnection object=new Databaseconnection();
				if (amount < totalFees.get(position).getMin_fees()) {
					if(counterfees.get(position)==0) {
						a=a+object.getTotalFees().get(position).getT_fees();
						newf = new NewPurchasesSeparation(NewPurchasesSeparation.getOldCustomers().get(counter).getNewName(),
								NewPurchasesSeparation.getOldCustomers().get(counter).getNewMail(),
								totalfee.get(position));
						newoffered.add(newf);
						counterfees.set(position,1);
					}else {
						newf = new NewPurchasesSeparation(NewPurchasesSeparation.getOldCustomers().get(counter).getNewName(),
								NewPurchasesSeparation.getOldCustomers().get(counter).getNewMail(),
								totalfee.get(position));
						newoffered.add(newf);
					}
				}
			}
			counter++;
		}
	}
	ArrayList<NewPurchasesSeparation> moreoldcustomers=new ArrayList<NewPurchasesSeparation>();
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
					amount = Float.parseFloat(NewPurchasesSeparation.getNewCustomers().get(counter.get(a)).getNewFees());
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
	public void printAllOldCustomers(ArrayList<NewPurchasesSeparation> OldCustomers,ArrayList<NewPurchasesSeparation> moreoldcustomers) {
		for (int i=0 ; i<=OldCustomers.size() ; i++) {
			System.out.print("Name: " + NewPurchasesSeparation.getOldCustomers().get(i).getNewName());
			System.out.println("Email: " + NewPurchasesSeparation.getOldCustomers().get(i).getNewMail());
		}
		findMoreOldCustomers();
		for (int i=0; i<moreoldcustomers.size();i++) {
			System.out.print("Name: " + moreoldcustomers.get(i).getNewName());
			System.out.println("Email: " + moreoldcustomers.get(i).getNewMail());
		}
	}
	
	/**
	 * 
	 * @param offered
	 */
	public void printOfferedCustomers(ArrayList<NewPurchasesSeparation> offered) {
		for (int i=0 ; i<=offered.size() ; i++) {
			System.out.print("Name: " + offered.get(i).getNewName());
			System.out.println("Email: " + offered.get(i).getNewMail());
		}
	}
}
