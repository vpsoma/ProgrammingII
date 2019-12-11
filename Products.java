
public class Products {

	public ArrayList<Product> CreateList() {
		ArrayList <Product> leftOverProducts = new ArrayList <Product>(); // leftoverproducts the list contains the leftover products
		for (int i = 0 ;i <= Product.prod.size() ; i++) { // Prod: list containing all the products
			// if the product is sold for more days than the period of sale its moved to the list with the leftover products
			if (findDays(Product.prod.get(i).getDay(), Product.prod.get(i).getMonth(), Product.prod.get(i).getYear()) - Product.listOfSellPeriod.get(i) > 2 ) {
				leftOverProducts.add(Product.prod.get(i)); // the product is copied to the list with the leftover products
				Product.prod.remove(i); // the product is removed from the list with the products(Prod)
            }
        }
        return leftOverProducts; //the list with the leftover products is returned
	}

}
