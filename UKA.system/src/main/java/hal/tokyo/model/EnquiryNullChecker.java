package hal.tokyo.model;

import hal.tokyo.model.EnquiryChecker;

public class EnquiryNullChecker {
	
	EnquiryChecker ec = new EnquiryChecker();
	String null_checker;
	String blank_checker;
	
	public EnquiryNullChecker(){
		null_checker = "入力値がありません。";
		blank_checker = "空白のみの送信は出来ません。";
	}
	
	public String TitleNullCheck(String kenmei){
		if(!ec.StringNull(kenmei)){
			return null_checker;
		}else if(!ec.StringBlank(kenmei)){
			return blank_checker;
		}else{
			return "";
		}
	}
	
	public String ContentNullCheck(String naiyou){
		if(!ec.StringNull(naiyou)){
			return null_checker;
		}else if(!ec.StringBlank(naiyou)){
			return blank_checker;
		}else{
			return "";
		}
	}
	
}
