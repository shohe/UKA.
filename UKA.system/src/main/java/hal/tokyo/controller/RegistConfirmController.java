package hal.tokyo.controller;

import hal.tokyo.model.MultipleData;
import hal.tokyo.model.RegistCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView showMessage(@RequestParam("department_Id") int department_Id,
									@RequestParam("mailaddress") String mailaddress,
									@RequestParam("name") String name,
									@RequestParam("password") String password,
									@RequestParam("password_c") String password_c,
									@RequestParam("thumbnail") MultipartFile thumbnail,
									@RequestParam("profileComment") String profileComment) {

		/** 今は使わない **/
		//RegistValueCheck rvc = new RegistValueCheck();

		/** 入力内容チェック **/
		RegistCheck rc = new RegistCheck();

		/** 画像ファイル関係 **/
		MultipleData md = new MultipleData();

		PostController pc = new PostController();

		/*
		File file = new File(pc.createUploadPath(),pc.getFileExtention(thumbnail.getOriginalFilename()));

		md.setFile(file);
		md.setMultipartFile(thumbnail);
		md.setUrl("<c:url value='/resources/var/"+pc.getFileExtention(thumbnail.getOriginalFilename())+"' />");
		md.upload();
		

		*/

		/** エラーメッセージ用 **/
		String rc_name = "";
		String rc_mailaddress = "";
		String rc_password;
		String rc_password_c;
		String rc_profileComment;

		/** テスト用出力 **/
		/*
		System.out.println("文字列判定");
		System.out.println(name);
		System.out.println(rc.StringMatchNumber(name));
		System.out.println(rc.StringMatchSymbol(name));
		System.out.println(rc.StringBlank(name));
		System.out.println(rc.StringNull(name));
		*/

		/** 判定結果を代入する **/
		rc_name = rc.RegistNameCheck(name);
		rc_mailaddress = rc.RegistMailaddressCheck(mailaddress);
		rc_password = rc.RegistPasswordCheck(password);
		rc_password_c = rc.RegistPasswordConCheck(password,password_c);
		rc_profileComment = rc.RegistProfileComment(profileComment);

		if(!rc_name.equals("") ||
				!rc_mailaddress.equals("") ||
				!rc_password.equals("") ||
				!rc_password_c.equals("") ||
				!rc_profileComment.equals("")){

			/** 入力画面へ **/
			ModelAndView mv = new ModelAndView("regist");

			/** 入力値 **/
			mv.addObject("department_Id", department_Id);
			mv.addObject("mailaddress", mailaddress);
			mv.addObject("name", name);
			mv.addObject("password", password);
			mv.addObject("passwor_c", password_c);
			mv.addObject("profileComment", profileComment);

			/** エラーメッセージを入れる **/
			mv.addObject("name_msg", rc_name);
			mv.addObject("mailaddress_msg", rc_mailaddress);
			mv.addObject("password_msg", rc_password);
			mv.addObject("password_c_msg", rc_password_c);
			mv.addObject("profileComment_msg", rc_profileComment);

			return mv;


		}else{

			/** 確認画面へ **/
			ModelAndView mv = new ModelAndView("regist_confirm");

			/** 入力値 **/
			mv.addObject("department_Id", department_Id);
			mv.addObject("mailaddress", mailaddress);
			mv.addObject("name", name);
			mv.addObject("password", password);
			mv.addObject("password_a", rc.HidePassword(password));
			mv.addObject("profileComment", profileComment);
			return mv;

		}

	}

}
