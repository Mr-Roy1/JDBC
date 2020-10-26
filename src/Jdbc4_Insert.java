

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc4_Insert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry1="insert into Interview.Roy values(2,'Rahul Rai',67.85)";
		String qry2="insert into Interview.Roy values(3,'Anil Rai',97.55)";
		String qry3="insert into Interview.Roy values(4,'Sunil Rai',47.25)";
         try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with database server");
			stmt=con.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
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
