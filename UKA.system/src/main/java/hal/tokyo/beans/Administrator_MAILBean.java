package hal.tokyo.beans;

/**
 *
 * 管理者メールテーブル
 *
 * @author UKA.System
 *
 */
public class Administrator_MAILBean {

	private int administrator_mail_id;
	private String date;
	private String title;
	private String content;
	private int posting_id;

	public int getAdministrator_mail_id() {
		return administrator_mail_id;
	}
	public void setAdministrator_mail_id(int administrator_mail_id) {
		this.administrator_mail_id = administrator_mail_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(int posting_id) {
		this.posting_id = posting_id;
	}



}