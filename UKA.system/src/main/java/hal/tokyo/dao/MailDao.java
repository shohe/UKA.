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
	
	public int Mailinsert(String user_id, String post_id, String title, String content) throws SQLException {
		System.out.println("管理者メールインサートdao到達");
		PreparedStatement update = con
				.prepareStatement("insert into administrator_mail (user_id,title,content,posting_id) values (?,?,?,?);");
		update.setString(1, user_id);
		update.setString(2, title);
		update.setString(3, content);
		update.setString(4, post_id);
		System.out.println("insert完了");
		return update.executeUpdate();
	}
	
	public int Enqinsert(String id, String enq, String content) throws SQLException {
		System.out.println("Enqのインサートdao到達");
		PreparedStatement update = con
				.prepareStatement("insert into enquiry_mail (user_id,enquiry_type_id,enquiry_content) values (?,?,?);");
		update.setString(1, id);
		update.setString(2, enq);
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
