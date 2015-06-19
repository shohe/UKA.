package hal.tokyo.controller;

import hal.tokyo.dao.UsersDao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistModelII {

	HttpServletRequest request;
	HttpServletResponse response;

	UsersDao ud = new UsersDao();

	String mailaddress;
	String password;
	String name;
	String profileComment;
	String department_Id;
	String image;
	int status;

	int result;

	@RequestMapping("/registmodel")
	public ModelAndView showMessage(){

		try{

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

			RegistParamSet();



			ud.close();

		}catch (SQLException e) {

			try {

				ud.rollback();

			} catch (SQLException e1) {


				e1.printStackTrace();

			}
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		ModelAndView mv = new ModelAndView("regist");
		return mv;

	}


	public void RegistParamSet(){

		mailaddress = request.getParameter("mailaddress");
		password = request.getParameter("password");
		name = request.getParameter("name");
		profileComment = request.getParameter("profileComment");
		department_Id = request.getParameter("department_Id");
		image = "ないよ";
		status = 0;

	}


}
