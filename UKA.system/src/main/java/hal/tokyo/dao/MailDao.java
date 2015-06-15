package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MailDao {

	private Connection con;
	
	public MailDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context
				.lookup("java:comp/env/jdbc/ukasystem");
		con = ds.getConnection();
	}
	
	// コネクション
	public MailDao(Connection con) throws NamingException, SQLException {
		this.con = con;
	}
	
	public int Mailinsert(String newRecord, String newRecord2) throws SQLException {
		// stockテーブルupdate文
		System.out.println("update突入");
		System.out.println(newRecord);
		System.out.println(newRecord2);
		PreparedStatement update = con
				.prepareStatement("update stock SET order_stock_count =? WHERE stock_product_id = ?");
		update.setString(1, newRecord2);
		update.setString(2, newRecord);
		System.out.println("update1完了");
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
		con.commit();
	}

}
