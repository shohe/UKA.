package hal.tokyo.model;

import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

public class MypageCheck {

	MypageValueCheck mvc = new MypageValueCheck();

	String cannot_number;
	String cannot_symbol;
	String cannot_blank;
	String cannot_null;
	String not_mailaddress_form;
	int password_count;
	String input_pass;
	String wrong_pass;

	/**
	 * エラーメッセージ設定
	 *
	 *
	 */
	public MypageCheck() {
		cannot_number = "数字は入力できません";
		cannot_symbol = "記号は入力できません";
		cannot_blank = "空白は入力できません";
		cannot_null = "を入力して下さい";
		not_mailaddress_form = "メールアドレスの形式が正しくありません";
		password_count = 8;
		input_pass = "文字以上のパスワードを入力して下さい";
		wrong_pass = "現在のパスワードと一致しません";
	}
	/**
	 * 名前をチェック
	 *
	 * @param name
	 * @return
	 */
	public String MypageNameCheck(String name){

		if(!mvc.StringNull(name)){

			return "名前" + cannot_null;

		}else if(!mvc.StringBlank(name)){

			return cannot_blank;

		}else if(!mvc.StringMatchSymbol(name)){

			return cannot_symbol;

		}else if(!mvc.StringMatchNumber(name)){

			return cannot_number;

		}else{

			return "";
		}
	}

	/**
	 *
	 * メールアドレスのチェック
	 *
	 * @param mailaddress
	 * @return
	 */
	public String MypageMailaddressCheck(String mailaddress){

		if(!mvc.StringNull(mailaddress)){

			return "メールアドレス" + cannot_null;

		}else if(!mvc.StringBlank(mailaddress)){

			return cannot_blank;

		}else if(!mvc.MailaddressFormCheck(mailaddress)){

			return not_mailaddress_form;

		}else{

			return "";
		}

	}

	/**
	 * パスワードのチェック
	 *
	 * @param password
	 * @return
	 */
	public String MypagePasswordCheck(String password){

		if(!mvc.StringNull(password)){

			return "パスワード" + cannot_null;

		}else if(!mvc.StringBlank(password)){

			return cannot_blank;

		}else if(!mvc.StringMatchSymbol(password)){

			return cannot_symbol;

		}else if(!mvc.StringCount(password,password_count)){

			return password_count + input_pass;

		}else{

			return "";
		}

	}

	/**
	 * 確認用パスワードのチェック
	 *
	 * @param password
	 * @param password_c
	 * @return
	 */
	public String MypagePasswordConCheck(String password,String password_c){

		if(!mvc.StringNull(password_c)){

			return "パスワード" + cannot_null;

		}else if(!mvc.StringBlank(password_c)){

			return cannot_blank;

		}else if(!mvc.StringMatchSymbol(password_c)){

			return cannot_symbol;

		}else if(!mvc.StringCount(password_c,password_count)){

			return password_count + input_pass;

		}else if(!mvc.PasswordSameCheck(password, password_c)){

			return "パスがまちがってるよ";

		}else{

			return "";
		}

	}


	/**
	 * プロフィールコメントのチェック
	 *
	 * @param profileComment
	 * @return
	 */
	public String MypageProfileComment(String profileComment){

		if(!mvc.StringBlank(profileComment)){

			return cannot_blank;

		}else{

			return "";

		}

	}

	/**
	 * 以前のパスワードと一致しているかチェック
	 *
	 *
	 * @param mailaddress_old
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public String MypageOldPasswordCheck(String mailaddress_old,String password) throws SQLException{

		UsersDao ud = new UsersDao();

		if(!password.equals(ud.findPassword(mailaddress_old))){

			ud.close();
			return wrong_pass;

		}else{
			ud.close();
			return "";

		}

	}


	/**
	 * ファイル拡張子のチェック
	 *
	 * @param filename
	 * @return
	 */
	public String MypageFileExtensionCheck(String filename){

		if(!mvc.FileExtensionCheck(filename)){

			return "有効なファイル形式は.jpg.pngです";

		}else{

			return  "";

		}

	}
}
