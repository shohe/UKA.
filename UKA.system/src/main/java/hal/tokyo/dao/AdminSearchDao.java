package hal.tokyo.dao;

import hal.tokyo.beans.PostingsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdminSearchDao {

	/** Connection **/
	private Connection con;
	/**
	 * コンストラクタ
	 * @param con
	 */

	public AdminSearchDao(){

		try {

		InitialContext context;
			context = new InitialContext();
		DataSource ds;
			ds = (DataSource) context
					.lookup("java:comp/env/jdbc/ukasystem");

		con = ds.getConnection();

		} catch (NamingException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public AdminSearchDao(Connection con){
		this.con = con;
	}




	/** ------------------------- 全件取得 --------------------------------- **/
	public ArrayList<PostingsBean> getAllPostings() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress , postings.posting_id , postings.title, departments.department_name, users.name, "
				+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage , terms.achievement_vote, postings.date , "
				+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
				+ "FROM postings "
				+ "JOIN terms ON terms.terms_id = postings.terms_id "
				+ "JOIN users ON users.mailaddress = postings.mailaddress "
				+ "JOIN departments ON departments.department_id = users.department_id ");

		ResultSet rs = pstm.executeQuery();

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();

		rs.beforeFirst();

		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setDate(rs.getString("date"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}


	/** ------------------------- 文字検索 --------------------------------- **/
	public ArrayList<PostingsBean> adminSearchChar(String SearchChar) throws SQLException{

		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage , terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' ");
		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);
		ResultSet rs = pstm.executeQuery();
		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();

		rs.beforeFirst();
		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setDate(rs.getString("date"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}

	/** ------------------------- 新着順 --------------------------------- **/

	public ArrayList<PostingsBean> sortNew() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "ORDER BY date DESC"
				);

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}
	/** ------------------------- 人気順 --------------------------------- **/

	public ArrayList<PostingsBean> sortFavor() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "ORDER BY achievement_percentage DESC");

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();
		ResultSet rs = pstm.executeQuery();

		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}
	/** ------------------------- 締切 --------------------------------- **/
	public ArrayList<PostingsBean> sortNearDeadline() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "WHERE postings.status = 1 HAVING timelimit > 0  ORDER BY timelimit ;");

		ResultSet rs = pstm.executeQuery();

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();

		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}
	/** ------------------------- 評価高 --------------------------------- **/
	public ArrayList<PostingsBean> sortHigh() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "WHERE postings.status = 1 HAVING timelimit > 0 ORDER BY possesion_Vote");
		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();
		ResultSet rs = pstm.executeQuery();

		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}
	/** ------------------------- 評価低 --------------------------------- **/
	public ArrayList<PostingsBean> sortLow() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "WHERE postings.status = 1 HAVING timelimit > 0 ORDER BY possesion_Vote DESC");

		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();
		ResultSet rs = pstm.executeQuery();

		while(rs.next()){
			PostingsBean Bean = new PostingsBean();
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			Bean.setTimelimit(rs.getInt("timelimit"));
			Bean.setPost_id(rs.getInt("posting_id"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}
}
