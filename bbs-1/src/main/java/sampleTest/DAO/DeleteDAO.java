package sampleTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDAO {
	
	//データベース接続のための変数
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//削除のメソッド
	public void delete(int thread_id) {
		try {
			//ドライバを読み込みDBに接続
			this.getConnection();
			
			//Ststementオブジェクトの作成
			pstmt = con.prepareStatement("delete from thread where thread_id = ?;");
			pstmt.setInt(1,thread_id);
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
		
		//DBとの接続
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
