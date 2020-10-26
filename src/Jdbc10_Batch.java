

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Jdbc10_Batch {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into Interview.Rai values(5,'sunil','scott','sunil rai')";
		String delqry="delete from Interview.Roy where id=7";
		String upqry="update Interview.Roy set perc=99.99 where id=4";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt=con.createStatement();
			
			// ADD DML QUERIES//
			stmt.addBatch(inqry);
			stmt.addBatch(delqry);
			stmt.addBatch(upqry);
			
			// EXECUTE BATCH UPDATE//
			int arr[]=stmt.executeBatch();
			for (int i : arr) {
				System.out.print(i);
			}
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
			System.out.println("Costly resources closed!!!");
		}
	}
}
