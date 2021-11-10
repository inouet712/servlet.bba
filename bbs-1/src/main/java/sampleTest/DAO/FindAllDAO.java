package sampleTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sampleTest.entity.Thread;

public class FindAllDAO {
	//データベース接続と結果取得のための変数
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//全権取得のメソッド
	public List<Thread> findAll() {
		//メソッドの結果として返すリスト
		List<Thread> results = new ArrayList<Thread>();
		
		try {
			//ドライバを読み込みDBに接続
			this.getConnection();
			//Statementオブジェクトの作成
			pstmt = con.prepareStatement("select * from thread order by thread_id desc;");
			//Select文実行
			rs = pstmt.executeQuery();
			
			//結果を表示する
			while(rs.next()) {
				Thread thread = new Thread();
				thread.setThread_id(rs.getInt("thread_id"));
				thread.setName(rs.getString("name"));
				thread.setContent(rs.getString("content"));
				thread.setPost_day(rs.getTimestamp("post_day"));
				
				//リストに追加
				results.add(thread);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return results;
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
