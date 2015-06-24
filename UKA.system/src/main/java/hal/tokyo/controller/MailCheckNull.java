package hal.tokyo.controller;

public class MailCheckNull {
	
	MailCheck mc = new MailCheck();
	String null_checker;
	String blank_checker;
	
	public MailCheckNull(){
		null_checker = "入力されてないからムリ";
		blank_checker = "空白しかないからムリ";
	}
	
	public String TitleNullCheck(String title){
		if(!mc.StringNull(title)){
			return "タイトル" + null_checker;
		}else if(!mc.StringBlank(title)){
			return "タイトル" + blank_checker;
		}else{
			return "";
		}
	}
	
	public String ContentNullCheck(String content){
		if(!mc.StringNull(content)){
			return "タイトル" + null_checker;
		}else if(!mc.StringBlank(content)){
			return "タイトル" + blank_checker;
		}else{
			return "";
		}
	}
	
}
