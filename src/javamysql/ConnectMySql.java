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
	private String jdbcUrl = "jdbc:mysql://mydbcdy.c7w7upkmq0xt.ap-northeast-2.rds.amazonaws.com:3306/dragoncdy?useUnicode=true&characterEncoding=euckr&characterSetResults=euckr&useSSL=false";
								   
	private String dbId = "cdyadmin";
	private String dbPw = "dragon12^^";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	private String sql = "";
	private String sql2 = "";
	String returns = "";
	String returns2 = "";
	
	
	public String connectionDB(String id, String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "SELECT id FROM dragoncdy.EXAMPLE where id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("id").equals(id)){ 
					returns = "id";
				}
			}else {
				sql2 = "insert into dragoncdy.EXAMPLE values(?, ?);";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pw);
				pstmt2.executeUpdate();
				returns = "ok";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null)try {conn.close();}catch(SQLException ex) {}
			if(pstmt2 != null)try {pstmt2.close();}catch(SQLException ex) {}
			if(rs != null)try {rs.close();}catch(SQLException ex) {}
		}
		return returns;
	}
	public String logindb(String id, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select id, pw from dragoncdy.EXAMPLE where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("id").equals(id)&&rs.getString("pw").equals(pwd)) {
					returns2 = "true";
				}else {
					returns2 = "false";
				}
			}else{
				returns2 = "noId";
			}
		}catch(Exception e) {
			
		}finally {
		if (rs != null)try {rs.close();} catch (SQLException ex) {}
		if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
		if (conn != null)try {conn.close();} catch (SQLException ex) {}
		}
		return returns2;
	}
	public String write (String title, String content, String ddate) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "insert into dragoncdy.TestBoard (title, content, ddate) values(?, ?, ?)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, title);
			pstmt2.setString(2, content);
			pstmt2.setString(3, ddate);
			pstmt2.executeUpdate();
			returns = "ok";
		}catch(Exception e) {
			
		}finally {
			if (rs != null)try {rs.close();} catch (SQLException ex) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
			}
			return returns2;
	}
}
