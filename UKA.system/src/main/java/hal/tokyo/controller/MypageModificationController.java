package hal.tokyo.controller;

import hal.tokyo.model.ImageUpload;
import hal.tokyo.model.MultipleData;
import hal.tokyo.model.MypageCheck;
import hal.tokyo.model.MypageUpdateModel;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登録内容変更
 *
 * @author UKA.system
 *
 */
@Controller
public class MypageModificationController {

	@Autowired
	ServletContext context;

	@RequestMapping("/mypage_mod")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response,
									@RequestParam(value = "department_Id",defaultValue = "0") int department_Id,
									@RequestParam(value = "mailaddress" , required = false) String mailaddress,
									@RequestParam(value = "mailaddress_old") String mailaddress_old,
									@RequestParam(value = "name" , required = false) String name,
									@RequestParam(value = "password" , required = false) String password,
									@RequestParam(value = "password_new" , required = false) String password_new,
									@RequestParam(value = "thumbnail" , required = false) MultipartFile thumbnail,
									@RequestParam(value = "image_old" , required = false) String image,
									@RequestParam(value = "profileComment" , required = false) String profileComment) throws SQLException,Exception{

		/** セッション更新用 **/
		HttpSession session = request.getSession();

		/** 入力内容チェック **/
		MypageCheck mc = new MypageCheck();

		/** 画像ファイル関係 **/
		MultipleData md = new MultipleData();

		/** 画像アップロード用 **/
		ImageUpload iu = new ImageUpload(context);

		/** データアップデート用 **/
		MypageUpdateModel mum = new MypageUpdateModel();

		/** エラーメッセージ用 **/
		String mc_name = "";
		String mc_mailaddress = "";
		String mc_password = "";
		String mc_password_new = "";
		String mc_profileComment = "";
		String mc_image = "";

		/**
		 * 入力値をチェックし、
		 * 判定結果を代入する
		 **/
		mc_name = mc.MypageNameCheck(name);
		mc_mailaddress = mc.MypageMailaddressCheck(mailaddress);
		mc_password = mc.MypageOldPasswordCheck(mailaddress_old, password);
		mc_password_new = mc.MypagePasswordCheck(password_new);
		mc_profileComment = mc.MypageProfileComment(profileComment);
		//mc_image = mc.MypageFileExtensionCheck(thumbnail.getOriginalFilename());

		//画像が選択され送られてきたときのみ
		if(!thumbnail.isEmpty() && thumbnail != null){
			mc_image = mc.MypageFileExtensionCheck(thumbnail.getOriginalFilename());
		}

		/** 入力にエラーがないか？
		 *  エラーがある場合
		 *  **/
		if(!mc_name.equals("") ||
				!mc_mailaddress.equals("") ||
				!mc_password.equals("") ||
				!mc_password_new.equals("") ||
				!mc_profileComment.equals("") ||
				!mc_image.equals("")){

			/** マイページヘ **/
			ModelAndView mv = new ModelAndView("mypage");

			//ub = ud.findByMailaddress(mailaddress_old);

			/** 入力値 **/

			mv.addObject("department_Id", department_Id);
			mv.addObject("mail", mailaddress);
			mv.addObject("user", name);
			mv.addObject("image", image);
			mv.addObject("profile", profileComment);

			/*
			mv.addObject("department_Id", ub.getDepartment_Id());
			mv.addObject("mailaddress", ub.getMailAddress());
			mv.addObject("name", ub.getName());
			mv.addObject("profileComment", ub.getProfileComment());
			mv.addObject("image", ub.getImage());
			*/

			/** エラーメッセージを入れる **/
			mv.addObject("name_msg", mc_name);
			mv.addObject("mailaddress_msg", mc_mailaddress);
			mv.addObject("password_msg", mc_password);
			mv.addObject("password_new_msg", mc_password_new);
			mv.addObject("profileComment_msg", mc_profileComment);
			mv.addObject("image_msg", mc_image);

			mc = null;
			md = null;
			iu = null;
			mum = null;

			return mv;


		}else{/** エラーなし **/

			/** アップデートへ **/
			ModelAndView mv = new ModelAndView("mypage");

			//ファイルクラス
			File file;
			//画像のパスを入れる変数
			String imageUrl;

			//画像ファイルが選択されたとき実行
			if(!thumbnail.isEmpty() && thumbnail != null){

				/** ファイル操作 **/
				file = new File(iu.createUploadPath(),iu.getFileExtention(thumbnail.getOriginalFilename()));

				md.setFile(file);
				md.setMultipartFile(thumbnail);
				md.setUrl("/resources/var/"+iu.getFileExtention(thumbnail.getOriginalFilename()));
				md.upload();
				imageUrl = md.getUrl();

			}else{

				imageUrl = "/resources/var/user-blank.jpg";

			}

			/** アップデートに成功した場合 **/
			if(mum.MypageUpdate(mailaddress, password_new, name, profileComment, department_Id, imageUrl, mailaddress_old)){


				//画像ファイルが選択されたとき実行
				if(!thumbnail.isEmpty() && thumbnail != null){

					mv.addObject("image", md.getUrl());

				}else{

					mv.addObject("image", "/resources/var/user-blank.jpg");

				}
				/** 入力値 **/
				mv.addObject("department_Id", department_Id);
				mv.addObject("mail", mailaddress);
				mv.addObject("user", name);
				mv.addObject("profile", profileComment);

				//	セッションセット
				session.removeAttribute("MailAddress");
				session.setAttribute("MailAddress", mailaddress);


				mc = null;
				md = null;
				iu = null;
				mum = null;
				file = null;

				return mv;

			}else{

				/** 入力値 **/

				mv.addObject("department_Id", department_Id);
				mv.addObject("mail", mailaddress);
				mv.addObject("user", name);
				mv.addObject("image", image);
				mv.addObject("profile", profileComment);

				mc = null;
				md = null;
				iu = null;
				mum = null;
				file = null;

				return mv;
			}

		}
	}

}
