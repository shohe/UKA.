package hal.tokyo.model;

import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

public class MypageUpdateModel {

	UsersDao ud = new UsersDao();

	public boolean MypageUpdate(String mailaddress,String password,String name,String profileComment,int department_Id,String image) throws SQLException{

		try {

			int count = ud.update(mailaddress, password, name, profileComment, department_Id, image);

			if(count > 0){

				ud.commit();
				ud.close();
				ud = null;
				return true;

			}else{

				ud.rollback();
				ud.close();
				ud = null;
				return false;

			}

		} catch (SQLException e) {

			ud.rollback();
			ud.close();
			ud = null;
			e.printStackTrace();
			return false;

		}

	}

}
