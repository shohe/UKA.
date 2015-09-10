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
	private String mailaddress;
	private int post_id;
	private String date;
	private int possession_vote;
	private int posting_Type_Id;
	private int status;
	private String title;
	private String posting_content;
	private String department_name;
	private String name;
	private int achievement_percentage;
	private int achievement_vote;
	private String image;
	private String profilecomment;
	private int timelimit;
	private int is_permit;
	public int getPosting_Id() {
		return posting_Id;
	}
	public void setPosting_Id(int posting_Id) {
		this.posting_Id = posting_Id;
	}
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getPosting_content() {
		return posting_content;
	}
	public void setPosting_content(String posting_content) {
		this.posting_content = posting_content;
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
	public int getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(int timelimit) {
		this.timelimit = timelimit;
	}

	public int getIs_permit() {
		return is_permit;
	}
	public void setIs_permit(int is_permit) {
		this.is_permit = is_permit;
	}
	public int getPossession_vote() {
		return possession_vote;
	}
	public void setPossession_vote(int possession_vote) {
		this.possession_vote = possession_vote;
	}



}
