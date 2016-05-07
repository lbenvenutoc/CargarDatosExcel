package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.math.BigDecimal;

/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@Table(name = "CITY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
		@NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name=:name"),
		@NamedQuery(name = "City.exitsCity", query = "SELECT COUNT(c.name) FROM City c WHERE c.name=:name"),
		@NamedQuery(name = "City.getCity", query = "SELECT c FROM City c WHERE c.name=:name")
})
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "CITY_ID")
	@ReturnInsert(returnOnly=true)	
	private long cityid;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "STATE_ID")
	private long stateid;

	public City() {
	}

	public long getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStateid() {
		return this.stateid;
	}

	public void setStateid(long stateid) {
		this.stateid = stateid;
	}

	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", name=" + name + ", stateid=" + stateid + "]";
	}
	
	

}