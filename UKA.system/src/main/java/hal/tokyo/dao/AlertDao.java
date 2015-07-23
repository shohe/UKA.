package hal.tokyo.dao;

import hal.tokyo.beans.PostingsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AlertDao {

	private Connection con;

	public AlertDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context
				.lookup("java:comp/env/jdbc/ukasystem");
		con = ds.getConnection();
	}

	//SELECT * FROM `postings` WHERE date < date_sub(now(), interval 20 day);
	// コネクション
	public AlertDao(Connection con) throws NamingException, SQLException {
		this.con = con;
	}

	public ArrayList<PostingsBean> AllMailselect() throws SQLException{

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();

		PreparedStatement select = con.prepareStatement("SELECT * FROM `postings` WHERE user_id = 'aaaaaaaa' and possession_vote > 200 and status = '1';");

		ResultSet result = select.executeQuery();

		while(result.next()){

			PostingsBean emb = new PostingsBean();

			emb.setPosting_Id(result.getInt("posting_id"));
			emb.setUser_Id(result.getString("user_id"));
			emb.setPossesion_Vote(result.getInt("possession_vote"));
			emb.setTitle(result.getString("title"));

			table.add(emb);

		}

		select.close();

		return table;

	}
	

	//掲載期間終了した投稿を取得
	public ArrayList<PostingsBean> AllEndContents() throws SQLException{

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();

		PreparedStatement select = con.prepareStatement("SELECT * FROM `postings` WHERE user_id = 'bbbbbbbb' and date < date_sub(now(), interval 5 day);");

		ResultSet result = select.executeQuery();

		while(result.next()){

			PostingsBean emb = new PostingsBean();

			emb.setPosting_Id(result.getInt("posting_id"));
			emb.setUser_Id(result.getString("user_id"));
			emb.setData(result.getString("date"));
			emb.setPossesion_Vote(result.getInt("possession_vote"));
			emb.setTitle(result.getString("title"));

			table.add(emb);

		}

		select.close();

		return table;

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

