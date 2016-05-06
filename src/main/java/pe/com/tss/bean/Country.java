package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the COUNTRY database table.
 * 
 */
@Entity
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Country.exitsCountry", query = "SELECT COUNT(c.countryid) FROM Country c WHERE c.abbreviation=:abbreviation"),
		@NamedQuery(name = "Country.getCountry", query = "SELECT c FROM Country c WHERE c.abbreviation=:abbreviation")})
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "COUNTRY_ID")
	private long countryid;

	@Column(name = "ABB_REVIATION")
	private String abbreviation;

	@Column(name = "NAME")
	private String name;

	public Country() {
	}

	public long getCountryid() {
		return this.countryid;
	}

	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", abbreviation=" + abbreviation + ", name=" + name + "]";
	}

}