import java.util.Scanner;
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
		private int numberOfPoductsAsGifts;
		private int numberOfPossibleGifts;
		Products c = new Products();
		ArrayList<Product> productsPassedTheSellPeriod = (ArrayList<Product>) c.createListofProductsPassedTheSellPeriod();
		Customer c1 = new Customer();
		private int sizeOfnewoffered = Customer.newoffered.size();
		private int numberOfGifts;
	
		/**
		 * find how many products have surpassed their sell period and can be given as presents to the customers.
		 */
		public int findNumberOfProductsAsGifts(ArrayList<Product> productsPassedTheSellPeriod) {
			for (int i = 0; i < productsPassedTheSellPeriod.size(); i++) {
				Product prod = productsPassedTheSellPeriod.get(i);
				numberOfPoductsAsGifts = numberOfPoductsAsGifts + prod.getQuantity();
			}
			return numberOfPoductsAsGifts;
		}
		
		/**
		 * calculate the possible number of gifts based on the products that can be
		 * gifted and the number of customers that deserve to take an offer.
		 */
		public int findNumberOfGifts(int numberOfPoductsAsGifts, int sizeOfnewoffered) {
		 	if (numberOfPoductsAsGifts <= sizeOfnewoffered) {
				numberOfPossibleGifts = numberOfPoductsAsGifts;
			} else {
				numberOfPossibleGifts = sizeOfnewoffered;
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("You can make up to" + numberOfPossibleGifts
					+ "gifts to your most valuable customers. How many gifts do you wish to make?");
			int numberOfGifts = sc.nextInt();
			return numberOfGifts;
		}	
		
		/**
		 * Sort in descending order the list of the products that can be gifted based on their price.
		 */
		protected void sortMyListBasedOnThePrice(ArrayList<Product> productsPassedTheSellPeriod) {
			Collections.sort(productsPassedTheSellPeriod, new Comparator<Product>() {
				public int compare(Product one, Product other) {
					return other.getPrice().compareTo(one.getPrice());
				}
			});
		}
		
		
		/**
		 * Sort in descending order the list of customers that can receive a gift based on their total fees.
		 */
		protected void sortMyListBasedOnTheTotalFees (ArrayList<NewPurchasesSeparation> newoffered) {
			Collections.sort(newoffered, new Comparator<NewPurchasesSeparation>() {
				public int compare(NewPurchasesSeparation one, NewPurchasesSeparation other) {
					return other.getNewFees().compareTo(NewPurchasesSeparation.getNewFees());
				}
			});
		}


		/**
		 * Match the customers that are to receive a gift with the products that will be
		 * gifted to them according to the customers' expenses.
		 */
		public InfoMail findGiftsReceivers(ArrayList<NewPurchasesSeparation> newoffered,
				ArrayList<Product> productsPassedTheSellPeriod) {
			String namesOfCustomersForGifts[] = new String[numberOfGifts];
			String mailsOfCustomersForGifts[] = new String[numberOfGifts];
			String namesOfProductsAsGifts[] = new String[numberOfGifts];
			final int INDEX = 0;
			final Product ProductToBeGifted = productsPassedTheSellPeriod.get(INDEX);
			for (int i = 0; i <= numberOfGifts; i++) {
				if (ProductToBeGifted.getQuantity() > 1) {
					namesOfProductsAsGifts[i] = ProductToBeGifted.getName();
					ProductToBeGifted.setQuantity(ProductToBeGifted.getQuantity() - 1);
				} else if (ProductToBeGifted.getQuantity() == 1) {
					namesOfProductsAsGifts[i] = ProductToBeGifted.getName();
					productsPassedTheSellPeriod.remove(INDEX);
				}
				namesOfCustomersForGifts[i] = newoffered.get(i).getNewName();
				mailsOfCustomersForGifts[i] = newoffered.get(i).getNewMail();
				NewPurchasesSeparation a = new NewPurchasesSeparation(newoffered.get(i).getNewName(),
						newoffered.get(i).getNewMail(), newoffered.get(i).getNewFees());
				c1.getOffered().add(a);
			}
			InfoMail object = new InfoMail(namesOfCustomersForGifts, mailsOfCustomersForGifts, namesOfProductsAsGifts);
			return object;
		}
}