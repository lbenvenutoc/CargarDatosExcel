package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the LOCATION database table.
 * 
 */
@Entity
@Table(name = "LOCATION")
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOCATION_ID")
	@Basic(optional = false)
	private long locationid;

	@Column(name = "IS_PC_MILER_VALID")
	private String ispcmilervalid;

	@Column(name = "RAMP_AREAID")
	private long rampareaid;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ZIP_CODE")
	private String zipcode;

	@Column(name = "CREATED_BY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createddate;

	@Column(name = "UPDATED_BY")
	private String updatedby;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updateddate;

	public Location() {
	}

	public long getLocationid() {
		return this.locationid;
	}

	public void setLocationid(long locationid) {
		this.locationid = locationid;
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

	public String getIspcmilervalid() {
		return this.ispcmilervalid;
	}

	public void setIspcmilervalid(String ispcmilervalid) {
		this.ispcmilervalid = ispcmilervalid;
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

	public long getRampareaid() {
		return rampareaid;
	}

	public void setRampareaid(long rampareaid) {
		this.rampareaid = rampareaid;
	}

}