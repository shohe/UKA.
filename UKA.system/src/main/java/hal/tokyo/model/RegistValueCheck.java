package hal.tokyo.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * パラメータ内容をチェックするクラス
 *
 * @author UKA.System
 *
 */
public class RegistValueCheck {

	/**
	 *数字チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean StringMatchNumber (String value){

        Pattern p = Pattern.compile("^[^0-9０-９]+$");
        Matcher m = p.matcher(value);

        if(m.find()){

        	return true;

        }else{

        	return false;

        }

	}

	/**
	 *記号チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean StringMatchSymbol (String value){

		String han = "\\p{Punct}";
		String zen = "！”＃＄％＆’（）＝～｜‘｛＋＊｝＜＞？＿－＾￥＠「；：」、。・";

        Pattern p = Pattern.compile("^[^"+han+zen+"]+$");
        Matcher m = p.matcher(value);

        if(m.find()){

        	return true;

        }else{

        	return false;

        }

	}

	/**
	 * 空白チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean StringBlank(String value){

		if(value.indexOf(" ") == -1 && value.indexOf("　") == -1){

			return true;

		}else{

			return false;

		}

	}

	/**
	 * NULL・空チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean StringNull(String value){

		if(!(value == null || value.isEmpty())){

			return true;

		}else{

			return false;
		}
	}

	/**
	 * 文字数チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean StringCount(String value,int count){

		if(value.length() < count){

			return false;

		}else{

			return true;

		}

	}


	/**
	 * メールアドレス形式チェック
	 *
	 * @param value
	 * @return
	 */
	public boolean MailaddressFormCheck(String value){

        Pattern p = Pattern.compile("[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+");
        Matcher m = p.matcher(value);

        if(m.matches()){

        	return true;

        }else{

        	return false;

        }

	}

	/**
	 * パスワードと確認用が同じかのチェック
	 *
	 * @param password
	 * @param password_c
	 * @return
	 */
	public boolean PasswordSameCheck(String password,String password_c){

		if(password.equals(password_c)){

			return true;

		}else{

			return false;

		}

	}


	public boolean FileExtensionCheck(String filename){

		int index = filename.indexOf(".");

		String extension = filename.substring(index+1);

		if(extension.equals("jpg") || extension.equals("png")){

			return true;

		}else{

			return false;

		}

	}

}
