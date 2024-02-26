package hotel_managementp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Servises {

	public String addCustomer(int no, String name, String number1, String mode,int rid) {
		try {
	       Connection con=ConnnecttionClass.getConnection();
			PreparedStatement pr1 = con.prepareStatement("select room_status from rooms where rid=?");
			pr1.setInt(1, rid);
		    ResultSet rs = pr1.executeQuery();
		    rs.next();
		    if(rs.getString(1).equalsIgnoreCase("available")) {
		    	PreparedStatement pr = con.prepareStatement("insert into customer values(?,?,?,?,?)");
				pr.setInt(1, no);
				pr.setString(2, name);
				pr.setString(3, number1);
				pr.setString(4, mode);
				pr.setInt(5, rid);
				int i = pr.executeUpdate();
				con.close();
				return "success";
		    }else {
		    	return "fails";
		    }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	public void changeStatus(int rid) {
		
			try {
				 Connection con=ConnnecttionClass.getConnection();
				PreparedStatement pr1 = con.prepareStatement("update rooms set room_status='Unavailable' where rid=?");
				pr1.setInt(1, rid);
				 pr1.executeUpdate();
				 con.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}