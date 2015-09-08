package hal.tokyo.model;


/**
 *登録画面の入力内容をチェックするクラス
 *
 * @author UKA.System
 *
 */
public class RegistCheck {

	RegistValueCheck rvc = new RegistValueCheck();

	String cannot_number;
	String cannot_symbol;
	String cannot_blank;
	String cannot_null;
	String not_mailaddress_form;
	int password_count;
	String input_pass;

	/**
	 * エラーメッセージ設定
	 *
	 *
	 */
	public RegistCheck() {
		cannot_number = "数字は入力できません";
		cannot_symbol = "記号は入力できません";
		cannot_blank = "空白は入力できません";
		cannot_null = "を入力して下さい";
		not_mailaddress_form = "メールアドレスの形式が正しくありません";
		password_count = 8;
		input_pass = "文字以上のパスワードを入力して下さい";
	}

	/**
	 * 名前をチェック
	 *
	 * @param name
	 * @return
	 */
	public String RegistNameCheck(String name){

		if(!rvc.StringNull(name)){

			return "名前" + cannot_null;

		}else if(!rvc.StringBlank(name)){

			return cannot_blank;

		}else if(!rvc.StringMatchSymbol(name)){

			return cannot_symbol;

		}else if(!rvc.StringMatchNumber(name)){

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
	public String RegistMailaddressCheck(String mailaddress){

		if(!rvc.StringNull(mailaddress)){

			return "メールアドレス" + cannot_null;

		}else if(!rvc.StringBlank(mailaddress)){

			return cannot_blank;

		}else if(!rvc.MailaddressFormCheck(mailaddress)){

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
	public String RegistPasswordCheck(String password){

		if(!rvc.StringNull(password)){

			return "パスワード" + cannot_null;

		}else if(!rvc.StringBlank(password)){

			return cannot_blank;

		}else if(!rvc.StringMatchSymbol(password)){

			return cannot_symbol;

		}else if(!rvc.StringCount(password,password_count)){

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
	public String RegistPasswordConCheck(String password,String password_c){

		if(!rvc.StringNull(password_c)){

			return "パスワード" + cannot_null;

		}else if(!rvc.StringBlank(password_c)){

			return cannot_blank;

		}else if(!rvc.StringMatchSymbol(password_c)){

			return cannot_symbol;

		}else if(!rvc.StringCount(password_c,password_count)){

			return password_count + input_pass;

		}else if(!rvc.PasswordSameCheck(password, password_c)){

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
	public String RegistProfileComment(String profileComment){

		if(!rvc.StringBlank(profileComment)){

			return cannot_blank;

		}else{

			return "";

		}

	}

	/**
	 * パスワードをアスタリスクにする
	 * 完全におまけ
	 *
	 * @param password
	 * @return
	 */
	public String HidePassword(String password){

		String return_password = "";

		for(int i = 0;i < password.length();i++){

			return_password = return_password + "*";

		}

		return return_password;

	}


	/**
	 * ファイル拡張子のチェック
	 *
	 * @param filename
	 * @return
	 */
	public String RegistFileExtensionCheck(String filename){

		if(!rvc.FileExtensionCheck(filename)){

			return "有効なファイル形式は.jpg.pngです";

		}else{

			return  "";

		}

	}

}
