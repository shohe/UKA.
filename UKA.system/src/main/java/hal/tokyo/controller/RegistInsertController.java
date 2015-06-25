package hal.tokyo.controller;

import hal.tokyo.model.RegistInsertModel;

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
public class RegistInsertController {

	@RequestMapping("/regist_insert_con")
	public ModelAndView showMessage(@RequestParam("department_Id") int department_Id,
									@RequestParam("mailaddress") String mailaddress,
									@RequestParam("name") String name,
									@RequestParam("password") String password,
									@RequestParam("profileComment") String profileComment) {

		RegistInsertModel rim = new RegistInsertModel();

		boolean insert_check = false;

		insert_check = rim.RegistInsert(mailaddress, password, name, profileComment, department_Id);

		if(insert_check){

			/** トップ **/
			ModelAndView mv = new ModelAndView("./index");

			return mv;

		}else{

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

}
