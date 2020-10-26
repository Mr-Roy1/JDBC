
/* Code for JDBC Transaction:  */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc12_Transaction {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String qry1="insert into Interview.tran1 values(?,?,?,?)";
		String qry2="insert into Interview.tran2 values(?,?,?)";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id?");
		int id=sc.nextInt();
		System.out.println("Enter name?");
		String name=sc.next();
		System.out.println("Enter department?");
		String dept=sc.next();
		System.out.println("ENter percentage?");
		double perc=sc.nextDouble();
		System.out.println("Enter place?");
		String place=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			
			pstmt=con.prepareStatement(qry1);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
			pstmt.executeUpdate();
			System.out.println("tran1 details executed");
			
			pstmt1=con.prepareStatement(qry2);
			pstmt1.setInt(1,id);
			pstmt1.setString(2,name);
			pstmt1.setString(3,place);
			pstmt1.executeUpdate();
			System.out.println("tran2 details executed");
			con.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
				System.out.println("operatios rolled back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
			System.out.println("Costly resources closed");
		}
	}
}
