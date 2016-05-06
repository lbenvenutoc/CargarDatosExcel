package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;

/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
	@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
	@NamedQuery(name = "Customer.getCustomer", query = "SELECT c FROM Customer c WHERE c.code=:code"),
	@NamedQuery(name = "Customer.getCustomerName", query = "SELECT c FROM Customer c WHERE c.customername=:customername"),
	@NamedQuery(name = "Customer.existCustomer", query = "SELECT COUNT(c.customerid) FROM Customer c WHERE c.code=:code")
	
})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@Column(name = "CUSTOMER_ID")
	@ReturnInsert(returnOnly=true)
	private long customerid;

	@Column(name = "CODE")
	private String code;

	@Column(name = "CREATED_BY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createddate;

	@Column(name = "CUSTOMER_NAME")
	private String customername;

	@Column(name = "SALES_FORCE_ACCOUNT_ID")
	private long salesforceaccountid=0;
	
	@Column(name = "SALES_ACCOUNT_MANAGER_ID")
	private long salesaccountmanagerid;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UPDATED_BY")
	private String updatedby;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updateddate;

	@Column(name = "OFFICE_ID")
	private long officeid;

	public Customer() {
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
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

	public long getSalesforceaccountid() {
		return salesforceaccountid;
	}

	public void setSalesforceaccountid(long salesforceaccountid) {
		this.salesforceaccountid = salesforceaccountid;
	}

	public long getOfficeid() {
		return officeid;
	}

	public void setOfficeid(long officeid) {
		this.officeid = officeid;
	}

	public long getSalesaccountmanagerid() {
		return salesaccountmanagerid;
	}

	public void setSalesaccountmanagerid(long salesaccountmanagerid) {
		this.salesaccountmanagerid = salesaccountmanagerid;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", code=" + code + ", createdby=" + createdby + ", createddate="
				+ createddate + ", customername=" + customername + ", salesforceaccountid=" + salesforceaccountid
				+ ", salesaccountmanagerid=" + salesaccountmanagerid + ", status=" + status + ", updatedby=" + updatedby
				+ ", updateddate=" + updateddate + ", officeid=" + officeid + "]";
	}
	
	

}