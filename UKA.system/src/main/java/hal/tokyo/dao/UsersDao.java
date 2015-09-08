package hal.tokyo.dao;

import hal.tokyo.beans.UsersBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * ユーザー関係Dao
 *
 * @author UKA.system
 *
 */
public class UsersDao {

	/** Connection **/
	private Connection con;

	/**
	 * コンストラクタ
	 */
	public UsersDao(){

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

			record.setMailaddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getInt("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

			table.add(record);
		}

		findAll = null;
		close();
		result.close();

		return table;

	}


	/**
	 * ユーザーテーブル
	 * メールアドレス・パスワードでデータを取得
	 *
	 * @author UKA.System
	 *
	 * @return table
	 * @throws SQLException
	 */
	public UsersBean findById(String mailaddress,String password) throws SQLException{

		PreparedStatement findById = con.prepareStatement("select * from users where mailaddress = ? and password = ?;");
		findById.setString(1, mailaddress);
		findById.setString(2, password);

		ResultSet result = findById.executeQuery();

		UsersBean record = new UsersBean();
		while(result.next()){

			record.setMailaddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getInt("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

		}

		findById = null;

		close();
		result.close();

		return record;

	}

	/**
	 * ユーザーテーブル
	 * メールアドレスでデータ取得
	 *
	 * @param mailaddress
	 * @return
	 * @throws SQLException
	 */
	public UsersBean findByMailaddress(String mailaddress) throws SQLException{

		PreparedStatement findByMailaddress = con.prepareStatement("select * from users where mailaddress = ?;");
		findByMailaddress.setString(1, mailaddress);

		ResultSet result = findByMailaddress.executeQuery();

		UsersBean record = new UsersBean();
		while(result.next()){

			record.setMailaddress(result.getString("mailaddress"));
			record.setPassword(result.getString("password"));
			record.setName(result.getString("name"));
			record.setProfileComment(result.getString("profileComment"));
			record.setDepartment_Id(result.getInt("department_Id"));
			record.setImage(result.getString("image"));
			record.setStatus(result.getInt("status"));

		}

		findByMailaddress = null;

		close();
		result.close();

		return record;

	}

	/**
	 * データの登録
	 *
	 * @author UKA.System
	 *
	 * @param mailaddress
	 * @param password
	 * @param name
	 * @param profileComment
	 * @param department_Id
	 * @param image
	 * @param status
	 * @return result
	 * @throws SQLException
	 */
	public int insert(String mailaddress,String password,String name,int department_Id,String profileComment,String image,int status) throws SQLException{

		PreparedStatement insert =
				con.prepareStatement("insert into users values(?,?,?,?,?,?,?);");

		insert.setString(1, mailaddress);
		insert.setString(2, password);
		insert.setString(3, name);
		insert.setInt(4, department_Id);
		insert.setString(5, profileComment);
		insert.setString(6, image);
		insert.setInt(7, status);

		int result = insert.executeUpdate();

		insert = null;

		return result;

	}


	/**
	 * データの変更
	 *
	 * @param mailaddress
	 * @param password
	 * @param name
	 * @param profileComment
	 * @param department_Id
	 * @param image
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public int update(String mailaddress,String password,String name,String profileComment,int department_Id,String image,String mailaddress_old) throws SQLException{

		PreparedStatement update = con.prepareStatement("update users set mailaddress = ?, password = ?, name = ?, profileComment = ?, department_Id = ?, image = ? where mailaddress = ?");

		update.setString(1, mailaddress);
		update.setString(2, password);
		update.setString(3, name);
		update.setString(4, profileComment);
		update.setInt(5, department_Id);
		update.setString(6, image);
		update.setString(7, mailaddress_old);

		int result = update.executeUpdate();

		update = null;

		return result;

	}

	/**
	 * データの削除
	 *
	 * @author UKA.System
	 *
	 *
	 * @param mailaddress
	 * @return result
	 * @throws SQLException
	 */
	public int delete(String mailaddress) throws SQLException{

		PreparedStatement delete = con.prepareStatement("delete from users where mailaddress = ?");

		delete.setString(1, mailaddress);

		int result = delete.executeUpdate();

		delete = null;

		return result;

	}

	/**
	 *
	 * 特定IDのパスワードを1件取得
	 *
	 * @param mailaddress
	 * @return
	 * @throws SQLException
	 */
	public String findPassword(String mailaddress) throws SQLException{

		String password = "";

		PreparedStatement findPassword = con.prepareStatement("select password from users where mailaddress = ?;");
		findPassword.setString(1, mailaddress);

		ResultSet result = findPassword.executeQuery();

		while(result.next()){

			password = result.getString("password");

		}
		findPassword = null;
		result.close();
		close();

		return password;

	}

	/**
	 * UsersDaoのコミット
	 *
	 * @throws SQLException
	 */
	public void commit() throws SQLException{

		con.commit();

	}

	/**
	 * UsersDaoのクローズ
	 *
	 * @throws SQLException
	 */
	public void close() throws SQLException{

		con.close();

	}

	/**
	 * UsersDaoのロールバック
	 *
	 * @throws SQLException
	 */
	public void rollback() throws SQLException{

		con.rollback();

	}

}
