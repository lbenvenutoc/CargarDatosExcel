package pe.com.tss.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "STATE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "State.existState", query = "SELECT COUNT(s.name) FROM State s WHERE s.abbreviation=:abbreviation"),
		@NamedQuery(name = "State.getState", query = "SELECT s FROM State s WHERE s.abbreviation=:abbreviation")})
public class State implements Serializable {

	
	private static final long serialVersionUID = -2809815705102074186L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID")
	private long stateId;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "ABB_REVIATION")
	private String abbreviation;

	@Column(name = "COUNTRY_ID", nullable = false)
	private long countryId;

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", abbreviation=" + abbreviation + ", countryId="
				+ countryId + "]";
	}
	
	

}
