

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc11_Batch {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String inqry="insert into interview.roy values (7,'Manoj Rai',78.78)";
		String delqry="delete from interview.rai where id=5";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(inqry);
			pstmt.addBatch();
			int arr[]=pstmt.executeBatch();
			for (int i : arr) {
				System.out.print(i);
			}
			
			pstmt1=con.prepareStatement(delqry);
			pstmt1.addBatch();
			int arr1[]=pstmt1.executeBatch();
			for (int j : arr1) {
				System.out.print(j);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt1!=null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
			System.out.println("Costly resources closed!!");
		}
	}
}
