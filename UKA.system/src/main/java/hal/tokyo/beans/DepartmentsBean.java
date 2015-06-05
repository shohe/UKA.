package hal.tokyo.beans;

import java.io.Serializable;

/**
 * 部署テーブル用Bean
 * 
 * @author Uka system
 *
 */
public class DepartmentsBean implements Serializable{
	private String department_Id;
	private String department_Name;
	public String getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(String department_Id) {
		this.department_Id = department_Id;
	}
	public String getDepartment_Name() {
		return department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}
	
}
