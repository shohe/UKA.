package hal.tokyo.beans;

/**
 *
 * 企画内容閲覧画面で出力するデータを格納しています<br>
 * postings、posting_contents、users、tesmsテーブルを結合しています
 *
 * @author enfumidayo
 *
 */
public class IdeaDetailViewBean {
	private String title;
	private String date;
	private String posting_content;
	private String image;
	private String name;
	private String department_name;
	private String profilecomment;
	private int achievement_percentage;
	private int timelimit;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPosting_content() {
		return posting_content;
	}

	public void setPosting_content(String posting_content) {
		this.posting_content = posting_content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getProfilecomment() {
		return profilecomment;
	}

	public void setProfilecomment(String profilecomment) {
		this.profilecomment = profilecomment;
	}

	public int getAchievement_percentage() {
		return achievement_percentage;
	}

	public void setAchievement_percentage(int achievement_percentage) {
		this.achievement_percentage = achievement_percentage;
	}

	public int getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(int timelimit) {
		this.timelimit = timelimit;
	}

}
