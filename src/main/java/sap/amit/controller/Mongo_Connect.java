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

@RequestMapping("/hana_new")
@RestController
public class Mongo_Connect {
	@GetMapping
	public String doConencte() throws ClassNotFoundException {
		Connection connection = null;
		String result = "";
		try {
			System.out.println("Called hana function");

			Class.forName("com.sap.db.jdbc.Driver");
			System.setProperty("java.net.useSystemProxies", "true");
			connection = DriverManager.getConnection("jdbc:sap://10.253.93.93:30041/1E77DD18A62E465CB29994B529D8D0D5",
					"SBSS_88698149167200023040047110408185104818420567197077892057294446012",
					"Rb8Vgh3Hghh3D7rSFV.YOm2_tj387IfM.6BTlkw7aB_XLr8p4NdWB2-1-OjhLHCyRWxjciy_eaiotdk5TnLjntZtfXYxkEMXfn9LWhbvu7jyNwBy18Wnz7jihWEUlytI");

			/*
			 * MongoClient mongoClient = new MongoClient( "10.11.241.3" ,35273);
			 * MongoDatabase db = mongoClient.getDatabase("D8xeVup4EppMsMS3");
			 * 
			 * boolean auth = db.authenticate("BwUkcoIhbEH44zGz",
			 * "KaO9vIpXMZLrJeLW".toCharArray());
			 */
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error Connecting... Please check the credentials";
		}
		if (connection != null) {
			try {
				System.out.println("Connection to HANA successful!");
				Statement stmt = connection.createStatement();
				stmt.executeQuery(
						"CREATE TABLE SAP_EMP(ID CHAR(50) PRIMARY KEY NOT NULL,NAME CHAR(50) NOT NULL,TEAM CHAR(50) NOT NULL);");
				ResultSet rs = stmt.executeQuery("SELECT count(id) FROM sap_emp;");
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
