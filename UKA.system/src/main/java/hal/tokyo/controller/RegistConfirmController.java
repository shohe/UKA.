package hal.tokyo.controller;

import hal.tokyo.model.RegistCheck;
import hal.tokyo.model.RegistValueCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * 登録確認画面行き
 *
 * @author UKA.system
 *
 */
@Controller
public class RegistConfirmController {

	@RequestMapping("/regist_confirm_con")
	public ModelAndView showMessage(@RequestParam("department_Id") String department_Id,
									@RequestParam("mailaddress") String mailaddress,
									@RequestParam("name") String name,
									@RequestParam("password") String password,
									@RequestParam("password_c") String password_c,
									@RequestParam("profileComment") String profileComment) {

		/** チェック用 **/
		RegistValueCheck rvc = new RegistValueCheck();
		RegistCheck rc = new RegistCheck();

		String rc_name = "";

		/** 出力 **/
		/*
		System.out.println("文字列判定");
		System.out.println(name);
		System.out.println(rc.StringMatchNumber(name));
		System.out.println(rc.StringMatchSymbol(name));
		System.out.println(rc.StringBlank(name));
		System.out.println(rc.StringNull(name));
		*/

		rc_name = rc.RegistNameCheck(name);

		if(rc_name.equals("")){

			/** 確認画面へ **/
			ModelAndView mv = new ModelAndView("regist_confirm");

			/** 入力値 **/
			mv.addObject("department_Id", department_Id);
			mv.addObject("mailaddress", mailaddress);
			mv.addObject("name", name);
			mv.addObject("password", password);
			mv.addObject("passwor_c", password_c);
			mv.addObject("profileComment", profileComment);
			return mv;

		}else{

			/** 入力画面へ **/
			ModelAndView mv = new ModelAndView("regist");

			/** 入力値 **/
			mv.addObject("department_Id", department_Id);
			mv.addObject("mailaddress", mailaddress);
			mv.addObject("name", name);
			mv.addObject("password", password);
			mv.addObject("passwor_c", password_c);
			mv.addObject("profileComment", profileComment);

			mv.addObject("name_msg", rc_name);

			return mv;

		}

	}

}
