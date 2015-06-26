package hal.tokyo.login;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 *
 *
 *
 * @author 小坂
 */

@Controller
@RequestMapping("/login")


public class LoginModule extends HttpServlet{

	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;

	private String ErrorMessage = "メールアドレス又はパスワードが違います。";


	public String Login(String MailAddress , String Password){
		UsersDao usersdao = new UsersDao();
		try {
			UsersBean record = new UsersBean();
			record = usersdao.findById(MailAddress, Password);
			if(record != null){
				if(record.getPassword().equals(Password)){
					return record.getMailAddress();
				}else{
					return ErrorMessage;
				}
			}else{
				return ErrorMessage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ErrorMessage;
		}

	}






}
