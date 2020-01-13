package javaProg2;

import java.util.*;
import java.sql.*;

public class Dbconnection {

	//Statement of the static fields
	static ArrayList<Dbconnection> totalFees = new ArrayList<Dbconnection>();
	private static Float t_fees;
	private static Float min_fees;
	private static String mail;
	private static String name;
	private static int id;
	static Dbconnection totalF;

	//Connection with the sql.server
	public static void getValues(String args[]) {
		String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;"
				+ "databaseName=DB29;user=G593;password=59w495f49;";
		Connection dbcon;
		Statement stmt;
		ResultSet rs;

		/* declare ODBC connectivity */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}

		/* execute SQL statements */
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			rs = stmt.executeQuery("SELECT sum(fees), min(fees), Mail, Name, Id"
					               + "FROM Java_Agores as a, Java_Customers as b " 
					               + "WHERE a.id = b.id " 
					               + "GROUP BY id");
			while (rs.next()) {
				t_fees = rs.getFloat("sum(fees)");
				min_fees = rs.getFloat("min(fees)");
				mail = rs.getString("Mail");
				name = rs.getString("Name");
				id = rs.getInt("Id");
				totalF = new Dbconnection(t_fees, min_fees, mail, name, id);
			}
			rs.close();
			stmt.close();
			dbcon.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}

	}

	//Creation of getters and setters
	public static Dbconnection getTotalF() {
		return totalF;
	}

	public static void setTotalF(Dbconnection totalF) {
		Dbconnection.totalF = totalF;
	}

	public static Float getT_fees() {
		return t_fees;
	}

	public static void setT_fees(Float t_fees) {
		Dbconnection.t_fees = t_fees;
	}

	public static Float getMin_fees() {
		return min_fees;
	}

	public static void setMin_fees(Float min_fees) {
		Dbconnection.min_fees = min_fees;
	}

	public static String getMail() {
		return mail;
	}

	public static void setMail(String mail) {
		Dbconnection.mail = mail;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Dbconnection.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Dbconnection.id = id;
	}

	public ArrayList<Dbconnection> getTotalFees() {
		return totalFees;
	}

	//Constructor with the arguments that the list contains
	public Dbconnection(Float t_fees, Float min_fees, String mail, String name, int id) {
		Dbconnection.t_fees = t_fees;
		Dbconnection.min_fees = min_fees;
		Dbconnection.mail = mail;
		Dbconnection.name = name;
		Dbconnection.id = id;
		totalFees.add(this);
	}

	//default constructor
	public Dbconnection() {

	}

}
