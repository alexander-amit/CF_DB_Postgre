package sap.amit.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import java.net.*;

//import org.postgresql.Driver;
import org.springframework.web.bind.annotation.*;
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

@RequestMapping("/Hana")
@RestController
public class HanaConnect {
	@GetMapping
	public String doConencte() throws ClassNotFoundException {
		Connection connection = null;
		String result = "";
		try {
			System.out.println("Called hana function");
			/*
			 * Class.forName("org.postgresql.Driver");
			 * System.setProperty("java.net.useSystemProxies", "true");
			 * connection = DriverManager.getConnection(
			 * "jdbc:postgresql://10.11.241.9:38530/xne46wOMa58LHp2R",
			 * "gWoBE4PIuwaI20do", "QB_dpnoTJHRDxyqe");
			 */
			/*
			 * Class.forName("mongodb.jdbc.MongoDriver");
			 * System.setProperty("java.net.useSystemProxies", "true");
			 * connection = DriverManager.getConnection(
			 * "jdbc:mongodb://10.11.241.3:35273/D8xeVup4EppMsMS3",
			 * "BwUkcoIhbEH44zGz", "KaO9vIpXMZLrJeLW");
			 */
			System.out.println("Called hana function");
			Class.forName("com.sap.db.jdbc.Driver");
			System.setProperty("java.net.useSystemProxies", "true");
			connection = DriverManager.getConnection("jdbc:sap://10.253.67.138:30041/USR_D9FH6XYK74HH78UNCKEKHA7ZY",
					"USR_D9FH6XYK74HH78UNCKEKHA7ZY", "Sb1lSNBcghDzJBJHex4Bur_thyURrnns");

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error Connecting... Please check the credentials";
		}
		if (connection != null) {
			try {
				System.out.println("Connection to HANA successful!");
				Statement stmt = connection.createStatement();
				// stmt.executeQuery(
				// "CREATE TABLE SAP_EMP(ID CHAR(50) PRIMARY KEY NOT NULL,NAME
				// CHAR(50) NOT NULL,TEAM CHAR(50) NOT NULL);");
				// ResultSet rs = stmt.executeQuery("SELECT count(id) FROM
				// sap_emp;");
				ResultSet rs = stmt.executeQuery(
						"CREATE COLUMN TABLE SAP_EMP (ID VARCHAR(50),NAME VARCHAR(50),TEAM VARCHAR(100),PRIMARY KEY (ID) );");
				// ResultSet rs = stmt.executeQuery("CREATE TABLE SAP_EMP(ID
				// CHAR(50) PRIMARY KEY NOT NULL,NAME CHAR(50) NOT NULL,TEAM
				// CHAR(50) NOT NULL);");
				while (rs.next()) {
					System.out.print("Column 1 returned ");
					result = result + rs.getString(1);
				}
				rs.close();
				connection.close();

				return result;

			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Query failed!");
			}
		}
		return "Exception";
	}
}