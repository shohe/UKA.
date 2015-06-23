package hal.tokyo.model;

public class RegistCheck {

	RegistValueCheck rvc = new RegistValueCheck();

	public String RegistNameCheck(String name){

		if(!rvc.StringNull(name)){

			return "名前を入力して下さい";

		}else if(!rvc.StringBlank(name)){

			return "空白は入力できません";

		}else if(!rvc.StringMatchSymbol(name)){

			return "記号は入力できません";

		}else if(!rvc.StringMatchNumber(name)){

			return "数字は入力できません";

		}else{

			return "";
		}
	}

}
