package hal.tokyo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hal.tokyo.beans.AdminMailsViewBean;
import hal.tokyo.dao.AdminMailsViewDao;

@Controller
public class MyPageView {
	@RequestMapping(value = "/mypage")
	public ModelAndView OutPutAdminMails(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("MailAddress");
			AdminMailsViewDao adminMailsViewDao;
			ArrayList<AdminMailsViewBean> adminMailsViewData;
			try {
				adminMailsViewDao = new AdminMailsViewDao();
				try {
					adminMailsViewData = adminMailsViewDao.read(user_id);
					ModelAndView modelAndView = new ModelAndView("mypage");
					modelAndView.addObject("adminMailsViewData", adminMailsViewData);
					return modelAndView;
				} catch (SQLException e) {
					adminMailsViewDao.rollback();
					e.printStackTrace();
					System.out.println(e);
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		ModelAndView modelAndView = new ModelAndView("error");
		return modelAndView;
	}
}
