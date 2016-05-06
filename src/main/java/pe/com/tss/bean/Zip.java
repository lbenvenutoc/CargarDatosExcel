package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

/**
 * The persistent class for the ZIP database table.
 * 
 */
@Entity
@Table(name = "ZIP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Zip.findAll", query = "SELECT z FROM Zip z"),
		@NamedQuery(name = "Zip.existsZip", query = "SELECT COUNT(z.zipcode) FROM Zip z WHERE z.zipcode=:zipcode"),
		@NamedQuery(name = "Zip.getZip", query = "SELECT z FROM Zip z WHERE z.zipcode=:zipcode") })
public class Zip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "ZIP_ID")
	private long zipid;

	@Column(name = "CITY_ID")
	private long cityid;

	@Column(name = "ZIP_CODE")
	private String zipcode="-";

	public Zip() {
	}

	public long getZipid() {
		return this.zipid;
	}

	public void setZipid(long zipid) {
		this.zipid = zipid;
	}

	public long getCityid() {
		return this.cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Zip [zipid=" + zipid + ", cityid=" + cityid + ", zipcode=" + zipcode + "]";
	}

}