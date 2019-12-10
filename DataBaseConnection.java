import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseConnection {
	
	//Statement of the static fields
		ArrayList<DataBaseConnection> totalFees = new ArrayList<DataBaseConnection>();
		private static Float t_fees;
		private static Float min_fees;
		private static String mail;
		private static String name;
		private static int id;
		static DataBaseConnection totalF;

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
					+ "FROM Java_Agores as a, Java_Customers as b " + "WHERE a.id = b.id " + "GROUP BY id");
			while (rs.next()) {
				t_fees = rs.getFloat("sum(fees)");
				min_fees = rs.getFloat("min(fees)");
				mail = rs.getString("Mail");
				name = rs.getString("Name");
				id = rs.getInt("Id");
				totalF = new DataBaseConnection(t_fees, min_fees, mail, name, id);
			}
			rs.close();
			stmt.close();
			dbcon.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}

	}
}
