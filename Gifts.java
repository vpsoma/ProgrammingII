import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Calculate the gifts that will be send.
 * This class calculates the maximum number of gifts that can be send, asks the customer company how many of those gifts they wish 
 * to make, sends to the customers that have the biggest fees the products that are the most expensive as gifts
 * @author Maria Aspasia Stefadourou.
 */

public class Gifts {
		private int numberOfPoductsAsGifts; 
		private int numberOfPossibleGifts;
		int numberOfGifts;
		private InfoMail objectOfInfoMailClass;
		static String namesOfCustomersForGifts[];
		static String mailsOfCustomersForGifts[];
		static String namesOfProductsAsGifts[];
		SendEmail objectOfSendEmailClass;
		Products objectOfProductsClass = new Products();
		ArrayList<Product> productsPassedTheSellPeriod = objectOfProductsClass.createListofProductsPassedTheSellPeriod();
		int sizeOfnewoffered = Customer.newoffered.size();
	
		/**
		 * find how many products have surpassed their sell period and can be given as presents to the customers.
		 * @param input a list with the products over the sell period
		 * @return the number of products over the sell period
		 */
		public int findNumberOfProductsAsGifts(ArrayList<Product> productsPassedTheSellPeriod) {
			// A loop getting every product over the sell period.
			for (int i = 0; i < productsPassedTheSellPeriod.size(); i++) {
				Product prod = productsPassedTheSellPeriod.get(i);
				numberOfPoductsAsGifts = numberOfPoductsAsGifts + prod.getQuantity(); //variable that contains the total number of products over the sell period.
			}
			return numberOfPoductsAsGifts;
		}
		
		/**
		 * calculate the maximum number of gifts based on the products that can be
		 * gifted and the number of customers that deserve to be gifted a product.
		 * @param input the size of the list that contains the customers that deserve to receive a present
		 * @return the maximum number of gifts that can be made 
		 */
		public int findNumberOfGifts(int sizeOfnewoffered) {
			findNumberOfProductsAsGifts(productsPassedTheSellPeriod);
			//the maximum number of gifts is equal to the smallest between the number of costumers and the number of products
			if (numberOfPoductsAsGifts <= sizeOfnewoffered) {
				numberOfPossibleGifts = numberOfPoductsAsGifts;
			} else {
				numberOfPossibleGifts = sizeOfnewoffered;
			}
		 	return numberOfPossibleGifts;
		}
		
		/**
		 * ask the customer how many gifts they want to make.
		 * @return the number of gifts that are to be made 
		 */
		public int askNumberOfGifts() {
			findNumberOfGifts(sizeOfnewoffered);
			int numberOfGifts = Integer.parseInt((JOptionPane.showInputDialog("You can make up to " + numberOfPossibleGifts +
										" gifts to your most valuable customers. How many gifts do you wish to make?")));
			
			return numberOfGifts;
		}
		
		/**
		 * Sort in descending order the list of the products that can be gifted based on their price.
		 * @param input a list with the products over the sell period
		 * @return the list sorted in descending order based in the price 
		 */
		public void sortMyListBasedOnThePrice(ArrayList<Product> productsPassedTheSellPeriod) {
			 // Sort (based on the price)
			Collections.sort(productsPassedTheSellPeriod, new Comparator<Product>() {
				public int compare(Product one, Product other) {
					return other.getPrice().compareTo(one.getPrice());
				}
			});
		}
		
		
		/**
		 * Sort in descending order the list of customers that can receive a gift based on their total fees.
		 * @param input a list with the costumers that deserve to be gifted
		 * @return the list sorted in descending order based on their total fees
		 */
		public void sortMyListBasedOnTheTotalFees (ArrayList<NewPurchasesSeparation> newoffered) {
			 // Sort (based on the total fees)
			Collections.sort(newoffered, new Comparator<NewPurchasesSeparation>() {
				public int compare(NewPurchasesSeparation one, NewPurchasesSeparation other) {
					return other.getNewfees().compareTo(one.getNewfees());
				}
			});
		}


