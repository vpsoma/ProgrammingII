package javaprog21;

import java.util.ArrayList;

public class Customer extends Dbconnection2 {
	//Evaluation of customers as loyals or not
	public ArrayList<Boolean> findLoyals(ArrayList<Dbconnection2> totalFees) {
		ArrayList<Boolean> loyals = new ArrayList<Boolean>();
		for (int i = 0; i < totalFees.size(); i++) {
			if (Dbconnection2.getT_fees()>  Dbconnection2.getMin_fees()) {
				loyals.add(true);
			} else {
				loyals.add(false);
			}
		}
		return loyals;
	}

}
