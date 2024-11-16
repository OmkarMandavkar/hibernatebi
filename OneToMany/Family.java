package OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {

	@Id
	private int fid;
	private String fname;
	private int countmember;
	
	@OneToMany(mappedBy = "family")
	private List<Car> car;

	@Override
	public String toString() {
		return "Family [fid=" + fid + ", fname=" + fname + ", countmember=" + countmember + "]";
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getCountmember() {
		return countmember;
	}

	public void setCountmember(int countmember) {
		this.countmember = countmember;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	
}
