package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;

/**
 * The persistent class for the VENDOR database table.
 * 
 */
@Entity
@Table(name = "VENDOR")


@NamedQueries({
	@NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
	@NamedQuery(name = "Vendor.exitsVendor", query = "SELECT COUNT(v.vendorid) FROM Vendor v WHERE v.code=:code AND v.name=:name AND v.vendortype=:vendortype"),
	@NamedQuery(name = "Vendor.exitsVendorCode", query = "SELECT COUNT(v.vendorid) FROM Vendor v WHERE v.code=:code"),
	@NamedQuery(name = "Vendor.getVendor", query = "SELECT v FROM Vendor v WHERE v.code=:code"),
	@NamedQuery(name = "Vendor.getVendorName", query = "SELECT v FROM Vendor v WHERE v.name=:name")
	})

public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VENDOR_ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@Basic(optional = false)
	@ReturnInsert(returnOnly=true)
	private long vendorid;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "VENDOR_TYPE")
	private String vendortype;

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

	public Vendor() {
	}

	public long getVendorid() {
		return this.vendorid;
	}

	public void setVendorid(long vendorid) {
		this.vendorid = vendorid;
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

	public String getVendortype() {
		return this.vendortype;
	}

	public void setVendortype(String vendortype) {
		this.vendortype = vendortype;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", code=" + code + ", name=" + name + ", status=" + status
				+ ", vendortype=" + vendortype + ", createdby=" + createdby + ", createddate=" + createddate
				+ ", updatedby=" + updatedby + ", updateddate=" + updateddate + "]";
	}

}