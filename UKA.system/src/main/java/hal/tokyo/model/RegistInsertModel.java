package hal.tokyo.model;

import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

public class RegistInsertModel {

	UsersDao ud;

	public RegistInsertModel() {

		ud = new UsersDao();

	}

	public boolean RegistInsert(String mailaddress,String password,String name,String profileComment,int department_Id){

		try {

			int count = ud.insert(mailaddress, password, name, profileComment, department_Id, "", 0);

			if(count > 0){

				ud.commit();
				ud.close();

				return true;

			}else{

				ud.rollback();
				ud.close();
				return false;

			}

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}


}
