package hal.tokyo.dao;

import hal.tokyo.beans.UsersBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class UsersDao {

	/** Connection **/
	private Connection con;

	public UsersDao(){



	}

	public UsersDao(Connection con) throws NamingException, SQLException{
		this.con = con;
	}

	/**
	 * ユーザーテーブル全データ取得
	 *
	 * @author UKA.System
	 *
	 * @return table
	 * @throws SQLException
	 */
	public List<UsersBean> findAll() throws SQLException{

		PreparedStatement findAll = con.prepareStatement("select * from users");

		ResultSet result = findAll.executeQuery();

		ArrayList<UsersBean> table = new ArrayList<UsersBean>();

		while(result.next()){

			UsersBean record = new UsersBean();

			record.setMailAddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getString("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

			table.add(record);
		}

		return table;

	}


	/**
	 * ユーザーテーブル特定IDのデータ取得
	 *
	 * @author UKA.System
	 *
	 * @return table
	 * @throws SQLException
	 */
	public List<UsersBean> findById(String mailaddress,String password) throws SQLException{

		PreparedStatement findById = con.prepareStatement("select * from users where mailaddress = ? and password = ?");

		findById.setString(1, mailaddress);
		findById.setString(2, password);

		ResultSet result = findById.executeQuery();

		ArrayList<UsersBean> table = new ArrayList<UsersBean>();

		while(result.next()){

			UsersBean record = new UsersBean();

			record.setMailAddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getString("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

			table.add(record);
		}

		return table;

	}


	/**
	 * ユーザーテーブル特定IDのデータ取得
	 *
	 * @author UKA.System
	 *
	 * @return table
	 * @throws SQLException
	 */
	public List<UsersBean> insert(String mailaddress,String password,String name,String profileComment,String department_Id,String image,int status) throws SQLException{

		PreparedStatement findById = con.prepareStatement("select * from users where mailaddress = ? and password = ?");

		findById.setString(1, mailaddress);
		findById.setString(2, password);

		ResultSet result = findById.executeQuery();

		ArrayList<UsersBean> table = new ArrayList<UsersBean>();

		while(result.next()){

			UsersBean record = new UsersBean();

			record.setMailAddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getString("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

			table.add(record);
		}

		return table;

	}

}
