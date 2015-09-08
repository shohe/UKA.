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

public class PostingsDao {

	/** Connection **/
	private Connection con;
	/**
	 * コンストラクタ
	 * @param con
	 */

	public PostingsDao(){

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

	public PostingsDao(Connection con){
		this.con = con;
	}



	/**
	 * 投稿IDから投稿を取得するメソッド
	 *
	 * @param posting_id
	 * @return
	 * @throws SQLException
	 */

	/** ------------------------- 1件だけランダム取得 --------------------------------- **/

	public ArrayList<PostingsBean> getOneRandom() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
		"SELECT postings.mailaddress , postings.posting_id , postings.title, departments.department_name, users.name, posting_content.posting_content, "
				+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage , terms.achievement_vote, postings.date , "
				+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
				+ "FROM postings "
				+ "JOIN terms ON terms.terms_id = postings.terms_id "
				+ "JOIN users ON users.mailaddress = postings.mailaddress "
				+ "JOIN posting_content ON posting_content.posting_content_id = postings.posting_content_id "
				+ "JOIN departments ON departments.department_id = users.department_id "
				+ " WHERE postings.status = 1 ORDER BY RAND() LIMIT 1;");

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
			Bean.setPosting_content(rs.getString("posting_content"));
			table.add(Bean);
		}

		return table;
	}

	/** ------------------------- 全件取得 --------------------------------- **/
	public ArrayList<PostingsBean> getPostings() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
				+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
				+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
				+ "FROM postings "
				+ "JOIN terms ON terms.terms_id = postings.terms_id "
				+ "JOIN users ON users.mailaddress = postings.mailaddress "
				+ "JOIN departments ON departments.department_id = users.department_id "
				+ "WHERE postings.status = 1 HAVING timelimit > 0");

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
	//statusは１が生存 ０が死亡
	public ArrayList<PostingsBean> searchChar(String SearchChar) throws SQLException{

		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0");
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
	//新着順
	public ArrayList<PostingsBean> sortNew() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "WHERE postings.status = 1 HAVING timelimit > 0 ORDER BY date DESC"
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

	//文字がある時
	public ArrayList<PostingsBean> sortNew(String SearchChar) throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0 ORDER BY date DESC;"
				);
		ArrayList<PostingsBean> table = new ArrayList<PostingsBean>();
		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);
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
	//人気順(投票数が多い順)
	public ArrayList<PostingsBean> sortFavor() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.posting_id , postings.title, departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings "
						+ "JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "WHERE postings.status = 1 HAVING timelimit > 0 ORDER BY achievement_percentage DESC");

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

	//文字があった場合
	public ArrayList<PostingsBean> sortFavor(String SearchChar) throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0 ORDER BY achievement_percentage DESC ;"
						);


		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);

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

	public ArrayList<PostingsBean> sortNearDeadline(String SearchChar) throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0 ORDER BY timelimit ;");

		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);

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
	
	/** ------------------------- プロジェクト許可 --------------------------------- **/
	public int ProjectOk(String title) throws SQLException {
		System.out.println("ジャッジするdao到達!!!!!");
		PreparedStatement update = con
				.prepareStatement("update postings set status = 3 where title = ?;");
		update.setString(1, title);
		System.out.println("ジャッジ側の"+title);
		return update.executeUpdate();
	}
	
	/** ------------------------- プロジェクト保留 --------------------------------- **/
	public int ProjectNo(String title) throws SQLException {
		System.out.println("ジャッジするdao(保留)到達!!!!!");
		PreparedStatement update = con
				.prepareStatement("update postings set status = 2 where title = ?;");
		update.setString(1, title);
		System.out.println("ジャッジ側の"+title);
		return update.executeUpdate();
	}

	
	/** ------------------------- 評価数が高い --------------------------------- **/
	//評価数が高い
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

	public ArrayList<PostingsBean> sortHigh(String SearchChar) throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0 ORDER BY possesion_Vote");

		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);

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

	/** ------------------------- 評価数が低い --------------------------------- **/
	//評価数が低い
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

	public ArrayList<PostingsBean> sortLow(String SearchChar) throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.mailaddress ,postings.title, postings.posting_id ,departments.department_name, users.name, "
						+ "users.image, users.profilecomment, postings.possession_vote / terms.achievement_vote * 100 AS achievement_percentage, terms.achievement_vote, "
						+ "DATEDIFF( DATE_ADD( ( postings.date ), INTERVAL( SELECT terms.terms_period FROM terms WHERE terms.terms_id = postings.terms_id ) DAY ) , CURRENT_DATE( ) ) AS timelimit "
						+ "FROM postings JOIN terms ON terms.terms_id = postings.terms_id "
						+ "JOIN users ON users.mailaddress = postings.mailaddress "
						+ "JOIN departments ON departments.department_id = users.department_id "
						+ "JOIN posting_content ON postings.posting_content_id = posting_content.posting_content_id "
						+ "WHERE postings.title LIKE  '%' || ? || '%' OR posting_content.posting_content LIKE  '%' || ? || '%' "
						+ "AND postings.status =1 HAVING timelimit >0 ORDER BY possesion_Vote DESC");


		pstm.setString(1, SearchChar);
		pstm.setString(2, SearchChar);

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

}
