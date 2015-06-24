package hal.tokyo.controller;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;
import java.util.List;
/*
 *
 *
 *
 * @author 小坂
 */

public class LoginModule {


	private List<UsersBean> table;

	private String ErrorMessage = "メールアドレス又はパスワードが違います。";



	public String Login(String MailAddress , String Password){
		UsersDao usersdao = new UsersDao();
		try {
			UsersBean record = new UsersBean();
			usersdao.findById(MailAddress, Password);
			/*ログイン判定*/
			if(record.getMailAddress() == MailAddress && record.getPassword() == Password){
				return record.getMailAddress();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ErrorMessage;
		}
		return ErrorMessage;

	}





}
