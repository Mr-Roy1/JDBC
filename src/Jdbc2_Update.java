

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2_Update {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="update  Interview.roy set name='Deepak Kumar Arya' where id =1";
         try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Established a connection with database server");
			stmt=con.createStatement();
		     System.out.println("Platform created");
		     stmt.executeUpdate(qry);
		     System.out.println("Data Updated");
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
