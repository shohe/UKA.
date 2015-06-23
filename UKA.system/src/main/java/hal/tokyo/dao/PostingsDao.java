package hal.tokyo.dao;

import hal.tokyo.beans.PostingsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostingsDao {

	/** Connection **/
	private Connection con;
	/**
	 * コンストラクタ
	 * @param con 
	 */
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
	public PostingsBean getPostings() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT user_id , date , possession_vote , posting_type_id , status , title , posting_content_id "
				+ "FROM POSTINGS JOIN POSTING_TYPE ON POSTING.posting_type_id = POSTING_TYPE.posting_type_id"
				+ "WHERE posting_id = ?");
		pstm.setInt(1, posting_id);
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		
		while(rs.next()){
			Bean.setUser_Id(rs.getString("user_id"));
			Bean.setData(rs.getString("date"));
			Bean.setPossesion_Vote(rs.getInt("possesion_Vote"));
			Bean.setPosting_Type_Id(rs.getInt("posting_Type_Id"));
			Bean.setStatus(rs.getInt("status"));
			Bean.setTitle(rs.getString("title"));
			Bean.setPosting_Content_Id(rs.getInt("posting_Content_Id"));
		}
		
		return Bean;
	}
	
	//文字で検索
	public PostingsBean sortChar(String SearchChar) throws SQLException{
		
		PreparedStatement pstm = con.prepareStatement(
				"SELECT postings.title, departments.department_name, users.name, "
				+ "users.image, users.profilecomment, terms.achievement_percentage, terms.achievement_vote "
				+ "FROM postings "
				+ "JOIN terms ON terms.terms_id = postings.terms_id "
				+ "JOIN users ON users.mailaddress = postings.user_id "
				+ "JOIN departments ON departments.department_id = users.department_id "
				+ "WHERE postings.title LIKE  '%"+ SearchChar +"%'");
		pstm.setString(1, SearchChar);
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		
		while(rs.next()){
			Bean.setTitle(rs.getString("title"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setName(rs.getString("name"));
			Bean.setImage(rs.getString("image"));
			Bean.setProfilecomment(rs.getString("profilecomment"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
			Bean.setAchievement_vote(rs.getInt("achievement_vote"));
			
			
		}
		
		return Bean;
	}
	
	//新着順
	public PostingsBean sortNew() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"select * from POSTINGS ORDER BY date DESC");
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		return Bean;
	}
	
	//人気順(投票数が多い順)
	public PostingsBean sortFavor() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT users.name, departments.department_name, postings.title, product_content.posting_content ,terms.achievement_percentage "
				+ "FROM postings JOIN terms ON postings.POSTING_TYPE_ID = terms.POSTING_TYPE_ID JOIN users ON postings.user_id = users.mailaddress "
				+ "JOIN departments ON departments.department_id = users.department_id JOIN product_content "
				+ "ON product_content.posting_content_id = postings.posting_content_id ORDER BY  achievement_percentage DESC");
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		
		while(rs.next()){
			Bean.setName(rs.getString("name"));
			Bean.setDepartment_name(rs.getString("department_name"));
			Bean.setTitle(rs.getString("title"));
			Bean.setPosting_Content(rs.getString("posting_content"));
			Bean.setAchievement_percentage(rs.getInt("achievement_percentage"));
		}
		
		
		return Bean;
	}
	
	//締切はどうするか
	public PostingsBean sortNearDeadline() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"select * from POSTINGS ORDER BY possesion_Vote");
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		return Bean;
	}
	
	//評価数が高い
	public PostingsBean sortHigh() throws SQLException{
		PreparedStatement pstm = con.prepareStatement("select * from POSTINGS ORDER BY possesion_Vote");
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		return Bean;
	}
	
	//評価数が低い
	public PostingsBean sortLow() throws SQLException{
		PreparedStatement pstm = con.prepareStatement("select * from POSTINGS ORDER BY possesion_Vote DESC");
		
		ResultSet rs = pstm.executeQuery();
		PostingsBean Bean = new PostingsBean();
		return Bean;
	}
}
