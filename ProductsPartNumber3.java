package ProgrammingII;

import java.util.ArrayList;

public class ProductsPartNumber3 {
	ArrayList<Integer> indexOfSameProducts = new ArrayList<Integer>(); // contains indexes of the objects which are in DaysOfSameProd list               
    // name: the name of a product a customer buys, quantity: the quantity of a product a customer buys
    public void purchase(int name, int quantity) {
   	 ArrayList<Integer> daysOfSameProd = new ArrayList<Integer>(); // contains the days passed for every same product with different purchase dates
   	 long sum = 0; // calculation of total amount of the product 
   	 for (int i = 0; i < Product.prod.size() ; i++) { // creation of the above parallel lists
   		 if (Product.prod.get(i).getName().equals(name)) {
   			 daysOfSameProd.add(findDays(Product.prod.get(i).getDay(), Product.prod.get(i).getMonth(), Product.prod.get(i).getYear()));
				 indexOfSameProducts.add(i);
				 sum = sum + Product.prod.get(i).getQuantity();
   		 }
   	 }
   	 int a, b, c, d, temp, temp1; // To save temporary variables
   	 if (quantity > sum) {
   		 System.out.println("Sorry! :( We do not have so many items of this product.");
   		 return;
   	 } else if (daysOfSameProd.size() > 1) {
   		 boolean sorted = false; /* sorting the parallel lists by decreasing order based 
			                  * on the time passed since the date of purchase 		 
			 		  * of the stock to reduce the stock that has 
			                  * stayed most in bussiness
			 		  */
   		 while (!sorted) {
   			 sorted = true;
   			 for (int i = 0; i < daysOfSameProd.size(); i++) {
   				 a = daysOfSameProd.get(i);
   				 b = daysOfSameProd.get(i + 1);
   				 c = indexOfSameProducts.get(i);
   				 d = indexOfSameProducts.get(i + 1);
   				 if (a < b) {
   					 temp1 = daysOfSameProd.get(i);
						 a = daysOfSameProd.get(i + 1);
						 b = temp1;
				         temp = indexOfSameProducts.get(i);
				         c = indexOfSameProducts.get(i + 1);
				         d = temp;
				         sorted = false;
   				 }
				}
		    }
			quantity(quantity); // calls method quantity() to reduce wisely the stocks
		} else {
			 // In case the object of the list is unique
			 quantity(quantity);
		}
	}
	// Reduction of the stock of main prod list per cell quantity
    public void quantity(long quantity) {
   	 final int INDEX = 0; /* The index will always be zero
   	                       * because in order to move on to the next item of the list 
		               * a needed condition is to have all previous elements of the zero position removed
			       * and the rest of them moved to the left
			       */
   	 if (quantity < Product.prod.get(indexOfSameProducts.get(INDEX)).getQuantity()) {
   		 // If the quantity requested is less than that of the first cell, remove it
   		 Product.prod.get(indexOfSameProducts.get(INDEX)).setQuantity(Product.prod.get(indexOfSameProducts.get(INDEX)).getQuantity() - quantity);
   	 } else if (quantity == Product.prod.get(indexOfSameProducts.get(INDEX)).getQuantity()) {
			 // If the quantity requested is equal to the existing quantity just remove the existing quantity 
   		 Product.prod.remove(indexOfSameProducts.get(INDEX));
		 }  else {
			 // if quantity requested outweighs the existing quantity remove the existing and reduce the requested
			 Product.prod.remove(indexOfSameProducts.get(INDEX));
		     quantity = quantity - Product.prod.get(indexOfSameProducts.get(INDEX)).getQuantity();
		     quantity(quantity); // calls quantity() method retrospectively to reduce the stock's quantity
	     }
    }
}


}
