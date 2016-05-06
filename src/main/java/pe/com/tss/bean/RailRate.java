package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the RAIL_RATE database table.
 * 
 */
@Entity
@Table(name = "RAIL_RATE")
@NamedQuery(name = "RailRate.findAll", query = "SELECT r FROM RailRate r")
public class RailRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RAIL_RATE_ID")
	@ReturnInsert(returnOnly = true)
	private long railRateId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CUSTOMER_ID")
	private BigDecimal customerId;

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

	private BigDecimal fuel;

	@Column(name = "IS_HAZ_MAT")
	private String isHazMat;

	@Column(name = "IS_IMPORTED")
	private String isImported;

	@Column(name = "LINE_HAULCOST")
	private BigDecimal lineHaulcost;

	private BigDecimal miles;

	@Column(name = "RATE_TYPE")
	private String rateType;

	@Column(name = "SERVICE_LEVEL")
	private String serviceLevel;

	private String status;

	private String stcc;

	@Column(name = "TARIFF_NUMBER")
	private String tariffNumber;

	@Column(name = "TRANSIT_DAYS")
	private BigDecimal transitDays;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "VENDOR_ID")
	private long vendorId;

	@Column(name = "ORIGIN_RAMP_ID")
	private long originrampid;

	@Column(name = "DESTINATION_RAMP_ID")
	private long destinationrampid;

	public RailRate() {
	}

	public long getRailRateId() {
		return this.railRateId;
	}

	public void setRailRateId(long railRateId) {
		this.railRateId = railRateId;
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

	public BigDecimal getFuel() {
		return this.fuel;
	}

	public void setFuel(BigDecimal fuel) {
		this.fuel = fuel;
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

	public BigDecimal getLineHaulcost() {
		return this.lineHaulcost;
	}

	public void setLineHaulcost(BigDecimal lineHaulcost) {
		this.lineHaulcost = lineHaulcost;
	}

	public BigDecimal getMiles() {
		return this.miles;
	}

	public void setMiles(BigDecimal miles) {
		this.miles = miles;
	}

	public String getRateType() {
		return this.rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStcc() {
		return this.stcc;
	}

	public void setStcc(String stcc) {
		this.stcc = stcc;
	}

	public String getTariffNumber() {
		return this.tariffNumber;
	}

	public void setTariffNumber(String tariffNumber) {
		this.tariffNumber = tariffNumber;
	}

	public BigDecimal getTransitDays() {
		return this.transitDays;
	}

	public void setTransitDays(BigDecimal transitDays) {
		this.transitDays = transitDays;
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

	public long getOriginrampid() {
		return originrampid;
	}

	public void setOriginrampid(long originrampid) {
		this.originrampid = originrampid;
	}

	public long getDestinationrampid() {
		return destinationrampid;
	}

	public void setDestinationrampid(long destinationrampid) {
		this.destinationrampid = destinationrampid;
	}

	@Override
	public String toString() {
		return "RailRate [railRateId=" + railRateId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", customerId=" + customerId + ", effectiveDate=" + effectiveDate + ", equipmentSize=" + equipmentSize
				+ ", equipmentType=" + equipmentType + ", expirationDate=" + expirationDate + ", fuel=" + fuel
				+ ", isHazMat=" + isHazMat + ", isImported=" + isImported + ", lineHaulcost=" + lineHaulcost
				+ ", miles=" + miles + ", rateType=" + rateType + ", serviceLevel=" + serviceLevel + ", status="
				+ status + ", stcc=" + stcc + ", tariffNumber=" + tariffNumber + ", transitDays=" + transitDays
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", vendorId=" + vendorId
				+ ", originrampid=" + originrampid + ", destinationrampid=" + destinationrampid + "]";
	}

}