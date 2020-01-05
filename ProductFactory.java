package ProgrammingII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class refers to the stock of the company.
 * It creates a map that includes the stock and finds the sell period of it.
 * @author EirhannaPapoutsi
 */
public class ProductFactory {
	/** It includes the stock of the company */
	private static Map<String,List<Product>> allProducts = new HashMap<>();
	/** Represents the demand cost for the company to sell the last's year products based on accounting terms. */
	private static double costSold = 0;

	/** 
	 * Defines a product the company bought.
	 * It creates the stock of the company using the product's name, code, quantity, price and 
	 * the day, month, year the product was bought from the company. In addition, it includes the 
	 * sell period of the product which is the needed expected period to pass for the product to be sold.
	 * Then it adds the stock to a map called allProducts.
	 */
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

	public double findSellPeriod(int quantity, double costSold) {
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
