package sampleTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import sampleTest.entity.Thread;

public class InsertThreadDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//１件登録用のメソッド
	public void insertThread(Thread thread) {
		try {
			//ドライバを読み込みDBに接続
			this.getConnection();
			
			//Statementオブジェクトの作成
			pstmt = con.prepareStatement("insert into thread (name,content,post_day) values(?,?,?)");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			pstmt.setString(1, thread.getName());
			pstmt.setString(2, thread.getContent());
			pstmt.setTimestamp(3,thread.setPost_day(timestamp));
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
	}
	
	public void getConnection() throws SQLException,ClassNotFoundException {
		//ドライバクラスの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//DBと接続
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs?useSSL=false&characterEncoding=utf8","root","inoue712");
		
	}
	
	private void close() {
		//接続を閉じる
		if(rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

















