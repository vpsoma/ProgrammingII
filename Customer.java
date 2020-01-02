package javaprog21;

import java.util.ArrayList;

public class Customer extends NewPurchasesSeparation {
	//Creation of a list of customers which obtains the customers that deserve to take an offer
	ArrayList<NewPurchasesSeparation> offered = new ArrayList<NewPurchasesSeparation>();
	ArrayList<NewPurchasesSeparation> newoffered;
	
	//Evaluation of customers as loyals or not
	public ArrayList<NewPurchasesSeparation> findLoyals(ArrayList<Databaseconnection> totalFees,ArrayList<NewPurchasesSeparation> newoffered) {
		NewPurchasesSeparation newf;
		newoffered = new ArrayList<NewPurchasesSeparation>();
		
		//A loop getting every customer
		for (int i=0;i<getOldCustomers().size();i++) {
			int sizeoffered=offered.size();
			boolean found=false;
			
			//Find out which customer has already taken an offer
			do {
				if ( NewPurchasesSeparation.getNewName()==offered.get(i).getNewName()) {
					found=true;
				}
			}while (found=false||i==sizeoffered);
			
			//Putting every customer in a category depending in his total amount/fees
			if(found ==false) {
				float totalamount=Integer.parseInt(NewPurchasesSeparation.getNewFees());
				
				//Adding the customers that tend to leave in a list by saving their name and email
				if ( totalamount< Databaseconnection.getMin_fees()) {
					newf=new NewPurchasesSeparation(NewPurchasesSeparation.getNewName(),NewPurchasesSeparation.getNewMail());
					newoffered.add(newf);
				}
				
				//Considering the situation that a customer may have already gotten into the list and saving his latest email
				for(int j=0;j<i;j++) {
					if(NewPurchasesSeparation.getNewName()==newoffered.get(j).getNewName()) {
						newoffered.remove(j);
					}
				}
			}
		}
		return newoffered;
	}
}

