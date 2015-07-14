package hal.tokyo.controller;

import hal.tokyo.dao.AlertDao;
import hal.tokyo.dao.MailDao;

import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * +---------------------------------------+ !このコントローラーはテスト用に作ったモノです!
 * +---------------------------------------+
 * 
 * @author shohe
 *
 */
@Controller
public class AdminTransition {

	String message = "Welcome to Spring MVC!";

	@RequestMapping("/adminTransition")
	public ModelAndView showMessage(
			@RequestParam("adtransubmit") String adtransubmit) throws NamingException, SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("管理者用トップページ", "admin_top");
		map.put("トップへ戻る", "admin_top");
		map.put("プロジェクト一覧", "admin_projectinspection");
		map.put("メール一覧", "admin_mailbox");
		map.put("詳細表示・メール作成", "admin_mailreply");
		map.put("権限管理", "admin_authorization");
		map.put("メール送信", "admin_mailsuctrans");
		//System.out.println(map.get(adtransubmit));
		ModelAndView mv = new ModelAndView(map.get(adtransubmit));
		// mv.addObject("test", test);
		MailDao ad = new MailDao();
		mv.addObject("mailbox", ad.AllAdminMailselect());


		return mv;
	}
}
