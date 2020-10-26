


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc9_LoginValidation {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select username from Interview.Rai where name=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name??");
		String name=sc.nextLine();
		System.out.println("ENter password??");
		String password=sc.nextLine();
		sc.close();
		
            try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				pstmt=con.prepareStatement(qry);
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					String username=rs.getString(1);
					System.out.println("Welcome "+username);
				}
				else {
					System.err.println("username and passwors is not valid!!");
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
            System.out.println("costly resources closed!!!");
	}
}
