package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the RAMP database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Ramp.findAll", query = "SELECT r FROM Ramp r"),
@NamedQuery(name = "Ramp.getRamp", query = "SELECT r FROM Ramp r WHERE r.code=:code AND r.name=:name AND r.zipCode=:zipCode"),
@NamedQuery(name = "Ramp.getRampCode", query = "SELECT r FROM Ramp r WHERE r.code=:code"),
@NamedQuery(name = "Ramp.existRamp", query = "SELECT COUNT(r.rampId) FROM Ramp r WHERE r.code=:code")
})
public class Ramp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@Column(name = "RAMP_ID")
	@ReturnInsert(returnOnly=true)
	private long rampId;

	@Column(name = "CODE")
	private String code;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "MARKET_ID")
	private long marketid;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "ZIP_CODE")
	private String zipCode="-";

	public Ramp() {
	}

	public long getRampId() {
		return this.rampId;
	}

	public void setRampId(long rampId) {
		this.rampId = rampId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getMarketid() {
		return marketid;
	}

	public void setMarketid(long marketid) {
		this.marketid = marketid;
	}

	@Override
	public String toString() {
		return "Ramp [rampId=" + rampId + ", code=" + code + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", name=" + name + ", status=" + status + ", marketid=" + marketid + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", zipCode=" + zipCode + "]";
	}

}