package hal.tokyo.controller;

public class MailCheck {
	

	public boolean StringNull(String value){

		if(!(value == null || value.isEmpty())){

			return true;

		}else{

			return false;
		}
	}
	

	public boolean StringBlank(String value){

		if(value.indexOf(" ") == -1 && value.indexOf("　") == -1){

			return true;

		}else{

			return false;

		}

	}





}
