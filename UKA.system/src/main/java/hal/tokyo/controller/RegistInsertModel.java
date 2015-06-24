package hal.tokyo.controller;

import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * データ登録
 *
 * @author UKA.System
 *
 */
@Controller
public class RegistInsertModel {

	@RequestMapping("/regist_insert")
	public ModelAndView showMessage(@RequestParam("department_Id") int department_Id,
									@RequestParam("mailaddress") String mailaddress,
									@RequestParam("name") String name,
									@RequestParam("password") String password,
									@RequestParam("profileComment") String profileComment) {

		UsersDao ud = new UsersDao();

		try {

			int count = ud.insert(mailaddress, password, name, profileComment, department_Id, "", 0);

			ud.commit();
			ud.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		/** 入力画面へ **/
		ModelAndView mv = new ModelAndView("regist");

		/** 入力値 **/
		mv.addObject("department_Id", department_Id);
		mv.addObject("mailaddress", mailaddress);
		mv.addObject("name", name);
		mv.addObject("password", password);
		mv.addObject("profileComment", profileComment);


		return mv;

	}

}
