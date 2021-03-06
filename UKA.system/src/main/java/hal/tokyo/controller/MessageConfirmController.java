package hal.tokyo.controller;

import hal.tokyo.model.EnquiryNullChecker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageConfirmController {
	/**
	 * Message Confirm  JSP
	 * 確認画面だす
	 * @return
	 */
	@RequestMapping("/messageConfirm")
	public ModelAndView gotoConfirm(
			@RequestParam("enq_id") int enq_id,
			@RequestParam("kenmei") String kenmei,
			@RequestParam("naiyou") String naiyou) {
		//ModelAndView mv = new ModelAndView("message_confirm");
		EnquiryNullChecker enc = new EnquiryNullChecker();
		//error messages
		String enc_kenmei = "";
		String enc_naiyou = "";
		//test start
		enc_kenmei = enc.TitleNullCheck(kenmei);
		enc_naiyou = enc.TitleNullCheck(naiyou);
		System.out.println(enq_id);
		
		String enq_name = "";
		
		if(enq_id == 1){
			enq_name = "クレーム";
		}
		else if(enq_id == 2){
			enq_name = "問題報告";
		}
		else if(enq_id == 3){
			enq_name = "お問い合わせ";
		}
		else if(enq_id == 4){
			enq_name = "ユーザー報告";
		}
		else if(enq_id == 5){
			enq_name = "その他";
		}
		
		
		
		System.out.println(enq_name);
			
		if(!enc_kenmei.equals("") || !enc_naiyou.equals("")){
			ModelAndView mv = new ModelAndView("message");
			mv.addObject("kenmei",kenmei);
			mv.addObject("naiyou",naiyou);
			mv.addObject("enq_name",enq_name);
			mv.addObject("err_kenmei",enc_kenmei);
			mv.addObject("err_naiyou",enc_naiyou);

			return mv;
		}else{

			/** 確認画面へ **/
			ModelAndView mv = new ModelAndView("message_confirm");
			mv.addObject("enq_id",enq_id);
			mv.addObject("kenmei",kenmei);
			mv.addObject("naiyou",naiyou);
			mv.addObject("enq_name",enq_name);
			return mv;


		}

	
	}
	
	/**
	 * Message Complete  JSP
	 * 完了画面だす
	 * @return
	 */
	@RequestMapping("/messageComplete")
	public ModelAndView gotoComplete(/*TODO: パラメータ受け取り*/) {
		ModelAndView mv = new ModelAndView("message_complete");
		/**
		 * TODO: パラメータ付与処理など
		 */
		return mv;
	}
	
	/**
	 * Message Complete  JSP
	 * 完了画面だす
	 * @return
	 */
	@RequestMapping("/messageDone")
	public ModelAndView gotoCompleteIndex(/*TODO: パラメータ受け取り*/) {
		ModelAndView mv = new ModelAndView("index");
		/**
		 * TODO: パラメータ付与処理など
		 */
		return mv;
	}
}
