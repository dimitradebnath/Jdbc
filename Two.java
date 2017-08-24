package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class Two {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		// String str = "Create table Student (StudentId Int, Name Varchar(255))";
		//String str = "Insert into Student Values(80,'HariKishan')";
		//String str = "Update Student set Name='Satish' where StudentId=80";
		String str = "Delete from Student where StudentId=20";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?user=root&password=root");
			st = con.createStatement();

			// st.execute(str);//for creation of the table
			int i= st.executeUpdate(str);
			if(i!=0)
				System.out.println("data Inserted");
			rs = (ResultSet) st.executeQuery("select * from Student");
			while (rs.next()) { // if
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				if (rs != null) {
					try {
					rs.close();
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				} 

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
