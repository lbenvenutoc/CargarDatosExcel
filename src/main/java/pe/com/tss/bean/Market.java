package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;


/**
 * The persistent class for the MARKET database table.
 * 
 */
@Entity
@Table(name = "MARKET")
@NamedQueries({
	@NamedQuery(name = "Market.findAll", query = "SELECT m FROM Market m"),
@NamedQuery(name = "Market.getMarket", query = "SELECT m FROM Market m WHERE m.name=:name")
})

public class Market implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@Column(name = "MARKET_ID")
	@ReturnInsert(returnOnly=true)
	private long marketId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "RAMP_AREAID")
	private long rampAreaId;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	public Market() {
	}

	public long getMarketId() {
		return this.marketId;
	}

	public void setMarketId(long marketId) {
		this.marketId = marketId;
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

	public long getRampAreaId() {
		return rampAreaId;
	}

	public void setRampAreaId(long rampAreaId) {
		this.rampAreaId = rampAreaId;
	}

	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", name="
				+ name + ", status=" + status + ", rampAreaId=" + rampAreaId + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

}