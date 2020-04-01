package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {
	//입력, 삭제
	
	Connection con;
	Statement stmt;
	
	public PreparedStatement() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"proj1",
					"1234");
			System.out.println("오라클 DB 연결 성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외 발생");
		}
	}//end of PreparedStatement
	
	private void createTB() {
		try {
			stmt = con.createStatement();
			
			String sql = "INSERT INTO phonebook_tb VALUES (?, ?, ?, ?)";
					+ "('')"
		}
	}
}
