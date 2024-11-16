package ManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Employee {

	@Id
	private int eid;
	private String name;
	private int YOJ;

	@ManyToOne
	@JoinColumn(name = "id")
	private Department department;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", YOJ=" + YOJ + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYOJ() {
		return YOJ;
	}

	public void setYOJ(int yOJ) {
		YOJ = yOJ;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	
}