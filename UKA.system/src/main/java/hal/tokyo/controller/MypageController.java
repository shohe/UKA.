package hal.tokyo.controller;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * マイページに遷移する
 *
 * @author UKA.system
 *
 */
@Controller
public class MypageController {

	@RequestMapping("/mypage")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response) throws SQLException, UnsupportedEncodingException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		//セッション取得
		//String mail = (String)session.getAttribute("MailAddress");

		ModelAndView mv;

		if(session.getAttribute("MailAddress") != null){

			mv = new ModelAndView("mypage");

			String mail = (String)session.getAttribute("MailAddress");

			UsersDao ud = new UsersDao();

			UsersBean ub = new UsersBean();

			System.out.println(mail);

			ub = ud.findByMailaddress(mail);

			mv.addObject("user", ub.getName());
			mv.addObject("image", ub.getImage());
			mv.addObject("mail", ub.getMailaddress());
			mv.addObject("profile", ub.getProfileComment());

			ud.close();
			ud = null;
			ub = null;

		}else{

			mv = new ModelAndView("index");

		}

		return mv;
	}
}
