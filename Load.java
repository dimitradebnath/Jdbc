package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class Load {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String str = "Insert into Persons values(27,'Kishan','Kapoor')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?user=root&password=root");
			System.out.println("Connection established");
			st = con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(str);
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}