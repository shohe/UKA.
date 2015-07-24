package hal.tokyo.beans;

/**
 * ユーザ情報テーブルBean
 *
 * @author Uka system
 */
public class UsersBean {

	private String mailAddress;
	private String password;
	private String name;
	private String profileComment;
	private int department_Id;
	private String image;
	private int status;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileComment() {
		return profileComment;
	}

	public void setProfileComment(String profileComment) {
		this.profileComment = profileComment;
	}

	public int getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}