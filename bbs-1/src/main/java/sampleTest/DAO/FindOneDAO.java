package sampleTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sampleTest.entity.Thread;

public class FindOneDAO {
	
	//データベース接続と結果取得のための変数
		private Connection con;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
	//1件取得のメソッド
		public Thread findOne(int thread_id) {
			Thread thread = null;
			try {
				this.getConnection();
				
				pstmt = con.prepareStatement("select * from thread where thread_id=?");
				pstmt.setInt(1, thread_id);
				
				rs = pstmt.executeQuery();
				
				//1件表示
				if(rs.next()) {
					thread = new Thread();
					thread.setThread_id(rs.getInt("thread_id"));
					thread.setName(rs.getString("name"));
					thread.setContent(rs.getString("content"));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				this.close();
			}
			return thread;
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
