package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageConfirmController {
	/**
	 * Message Confirm  JSP
	 * 確認画面
	 * @return
	 */
	@RequestMapping("/messageConfirm")
	public ModelAndView gotoConfirm(/*TODO: パラメータ受け取り*/) {
		ModelAndView mv = new ModelAndView("message_confirm");
		/**
		 * TODO: パラメータ付与処理など
		 */
		return mv;
	}
	
	/**
	 * Message Complete  JSP
	 * 完了画面
	 * @return
	 */
	@RequestMapping("/messageComplete")
	public ModelAndView gotoComplete(/*TODO: パラメータ受け取り*/) {
		ModelAndView mv = new ModelAndView("index");
		/**
		 * TODO: パラメータ付与処理など
		 */
		return mv;
	}
}
