package hal.tokyo.model;

import hal.tokyo.model.EnquiryChecker;

public class EnquiryNullChecker {
	
	EnquiryChecker ec = new EnquiryChecker();
	String null_checker;
	String blank_checker;
	
	public EnquiryNullChecker(){
		null_checker = "入力されてないからムリ";
		blank_checker = "空白しかないからムリ";
	}
	
	public String TitleNullCheck(String kenmei){
		if(!ec.StringNull(kenmei)){
			return "タイトル" + null_checker;
		}else if(!ec.StringBlank(kenmei)){
			return "タイトル" + blank_checker;
		}else{
			return "";
		}
	}
	
	public String ContentNullCheck(String naiyou){
		if(!ec.StringNull(naiyou)){
			return "タイトル" + null_checker;
		}else if(!ec.StringBlank(naiyou)){
			return "タイトル" + blank_checker;
		}else{
			return "";
		}
	}
	
}
