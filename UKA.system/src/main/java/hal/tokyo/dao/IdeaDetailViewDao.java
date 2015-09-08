package hal.tokyo.dao;

import hal.tokyo.beans.IdeaDetailViewBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author enfumidayo
 *
 */
public class IdeaDetailViewDao {
	private Connection connection;
	public PreparedStatement preparedStatement;

	/**
	 *
	 * @throws NamingException
	 * @throws SQLException
	 */
	public IdeaDetailViewDao() throws NamingException, SQLException {
		InitialContext initialContext = new InitialContext();
		DataSource dataSource = (DataSource) initialContext
				.lookup("java:comp/env/jdbc/ukasystem");
		this.connection = dataSource.getConnection();
		this.connection.setAutoCommit(false);
	}

	/**
	 *
	 * @param connection
	 * @throws NamingException
	 * @throws SQLException
	 */
	public IdeaDetailViewDao(Connection connection) throws NamingException,
			SQLException {
		this.connection = connection;
	}

	/**
	 *
	 * @param postId
	 * @return
	 * @throws SQLException
	 */
	public IdeaDetailViewBean read(int postId) throws SQLException {
		IdeaDetailViewBean ideaDetailViewBean = new IdeaDetailViewBean();
		this.preparedStatement = this.connection
				.prepareStatement("SELECT p.title, p.date, c.posting_content, u.image, u.name, d.department_name, u.profilecomment, p.possession_vote / t.achievement_vote * 100 AS achievement_percentage, p.possession_vote, DATEDIFF( DATE_ADD( (p.date), INTERVAL( SELECT t.terms_period FROM postings p, terms t WHERE t.terms_id = p.terms_id AND p.posting_id = ? ) DAY), CURRENT_DATE() ) AS timelimit FROM postings p, posting_content c, users u, departments d, terms t WHERE p.posting_content_id = c.posting_content_id AND p.mailaddress = u.mailaddress AND u.department_id = d.department_id AND p.terms_id = t.terms_id AND p.posting_id = ?");
		this.preparedStatement.setInt(1, postId);
		this.preparedStatement.setInt(2, postId);
		ResultSet resultSet = this.preparedStatement.executeQuery();
		resultSet.next();
		ideaDetailViewBean.setTitle(resultSet.getString("title"));
		ideaDetailViewBean.setDate(resultSet.getString("date"));
		ideaDetailViewBean.setPosting_content(resultSet
				.getString("posting_content"));
		ideaDetailViewBean.setImage(resultSet.getString("image"));
		ideaDetailViewBean.setName(resultSet.getString("name"));
		ideaDetailViewBean.setDepartment_name(resultSet
				.getString("department_name"));
		ideaDetailViewBean.setProfilecomment(resultSet
				.getString("profilecomment"));
		ideaDetailViewBean.setPossession_vote(resultSet
				.getInt("possession_vote"));
		ideaDetailViewBean.setAchievement_percentage(resultSet
				.getInt("achievement_percentage"));
		ideaDetailViewBean.setTimelimit(resultSet.getInt("timelimit"));
		return ideaDetailViewBean;
	}

	/**
	 *
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		this.connection.commit();
	}

	/**
	 *
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		try {
			this.connection.close();
		} catch (SQLException e) {
			this.connection = null;
			throw e;
		}
	}
}
