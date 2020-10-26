
/* Code to Insert multiple data into the Database Server using PreparedStatement interface with PlaceHolder:  */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc5_Insert {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into Interview.Roy values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection Established with database server ");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			// SET THE VALUE OF PLACEHOLDER BEFORE EXECUTION //
			pstmt.setInt(1,5);
			pstmt.setString(2, "Pappu Rai");
			pstmt.setDouble(3, 76.40);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,6);
			pstmt.setString(2, "Vicky Rai");
			pstmt.setDouble(3, 66.44);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,7);
			pstmt.setString(2, "Saroj Rai");
			pstmt.setDouble(3, 77.77);
			pstmt.executeUpdate();
			System.out.println("Data Inserted Successfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
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
