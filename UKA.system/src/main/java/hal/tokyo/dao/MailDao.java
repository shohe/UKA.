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
	
	public int Mailinsert(String id, String title, String content) throws SQLException {
		System.out.println("dao到達");
		PreparedStatement update = con
				.prepareStatement("insert into administrator_mail (user_id,title,content) into (?,?,?);");
		update.setString(1, id);
		update.setString(2, title);
		update.setString(3, content);
		System.out.println("insert完了");
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
