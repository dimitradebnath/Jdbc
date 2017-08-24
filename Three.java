package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class Three {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		 ResultSet rs = null;
		 
		 
		 //String str= "Create table Batch(BatchId Int,Name Varchar(255))";
		 String str= "Insert into Batch values(?,?)";
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?user=root&password=root");
				pst = con.prepareStatement(str);
				//pst.execute();
				//during create in prepared statement use the above line and comment the rs part
				pst.setInt(1, 801);
				pst.setString(2, "baj");
				int i =pst.executeUpdate();//dont put str here in case of prepared statement
				if(i!=0)
					System.out.println("Data Inserted");
				pst.addBatch();// batch update
				//read from the database
				/*rs = (ResultSet) pst.executeQuery("select * from Batch");
				
				while (rs.next()) { //'if' inplace of while then single {
					System.out.println(rs.getInt(1) + " " + rs.getString(2));
					
				}*/
				pst.executeBatch();//batch execute
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 finally {
				
				/*if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		 
	}

}
