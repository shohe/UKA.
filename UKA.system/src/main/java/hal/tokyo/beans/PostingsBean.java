package hal.tokyo.beans;

/**
*
* 投稿テーブルBean
*
* @author UKA.System
*
*/
public class PostingsBean {
	private int posting_Id;
	private String user_Id;
	private String data;
	private int possesion_Vote;
	private int posting_Type_Id;
	private int status;
	private String title;
	private int posting_Content_Id;
	
	public int getPosting_Id() {
		return posting_Id;
	}
	public void setPosting_Id(int posting_Id) {
		this.posting_Id = posting_Id;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getPossesion_Vote() {
		return possesion_Vote;
	}
	public void setPossesion_Vote(int possesion_Vote) {
		this.possesion_Vote = possesion_Vote;
	}
	public int getPosting_Type_Id() {
		return posting_Type_Id;
	}
	public void setPosting_Type_Id(int posting_Type_Id) {
		this.posting_Type_Id = posting_Type_Id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPosting_Content_Id() {
		return posting_Content_Id;
	}
	public void setPosting_Content_Id(int posting_Content_Id) {
		this.posting_Content_Id = posting_Content_Id;
	}
	

}
