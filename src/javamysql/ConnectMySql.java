package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectMySql {
	private static ConnectMySql instance = new ConnectMySql();
	
	public static ConnectMySql getInstance() {
		return instance;
	}
	
	public ConnectMySql() {
		
	}
	String jdbcUrl = "jdbc:mysql://mydbcdy.c7w7upkmq0xt.ap-northeast-2.rds.amazonaws.com:3306/dragoncdy?useUnicode=true&characterEncoding=euckr&characterSetResults=euckr";
								   
	String dbId = "cdyadmin";
	String dbPw = "dragon12^^";
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	String sql = "";
	String sql2 = "";
	String returns = "a";
	
	public String connectionDB(String id, String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select id from example where id = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				returns = "가입불가";
			}else {
				sql2 = "insert into example values(?, ?);";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pw);
				pstmt2.executeQuery();
				returns = "가입";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt2 != null)try {pstmt2.close();}catch(SQLException ex) {}
			if(pstmt != null)try {pstmt.close();}catch(SQLException ex) {}
		}
		return returns;
	}
}
