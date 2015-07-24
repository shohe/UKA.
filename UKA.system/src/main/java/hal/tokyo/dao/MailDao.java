package hal.tokyo.dao;

import hal.tokyo.beans.Administrator_MAILBean;
import hal.tokyo.beans.Enquiry_MAILBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

		ArrayList<Enquiry_MAILBean> table = new ArrayList<Enquiry_MAILBean>();

		PreparedStatement select = con.prepareStatement("select * from enquiry_mail");

		ResultSet result = select.executeQuery();

		while(result.next()){

			Enquiry_MAILBean emb = new Enquiry_MAILBean();

			emb.setEnquiry_id(result.getInt("enquiry_id"));
			emb.setDate(result.getString("date"));
			emb.setUser_id(result.getString("user_id"));
			emb.setEnquiry_type_id(result.getInt("enquiry_type_id"));
			emb.setEnquiry_content(result.getString("enquiry_content"));

			table.add(emb);

		}
		result.close();
		select.close();
		con.close();

		return table;

	}
	
	public List<Enquiry_MAILBean> AllAdminMailselect() throws SQLException{

		ArrayList<Enquiry_MAILBean> table = new ArrayList<Enquiry_MAILBean>();

		PreparedStatement select = con.prepareStatement("select * from enquiry_mail;");

		ResultSet result = select.executeQuery();

		while(result.next()){

			Enquiry_MAILBean emb = new Enquiry_MAILBean ();

			emb.setEnquiry_id(result.getInt("enquiry_id"));
			emb.setDate(result.getString("date"));
			emb.setEnquiry_title(result.getString("enquiry_title"));
			emb.setEnquiry_content(result.getString("enquiry_content"));
			emb.setUser_id(result.getString("user_id"));

			table.add(emb);

		}
		result.close();
		select.close();
		con.close();

		return table;

	}
	
	public List<Enquiry_MAILBean> AdminMailselect(String enquiry_id) throws SQLException{

		ArrayList<Enquiry_MAILBean> table = new ArrayList<Enquiry_MAILBean>();

		PreparedStatement select = con.prepareStatement("select * from enquiry_mail where enquiry_id = ?");
		select.setString(1, enquiry_id);

		ResultSet result = select.executeQuery();

		while(result.next()){

			Enquiry_MAILBean emb = new Enquiry_MAILBean();

			emb.setDate(result.getString("date"));
			emb.setEnquiry_title(result.getString("enquiry_title"));
			emb.setEnquiry_content(result.getString("enquiry_content"));
			emb.setUser_id(result.getString("user_id"));

			table.add(emb);

		}
		result.close();
		select.close();
		con.close();
		return table;

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
		update.close();
		con.close();
		return update.executeUpdate();
	}
	
	public int AdminMailinsert(String user_id, String title, String content) throws SQLException {
		System.out.println("管理者メールインサートdao到達!!!!!");
		PreparedStatement update = con
				.prepareStatement("insert into administrator_mail (user_id,title,content,status) values (?,?,?,1);");
		update.setString(1, user_id);
		update.setString(2, title);
		update.setString(3, content);
		System.out.println("MailDao側の"+user_id);
		System.out.println("MailDao側の"+title);
		System.out.println("MailDao側の"+content);
		return update.executeUpdate();
	}


	
	public int Enqinsert(String MailAddress, String enq_id, String kenmei, String naiyou) throws SQLException {
		System.out.println("Enqのインサートdao到達");
		System.out.println(MailAddress);
		System.out.println(enq_id);
		System.out.println(kenmei);
		System.out.println(naiyou);

		PreparedStatement update = con
				.prepareStatement("insert into enquiry_mail (user_id,enquiry_type_id,enquiry_title,enquiry_content) values (?,?,?,?);");
		update.setString(1, MailAddress);
		update.setString(2, enq_id);
		update.setString(3, kenmei);
		update.setString(4, naiyou);

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
		System.out.println("rollback到達...");
		con.rollback();
		System.out.println("rollback完了");
	}

}
