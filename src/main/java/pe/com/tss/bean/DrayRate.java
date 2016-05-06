package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the DRAY_RATE database table.
 * 
 */
@Entity
@Table(name = "DRAY_RATE")
@NamedQuery(name = "DrayRate.findAll", query = "SELECT d FROM DrayRate d")
public class DrayRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DRAY_RATE_ID")
	@ReturnInsert(returnOnly=true)
	private long drayRateId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CUSTOMER_ID")
	private BigDecimal customerId;

	@Column(name = "DRAY_SERVICE_TYPE")
	private String drayServiceType;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;

	@Column(name = "EQUIPMENT_SIZE")
	private String equipmentSize;

	@Column(name = "EQUIPMENT_TYPE")
	private String equipmentType;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;

	@Column(name = "IS_HAZ_MAT")
	private String isHazMat;

	@Column(name = "IS_IMPORTED")
	private String isImported;

	@Column(name = "RATE")
	private BigDecimal rate;

	@Column(name = "RATE_BASIS")
	private String rateBasis;

	@Column(name = "RATE_TYPE")
	private String rateType;

	@Column(name = "SEGMENT_TYPE")
	private String segmentType="-";

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "VENDOR_ID")
	private long vendorId;

	@Column(name = "RAMP_ID")
	private long rampid;

	public DrayRate() {
	}

	public long getDrayRateId() {
		return this.drayRateId;
	}

	public void setDrayRateId(long drayRateId) {
		this.drayRateId = drayRateId;
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

	public BigDecimal getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public String getDrayServiceType() {
		return this.drayServiceType;
	}

	public void setDrayServiceType(String drayServiceType) {
		this.drayServiceType = drayServiceType;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEquipmentSize() {
		return this.equipmentSize;
	}

	public void setEquipmentSize(String equipmentSize) {
		this.equipmentSize = equipmentSize;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getIsHazMat() {
		return this.isHazMat;
	}

	public void setIsHazMat(String isHazMat) {
		this.isHazMat = isHazMat;
	}

	public String getIsImported() {
		return this.isImported;
	}

	public void setIsImported(String isImported) {
		this.isImported = isImported;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getRateBasis() {
		return this.rateBasis;
	}

	public void setRateBasis(String rateBasis) {
		this.rateBasis = rateBasis;
	}

	public String getRateType() {
		return this.rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getSegmentType() {
		return this.segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
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

	public long getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public long getRampid() {
		return rampid;
	}

	public void setRampid(long rampid) {
		this.rampid = rampid;
	}

	@Override
	public String toString() {
		return "DrayRate [drayRateId=" + drayRateId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", customerId=" + customerId + ", drayServiceType=" + drayServiceType + ", effectiveDate="
				+ effectiveDate + ", equipmentSize=" + equipmentSize + ", equipmentType=" + equipmentType
				+ ", expirationDate=" + expirationDate + ", isHazMat=" + isHazMat + ", isImported=" + isImported
				+ ", rate=" + rate + ", rateBasis=" + rateBasis + ", rateType=" + rateType + ", segmentType="
				+ segmentType + ", status=" + status + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", vendorId=" + vendorId + ", rampid=" + rampid + "]";
	}

}