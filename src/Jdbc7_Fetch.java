
/* Code to Fetch a Particular Record from the cursor or buffer memory where id=?  */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc7_Fetch {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from Interview.Roy where id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id???");
		int id=sc.nextInt();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Established connection with database server");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			// SET THE VALUE OF PLACEHOLDER BEFORE EXECUTION /
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println(name+" "+perc);
			}
			else{
				System.err.println("id not fond!!!!!");
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
