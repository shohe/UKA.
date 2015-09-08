package hal.tokyo.controller;

import hal.tokyo.model.EnquiryNullChecker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageTest {
	@RequestMapping("/messagssse")
	public ModelAndView showMessage(
			@RequestParam("user_id") String user_id,
			@RequestParam("enq_id") String enq_id,
			@RequestParam("kenmei") String kenmei,
			@RequestParam("naiyou") String naiyou) {

		EnquiryNullChecker enc = new EnquiryNullChecker();
		//error messages
		String enc_kenmei = "";
		String enc_naiyou = "";
		//test start
		enc_kenmei = enc.TitleNullCheck(kenmei);
		enc_naiyou = enc.TitleNullCheck(naiyou);

		if(!enc_kenmei.equals("") || !enc_naiyou.equals("")){
			ModelAndView mv = new ModelAndView("message");
			mv.addObject("kenmei",kenmei);
			mv.addObject("naiyou",naiyou);
			mv.addObject("err_kenmei",enc_kenmei);
			mv.addObject("err_naiyou",enc_naiyou);

			return mv;
		}else{

			/** 確認画面へ **/
			ModelAndView mv = new ModelAndView("message_confirm");
			mv.addObject("user_id",user_id);
			mv.addObject("enq_id",enq_id);
			mv.addObject("kenmei",kenmei);
			mv.addObject("naiyou",naiyou);
			return mv;


		}

	}

}