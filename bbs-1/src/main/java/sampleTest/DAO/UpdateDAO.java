package sampleTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import sampleTest.entity.Thread;

public class UpdateDAO {
	
	//データベース接続と結果取得のための変数
			private Connection con;
			private PreparedStatement pstmt;
			private ResultSet rs;
			
	//更新のメソッド
	public void update(Thread thread) {
		
		try {
			this.getConnection();
			
			pstmt = con.prepareStatement("update thread set name=?,content=?,post_day=? where thread_id = ?");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			pstmt.setString(1, thread.getName());
			pstmt.setString(2, thread.getContent());
			pstmt.setTimestamp(3,thread.setPost_day(timestamp) );
			pstmt.setInt(4, thread.getThread_id());
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		
	}
	
	public void getConnection() throws SQLException, ClassNotFoundException {
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
			}catch(SQLException e) {
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
