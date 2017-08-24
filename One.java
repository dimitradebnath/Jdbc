package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		PreparedStatement pst = null;
		 ResultSet rs = null;
		 String s1;
		 int s2;
		
		
		//for creation keep the result set commented and use pst.execute and use the following str
		//String str = "Create table Studenttwo (StudentId Int, Name Varchar(255))";
		String str="Insert into Studenttwo values(?,?)";
		//String str= "Delete from Studenttwo where StudentId=?";
		 
		 //String str="Update Studenttwo set Name=? where StudentId=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?user=root&password=root");
			pst = con.prepareStatement(str);
			//pst.executeQuery();
			

			
			
			
			pst.setInt(1, 400);
			pst.setString(2, "rajnesh");
			int i =pst.executeUpdate();//dont put str here in case of prepared statement
			if(i!=0)
				System.out.println("Data Inserted");
			
			System.out.println("enter the id");
			s2=sc.nextInt();
			System.out.println("enter the name");
			s1=sc.next();
			//read from thhe database
			rs = (ResultSet) pst.executeQuery("select * from Studenttwo");
			int d=0;
			while (rs.next()) { 
				//'if' inplace of while then single {
				if(s1.equalsIgnoreCase(rs.getString(2)))
						{
					
				
					d=1;
				System.out.println("Authorisation done");//login validation only through password
				
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				}

				else if(d==0)
				System.out.println("Authorisation Unsuccesfull");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
