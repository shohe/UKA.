package hal.tokyo.beans;

public class View {
	private int view_Id;
	private String user_Id;
	private int posting_Id;
	private String date;
	private String comment_Content;
	public int getView_Id() {
		return view_Id;
	}
	public void setView_Id(int view_Id) {
		this.view_Id = view_Id;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public int getPosting_Id() {
		return posting_Id;
	}
	public void setPosting_Id(int posting_Id) {
		this.posting_Id = posting_Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment_Content() {
		return comment_Content;
	}
	public void setComment_Content(String comment_Content) {
		this.comment_Content = comment_Content;
	}
}
