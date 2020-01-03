package ProgrammingII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductFactory {

	private static Map<String,List<Product>> allProducts = new HashMap<>();

	private static double costSold = 0;

	public Product createProduct(String name, String code, int quantity, int day, int month, int year, double price) {
		double sellPeriod = findSellPeriod(quantity, costSold); 
		Product newProduct = new Product(name, code, quantity, day, month, year, price, sellPeriod);
		
		if(allProducts.containsKey(newProduct.getName())) {
			allProducts.get(newProduct.getName()).add(newProduct);
		}else {
			List<Product> value = new ArrayList<Product>();
			value.add(newProduct);
			allProducts.put(newProduct.getName(), value);
		}
		
		return newProduct;
	}
	
	public static Map<String,List<Product>> getAllProducts() {
		return allProducts;
	}

	protected double findSellPeriod(int quantity, double costSold) {
		if(quantity != 0 && costSold != 0) {
			double kta = costSold / quantity; // Calculation of Stock Turnover Ratio based on accounting types
			return 360 / kta; // Calculation of stock sale period based on accounting types
		}else {
			System.out.println("Sell period cannot be calculated. Setting it to 0...");
			return 0;
		}
	}

	public static void setCostSold(double costSold) {
		ProductFactory.costSold = costSold;
	}	
}
