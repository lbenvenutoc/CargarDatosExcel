package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;

/**
 * The persistent class for the OFFICE database table.
 * 
 */
@Entity
@Table(name = "OFFICE")
@NamedQueries({ @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o"),
	@NamedQuery(name = "Office.findByOfficeName", query = "SELECT o FROM Office o WHERE o.officename =:officename")
})
public class Office implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8487879561097563188L;

	@Id
	@Column(name = "OFFICE_ID")
	//@Basic(optional = false)
	@ReturnInsert(returnOnly=true)
	private long officeid;

	@Column(name = "CITY")
	private String city;

	@Column(name = "CREATED_BY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createddate;

	@Column(name = "OFFICE_NAME")
	private String officename;

	@Column(name = "STATE")
	private String state;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UPDATED_BY")
	private String updatedby;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updateddate;

	@Column(name = "ZIP_CODE")
	private String zipcode;

	public Office() {

	}

	public long getOfficeid() {
		return this.officeid;
	}

	public void setOfficeid(long officeid) {
		this.officeid = officeid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getOfficename() {
		return this.officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Office [officeid=" + officeid + ", city=" + city + ", createdby=" + createdby + ", createddate="
				+ createddate + ", officename=" + officename + ", state=" + state + ", status=" + status
				+ ", updatedby=" + updatedby + ", updateddate=" + updateddate + ", zipcode=" + zipcode + "]";
	}

}