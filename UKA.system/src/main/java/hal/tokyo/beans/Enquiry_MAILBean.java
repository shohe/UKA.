package hal.tokyo.beans;

/**
 *
 * お問い合わせメールテーブル
 *
 * @author UKA.System
 *
 */
public class Enquiry_MAILBean {

	private int enquiry_id;
	private String date;
	private String user_id;
	private int enquiry_type_id;
	private String enquiry_content;
	public int getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getEnquiry_type_id() {
		return enquiry_type_id;
	}
	public void setEnquiry_type_id(int enquiry_type_id) {
		this.enquiry_type_id = enquiry_type_id;
	}
	public String getEnquiry_content() {
		return enquiry_content;
	}
	public void setEnquiry_content(String enquiry_content) {
		this.enquiry_content = enquiry_content;
	}




}
