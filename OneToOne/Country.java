package OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Country {

	@Id
	private int cid;
	private String name;
	private String continent;

	@OneToOne
	@JoinColumn(name = "sid")
	private State state;

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", name=" + name + ", continent=" + continent + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}