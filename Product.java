import java.util.ArrayList;

public class Product {
	private String name;
	private String code;
	private double quantity;
	private int day;
	private int month;
	private int year;
	private double price;
	private double sellPeriod;
	private static double c = 0;
	double kta;
	ArrayList<Product> prod = new ArrayList<Product>();
	ArrayList<Double> sP = new ArrayList<Double>();
	public static final void costSold(double i) { /* called in main method with scanner */
		c = i; 
	}
	private static final double COST_SOLD = c;
	public Product(String name, String code, double quantity, int day, int month, int year, double price) {
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.day = day;
		this.month = month;
		this.year = year;
		this.price = price;
		prod.add(this);
	}
	public Product(String name, String code, double quantity, double price) {
		super();
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	} //syzhthsh me klash an to thelun pernaw ta proioda sthn panw lista
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double findSellPeriod() {
		try {
		kta = COST_SOLD / quantity;
		sellPeriod = 360 / kta;
		} catch(ArithmeticException e) {
			System.out.print("sellPeriod cannot be calculated");
			sellPeriod = 0;
		}
		sP.add(sellPeriod);
		return sellPeriod;
	}
}