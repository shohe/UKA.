package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class VotesDao {


	private Connection con;
	
	public VotesDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context
				.lookup("java:comp/env/jdbc/ukasystem");
		con = ds.getConnection();
	}
	
	// コネクション
	public VotesDao(Connection con) throws NamingException, SQLException {
		this.con = con;
	}
	
	public int Voteupdate(int post_id) throws SQLException {
		System.out.println("LIKEボタンアップカウントdao到達");
		PreparedStatement update = con
				.prepareStatement("update postings set possession_vote = possession_vote + 1 where posting_id = ?");
		update.setInt(1, post_id);
		System.out.println("update完了");
		return update.executeUpdate();
	}
	
	/**
	 * 接続を閉じる
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		con.close();
	}

	/**
	 * コミット
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		System.out.println("commit通る");
		con.commit();
		con.close();
	}
	
	/**
	 * ロールバック
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		try {
			this.con.close();
		} catch (SQLException e) {
			this.con = null;
			throw e;
		}
	}
	
}
