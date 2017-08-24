package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mysql.jdbc.ResultSet;

public class Load1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		String str = "Insert into Persons values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?user=root&password=root");
			System.out.println("Connection established");
			
			
			//database meta data //after connection establishment
			DatabaseMetaData data = con.getMetaData();
			System.out.println(" By database meta data we get :------   "+data.getDriverName());
			System.out.println(data.getDriverVersion());
			
			
			
			
			
			pst=con.prepareStatement(str);
			pst.setInt(1,10);
			pst.setString(2,"Debd");
			pst.setString(3,"Halom");
			
			int i =pst.executeUpdate();//dont put str here in case of prepared statement
			if(i!=0)
				System.out.println("Data Inserted");
			
			
			rs = (ResultSet) pst.executeQuery("select * from Persons");
			
			if (rs.next()) { //'if' inplace of while then single {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				
			}
				//resultset meta data but the function is not there its there in the result set
				
				ResultSetMetaData r = rs.getMetaData();
				System.out.println("by result set we get number of columns :-"+r.getColumnCount());
				
				
				
				
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			
			if (pst != null) {
				try {
					pst.close();
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
