package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;


/**
 * The persistent class for the RAMP_AREA database table.
 * 
 */
@Entity
@Table(name = "RAMP_AREA")
@NamedQueries({
@NamedQuery(name = "RampArea.findAll", query = "SELECT r FROM RampArea r"),
@NamedQuery(name = "RampArea.exitsRampArea", query = "SELECT COUNT(r.rampAreaId) FROM RampArea r WHERE r.name=:name AND r.country=:country AND r.state=:state AND r.city=:city"),
@NamedQuery(name = "RampArea.getRampArea", query = "SELECT r FROM RampArea r WHERE r.name=:name AND r.country=:country AND r.state=:state AND r.city=:city")
})
public class RampArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@Column(name = "RAMP_AREA_ID")
	@ReturnInsert(returnOnly=true)
	private long rampAreaId;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATE")
	private String state;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	public RampArea() {
	}

	public long getRampAreaId() {
		return this.rampAreaId;
	}

	public void setRampAreaId(long rampAreaId) {
		this.rampAreaId = rampAreaId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "RampArea [rampAreaId=" + rampAreaId + ", city=" + city + ", country=" + country + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", name=" + name + ", state=" + state + ", status="
				+ status + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}