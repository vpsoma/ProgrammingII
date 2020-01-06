import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Maria Aspasia Stefadourou.
 *
 */

public class Gifts {
	private int numberOfPoductsAsGifts = 0;
	private int numberOfPossibleGifts;
	Products c = new Products();
	ArrayList <Product> leftOverProducts = (ArrayList<Product>) c.createList();
	ArrayList <NewPurchases> offered = new ArrayList<NewPurchases>();
	private int sizeOfnewoffered = Customer.newoffered.size();
	public String[] findGiftsReceivers(ArrayList<Customer> newoffered, ArrayList<Product> leftOverProducts ) {	

	/**
	 * find how many products have surpassed their aimed period of being sold and can be 
	 * given as presents to the customers.
	 */
	for (int i = 0; i < leftOverProducts.size() ; i++) {
		Product prod = leftOverProducts.get(i);
		numberOfPoductsAsGifts = numberOfPoductsAsGifts + prod.getQuantity();
	}
	
	/*
	 * calculate the possible number of gifts based on the products that can be gifted and the 
	 * number of customers that deserve to take an offer.
	 */
	
	if (numberOfPoductsAsGifts <= sizeOfnewoffered) {
		numberOfPossibleGifts = numberOfPoductsAsGifts;
	} else {
		numberOfPossibleGifts = sizeOfnewoffered;
	}
	Scanner sc = new Scanner (System.in);
	System.out.println("You can make up to" + numberOfPossibleGifts + "gifts to your most valuable customers. How many gifts do you wish to make?");
	int numberOfGifts = sc.nextInt();
	
	/*
	 * Sort in descending order the list of the products that can be gifted based on their price.
	 */
	Collections.sort(leftOverProducts, new Comparator<Product>() {
	    public int compare(Product one, Product other) {
	        return other.getPrice().compareTo(one.getPrice());
	    }
	});
	
	/*
	 * Sort in descending order the list of customers that can receive a gift based on their total fees.
	 */
	Collections.sort(newoffered, new Comparator<NewPurchases>() {
	    public int compare(NewPurchases one, NewPurchases other) {
	        return other.getNewFees().compareTo(NewPurchases.getNewFees());
	    }
	});	

	String namesOfCustomersForGifts [] = new String [numberOfGifts];
	String mailsOfCustomersForGifts [] = new String [numberOfGifts];
	String namesOfProductsAsGifts [] = new String [numberOfGifts];
	
	/*
	 * Match the customers that are to receive a gift with the products that will be gifted to them according to the customers' expenses.
	 */
	final int INDEX = 0;
	final Product p = leftOverProducts.get(INDEX);
	for (int i = 0; i <= numberOfGifts; i++) {
		if (p.getQuantity() > 1) {
			namesOfProductsAsGifts [i] = p.getName();
			p.setQuantity(p.getQuantity() - 1); 
		} else if (p.getQuantity() == 1) {
			namesOfProductsAsGifts [i] = p.getName();
			leftOverProducts.remove(INDEX);	
		}
		namesOfCustomersForGifts [i] = newoffered.get(i).getNewName();
		mailsOfCustomersForGifts [i] = newoffered.get(i).getNewMail();
		offered.add(newoffered.get(i).getNewName(),newoffered.get(i).getNewMail());
	}
}
}


