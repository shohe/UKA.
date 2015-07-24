package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import hal.tokyo.beans.AdminMailsViewBean;

/**
 *
 * @author enfumidayo
 *
 */
public class AdminMailsViewDao {
	private Connection connection;
	public PreparedStatement preparedStatement;

	/**
	 *
	 * @throws NamingException
	 * @throws SQLException
	 */
	public AdminMailsViewDao() throws NamingException, SQLException {
		InitialContext initialContext = new InitialContext();
		DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/ukasystem");
		this.connection = dataSource.getConnection();
		this.connection.setAutoCommit(false);
	}

	/**
	 *
	 * @param connection
	 * @throws NamingException
	 * @throws SQLException
	 */
	public AdminMailsViewDao(Connection connection) throws NamingException, SQLException {
		this.connection = connection;
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<AdminMailsViewBean> read(String userId) throws SQLException {
		ArrayList<AdminMailsViewBean> arrayList = new ArrayList<AdminMailsViewBean>();
		this.preparedStatement = this.connection
				.prepareStatement("UPDATE `administrator_mail` SET `STATUS`=2 WHERE `USER_ID` = ? AND `STATUS` = 1");
		this.preparedStatement.setString(1, userId);
		this.preparedStatement.executeUpdate();
		this.preparedStatement = this.connection
				.prepareStatement("SELECT `DATE`, `TITLE`, `CONTENT` FROM `administrator_mail` WHERE `USER_ID` = ?");
		this.preparedStatement.setString(1, userId);
		ResultSet resultSet = this.preparedStatement.executeQuery();
		while (resultSet.next()) {
			AdminMailsViewBean adminMailsViewBean = new AdminMailsViewBean();
			adminMailsViewBean.setDate(resultSet.getString("DATE"));
			adminMailsViewBean.setTitle(resultSet.getString("TITLE"));
			adminMailsViewBean.setContent(resultSet.getString("CONTENT"));
			arrayList.add(adminMailsViewBean);
		}
		return arrayList;
	}

	public int checkNewAdminMail(String userId) throws SQLException {
		this.preparedStatement = this.connection
				.prepareStatement("SELECT `COUNT(*) FROM `administrator_mail` WHERE `USER_ID` = ? AND `STATUS` = 1");
		this.preparedStatement.setString(1, userId);
		ResultSet resultSet = this.preparedStatement.executeQuery();
		int cntNewAdminMail = resultSet.getInt("COUNT(*)");
		return cntNewAdminMail;
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
