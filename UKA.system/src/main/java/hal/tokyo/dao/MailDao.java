package hal.tokyo.dao;

import hal.tokyo.beans.Enquiry_MAILBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

	public List<Enquiry_MAILBean> AllMailselect() throws SQLException{

		PreparedStatement select = con.prepareStatement("select * from administrator_mail");

		return null;

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

	public int Enqinsert(String enq_id, String kenmei, String naiyou) throws SQLException {
		System.out.println("Enqのインサートdao到達");
		PreparedStatement update = con
				.prepareStatement("insert into enquiry_mail (user_id,enquiry_type_id,enquiry_title,enquiry_content) values ('testman',?,?,?);");
		update.setString(1, enq_id);
		update.setString(2, kenmei);
		update.setString(3, naiyou);
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
		System.out.println("commit到達...");
		con.commit();
		System.out.println("commit完了");
	}

	public void rollback() throws SQLException {
		System.out.println("commit到達...");
		con.rollback();
		System.out.println("commit完了");
	}

}
