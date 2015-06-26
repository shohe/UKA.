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
	private String posting_Content;
	private String department_name;
	private String name;
	private int achievement_percentage;
	private int achievement_vote;
	private String image;
	private String profilecomment;
	
	
	
	public int getAchievement_vote() {
		return achievement_vote;
	}
	public void setAchievement_vote(int achievement_vote) {
		this.achievement_vote = achievement_vote;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProfilecomment() {
		return profilecomment;
	}
	public void setProfilecomment(String profilecomment) {
		this.profilecomment = profilecomment;
	}
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
	public String getPosting_Content() {
		return posting_Content;
	}
	public void setPosting_Content(String posting_Content) {
		this.posting_Content = posting_Content;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAchievement_percentage() {
		return achievement_percentage;
	}
	public void setAchievement_percentage(int achievement_percentage) {
		this.achievement_percentage = achievement_percentage;
	}
	
	

}
