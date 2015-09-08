package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RegularlyUpdateDao {

	/** Connection **/
	private Connection con;
	/**
	 * コンストラクタ
	 * @param con
	 */

	public RegularlyUpdateDao(){

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

	public RegularlyUpdateDao(Connection con){
		this.con = con;
	}

	/** ------------------------- 期限の全件取得  ---------------------------------
	 * @return **/

	public void RegularlyUpdate() throws SQLException{
		PreparedStatement pstm = con.prepareStatement(
		"SELECT postings.posting_id , "
		+ "DATEDIFF( DATE_ADD( ( postings.date ), "
		+ "INTERVAL( SELECT terms.terms_period FROM terms "
		+ "WHERE terms.terms_id = postings.terms_id ) DAY ) ,"
		+ "CURRENT_DATE() ) AS timelimit FROM postings  "
		+ "JOIN terms ON terms.terms_id = postings.terms_id"
		);

		ResultSet rs = pstm.executeQuery();

		rs.beforeFirst();



		while(rs.next()){
			System.out.println(rs.getInt("posting_id"));
			if(rs.getInt("timelimit") < 0){
				PreparedStatement updatepstm = con.prepareStatement("UPDATE postings SET status = 0 WHERE posting_id = "+ rs.getInt("posting_id") +";");
				updatepstm.executeUpdate();
				updatepstm.close();
				con.commit();
			}
		}

		pstm.close();
		rs.close();
		con.close();
	}
}