		/**
		 * Match the customers that are to receive a gift with the products that will be
		 * gifted to them according to the customers' expenses and the products' prices
		 * @param input a list with the products over the sell period sorted in descending order
		 * @param input a list with the costumers that deserve to be gifted sorted in descending order
		 */
		public void  findGiftsReceivers(ArrayList<NewPurchasesSeparation> newoffered,
			ArrayList<Product> productsPassedTheSellPeriod) throws Exception {
			sortMyListBasedOnThePrice(productsPassedTheSellPeriod);
			sortMyListBasedOnTheTotalFees(newoffered);
			askNumberOfGifts();
			//if our company customer wants to send gifts to their most valuable customers 
			if (numberOfGifts != 0) {
			namesOfCustomersForGifts = new String[numberOfGifts];
			mailsOfCustomersForGifts = new String[numberOfGifts];
			namesOfProductsAsGifts = new String[numberOfGifts];
			final int INDEX = 0;
			Product ProductToBeGifted = productsPassedTheSellPeriod.get(INDEX); //the fist of the list of products
			for (int i = 0; i < numberOfGifts; i++) {
				if (ProductToBeGifted.getQuantity() > 1) {
					//if the quantity of the first product of the list is more than one the product is gifted and the quantity of that product is reduced by one in the list 
					namesOfProductsAsGifts[i] = ProductToBeGifted.getName();
					ProductToBeGifted.setQuantity(ProductToBeGifted.getQuantity() - 1);
				} else if (ProductToBeGifted.getQuantity() == 1){
					//if the quantity of the first product of the list is equal to one the product is gifted and the product is removed from the list 
					namesOfProductsAsGifts[i] = ProductToBeGifted.getName();
					productsPassedTheSellPeriod.remove(INDEX);
				}
				namesOfCustomersForGifts[i] = newoffered.get(i).getNewName();
				mailsOfCustomersForGifts[i] = newoffered.get(i).getNewMail();
				updateOfferedInDataBase(Customer.newoffered.get(i).getNewName(),Customer.newoffered.get(i).getNewMail());
			}
			objectOfSendEmailClass = new SendEmail();
			objectOfSendEmailClass.sendMail(mailsOfCustomersForGifts, namesOfCustomersForGifts, namesOfProductsAsGifts);
			}
		}
		
		/**
		 * Update the list offered in database
		 * @param the name of the customer that received a gift
		 * @param the mail of the customer that received a gift
		 */
		public void updateOfferedInDataBase(String name, String mail) {
			String url = "jdbc:sqlserver://195.251.249.161:1433;"
					+ "databaseName=DB29;user=G529;password=59w495f49;";
			Connection dbcon;
			Statement stmt;
			ResultSet rs;

			/** declare ODBC connectivity */
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (java.lang.ClassNotFoundException e) {
				System.out.print("ClassNotFoundException: ");
				System.out.println(e.getMessage());
			}

			/** execute SQL statements */
			try {
				dbcon = DriverManager.getConnection(url);
				stmt = dbcon.createStatement();
				String sql = "INSERT INTO Java_Offered VALUES('"+name+"','"+mail+"');";
				stmt.executeUpdate(sql);
				stmt.close();
				dbcon.close();
			} catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
			}

		}
		
		
		public static String[] getNamesOfCustomersForGifts() {
			return namesOfCustomersForGifts;
		}

		public static void setNamesOfCustomersForGifts(String[] namesOfCustomersForGifts) {
			Gifts.namesOfCustomersForGifts = namesOfCustomersForGifts;
		}

		public static String[] getMailsOfCustomersForGifts() {
			return mailsOfCustomersForGifts;
		}

		public static void setMailsOfCustomersForGifts(String[] mailsOfCustomersForGifts) {
			Gifts.mailsOfCustomersForGifts = mailsOfCustomersForGifts;
		}

		public static String[] getNamesOfProductsAsGifts() {
			return namesOfProductsAsGifts;
		}

		public static void setNamesOfProductsAsGifts(String[] namesOfProductsAsGifts) {
			Gifts.namesOfProductsAsGifts = namesOfProductsAsGifts;
		}

		public InfoMail getObjectOfInfoMailClass() {
			return objectOfInfoMailClass;
		}

		public void setObjectOfInfoMailClass(InfoMail objectOfInfoMailClass) {
			this.objectOfInfoMailClass = objectOfInfoMailClass;
		}

		public Gifts() {
			
		}
}
