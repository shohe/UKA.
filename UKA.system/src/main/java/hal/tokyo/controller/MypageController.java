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

@Controller
public class MypageController {

	@RequestMapping("/mypage")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response) throws SQLException, UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("mypage");

		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		UsersDao ud = new UsersDao();

		UsersBean ub = new UsersBean();

		String mail = (String)session.getAttribute("MailAddress");

		System.out.println(mail);

		ub = ud.findByMailaddress(mail);

		mv.addObject("user", ub.getName());
		mv.addObject("image", ub.getImage());
		mv.addObject("mail", ub.getMailAddress());
		mv.addObject("profile", ub.getProfileComment());

		ud.close();
		ud = null;
		ub = null;

		return mv;
	}
}
