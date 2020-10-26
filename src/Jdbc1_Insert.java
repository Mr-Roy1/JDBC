

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1_Insert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into Interview.Roy values(11,'Deepak Kumar',71.45)";
         try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver Class Loaded and registered ");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Establish a connection with database server");
			stmt=con.createStatement();
			System.out.println("Platform Created");
			stmt.executeUpdate(qry);
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
         finally {
        	 if(stmt!=null) {
        		 try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
        	 if(con!=null) {
        		 try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
         }
	}

}
