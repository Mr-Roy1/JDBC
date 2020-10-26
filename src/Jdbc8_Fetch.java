
/* Code to Fetch a Particular Record from the cursor or buffer memory where name=?  */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc8_Fetch {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from Interview.Roy where name=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name???");
		String name=sc.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			pstmt.setString(1,name);
			// EXECUTE SQL QUERY //
			rs=pstmt.executeQuery();
			if(rs.next()){
				int id=rs.getInt("id");
				double perc=rs.getDouble(3);
				System.out.println(id+" "+perc);
			}
			else {
				System.err.println("No Data Found For Name: "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
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
		}
	}
}
