package hal.tokyo.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 登録内容チェック
 *
 * @author UKA.System
 *
 */
public class RegistValueCheck {

	/*
	private String mailAddress;
	private String password;
	private String name;
	private String profileComment;
	private int department_Id;
	private String image;
	private int status;
	*/

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
	 * NULLチェック
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

		if(value.length() <= count){

			return true;

		}else{

			return false;

		}

	}

}
