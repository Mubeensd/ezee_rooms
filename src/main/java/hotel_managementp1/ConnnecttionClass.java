package hotel_managementp1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnnecttionClass {
static Connection getConnection() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagent", "root",
			"mubeenM#7745");
	return con;
}
}
