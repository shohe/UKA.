package hal.tokyo.dao;

import hal.tokyo.beans.UsersBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdminAuthorityDao {

	/** Connection **/
	private Connection con;
	/**
	 * コンストラクタ
	 * @param con
	 */

	public AdminAuthorityDao(){

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

	public AdminAuthorityDao(Connection con){
		this.con = con;
	}

	/** ------------------------- 全件取得 --------------------------------- **/
	public ArrayList<UsersBean> getAllUsers() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
				"SELECT users.mailaddress , users.name , departments.department_name "
				+ "FROM users JOIN departments on users.department_id = departments.department_id ");

		ResultSet rs = pstm.executeQuery();

		ArrayList<UsersBean> table = new ArrayList<UsersBean>();

		rs.beforeFirst();

		while(rs.next()){
			UsersBean Bean = new UsersBean();
			Bean.setMailaddress(rs.getString("mailaddress"));
			Bean.setName(rs.getString("name"));
			Bean.setDepartment_name(rs.getString("department_name"));
			table.add(Bean);
		}
		//クローズ処理
		rs.close();
		pstm.close();
		con.close();
		return table;
	}



}
