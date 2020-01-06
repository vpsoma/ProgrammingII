import java.util.ArrayList;

/**
 * 
 * @author Vassiliki Chalkiopoulou
 *
 */
public class Customer extends NewPurchases {
	// Creation of a list of customers which obtains the customers that deserve to
	// take an offer.
	ArrayList<NewPurchases> newoffered;
	ArrayList<NewPurchases> offered = new ArrayList<NewPurchases>();
	ArrayList <String> totalfee;
	ArrayList <Integer> counterfees=new ArrayList <Integer>();
	/**
	 * Evaluation of customers as loyals or not.
	 * 
	 * @param totalFees
	 * @param newoffered
	 * @return
	 */
	public void findLoyals(ArrayList<Dbconnection> totalFees, ArrayList<NewPurchases> newoffered,
			ArrayList<NewPurchases> OldCustomers) {
		NewPurchases newf;
		newoffered = new ArrayList<NewPurchases>();
		totalfee=new ArrayList <String>();
		// A loop getting every customer.
		for (int i = 0; i < getOldCustomers().size(); i++) {
			int sizeoffered = offered.size();
			boolean found = false;
			int counter = 0;
			int position;
			float x=0;
			// Find out which customer has already taken an offer.
			do {
				if (NewPurchases.getOldCustomers().get(counter).getNewName() == offered.get(i).getNewName()) {
					found = true;
				}
			} while (found = false && i == sizeoffered);

			// Putting every customer in a category depending in his total amount/fees.
			if (found == false) {
				position = 0;
				float amount = Float.parseFloat(NewPurchases.getOldCustomers().get(counter).getNewFees());
				//x=Integer.parseInt(totalfee.get(position));
				// Adding the customers that tend to leave in a list by saving their name and
				// email.
				float a=0f;
				for (position = 0; position < totalFees.size(); position++) {
					if (totalFees.get(position).getName() == NewPurchases.getOldCustomers().get(counter).getNewName()) {
						//x=x+amount;
						//totalfee.remove(position);
						//totalfee.add("x");
						//totalfee.get(position).add(x);
						a=Float.parseFloat(NewPurchases.getOldCustomers().get(counter).getNewFees())+Float.parseFloat(totalfee.get(position));
						totalfee.set(position,"a");
						break;
					}
				}
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
				// Considering the situation that a customer may have already gotten into the
				// list and saving his latest email.
				/*for (int j = 0; j < i; j++) {
					if (NewPurchases.getOldCustomers().get(counter).getNewName() == newoffered.get(j).getNewName()) {
						newoffered.remove(j);
						counterfees.set(j,1);
					}
					if(counterfees.get(j)==1) {
						newoffered.set(i, String.parseString(Float.parseFloat(totalfee.get(j))-Dbconnection.getTotalFees().get(position).getT_fees()));
					}
				}*/
			}
			counter++;
		}
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<NewPurchases> findMoreOldCustomers() {

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
		ArrayList<NewPurchases> newoldcustomers = new ArrayList<NewPurchases>();
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
					NewPurchases.getNewCustomers().remove(counter.get(a));
				}
			}
			for (int a = 0; a <= counter.size(); a++) {
				counter.remove(a);
			}
		} while (sum < lengthoriginal);
		return newoldcustomers;
	}
}