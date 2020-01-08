package javaProg2;

import java.util.*;
import java.sql.*;

/**
 * Connection with the data base.
 * This class connects the program with the data base and then saves
 * the data to a list.
 * 
 * @author Ioanna Martini
 *
 */

public class Databaseconnection {

	/** The list that the data will be saved */
	static ArrayList<Databaseconnection> totalFees = new ArrayList<Databaseconnection>();
	private static Float t_fees;
	private static Float min_fees;
	private static String mail;
	private static String name;
	static Databaseconnection totalF;

	//Connection with the sql.server
	public static void main() {
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
			rs = stmt.executeQuery("SELECT  min(Fees) as minf, sum(Fees) as sumf, a.Mail, a.Name\r\n" + 
					"FROM Java_Agores as a, Java_Customers as b \r\n" + 
					"WHERE a.Name = b.Name AND a.Mail = b.Mail\r\n" + 
					"GROUP BY a.Name,a.Mail");
			while (rs.next()) {
				min_fees = rs.getFloat("minf");
				t_fees = rs.getFloat("sumf");
				mail = rs.getString("Mail");
				name = rs.getString("Name");
				totalF = new Databaseconnection(t_fees, min_fees, mail, name);
			}
			rs.close();
			stmt.close();
			dbcon.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}

	}

	/** Creation of getters and setters */
	public static Databaseconnection getTotalF() {
		return totalF;
	}

	public static void setTotalF(Databaseconnection totalF) {
		Databaseconnection.totalF = totalF;
	}

	public static Float getT_fees() {
		return t_fees;
	}

	public static void setT_fees(Float t_fees) {
		Databaseconnection.t_fees = t_fees;
	}

	public static Float getMin_fees() {
		return min_fees;
	}

	public static void setMin_fees(Float min_fees) {
		Databaseconnection.min_fees = min_fees;
	}

	public static String getMail() {
		return mail;
	}

	public static void setMail(String mail) {
		Databaseconnection.mail = mail;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Databaseconnection.name = name;
	}

	public ArrayList<Databaseconnection> getTotalFees() {
		return totalFees;
	}

	/** Constructor with the arguments that the list contains */
	public Databaseconnection(Float t_fees, Float min_fees, String mail, String name) {
		Databaseconnection.t_fees = t_fees;
		Databaseconnection.min_fees = min_fees;
		Databaseconnection.mail = mail;
		Databaseconnection.name = name;
		totalFees.add(this);
	}

	/** default constructor */
	public Databaseconnection() {

	}
}
