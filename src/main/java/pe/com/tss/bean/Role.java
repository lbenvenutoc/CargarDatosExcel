package pe.com.tss.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;

/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name = "ROLE")
@NamedQueries({ @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
		@NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.rolename=:rolename") })

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@Column(name = "ROLE_ID")
	@ReturnInsert(returnOnly=true)
	private long roleid;

	@Column(name = "CREATED_BY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createddate;

	@Column(name = "ROLE_NAME")
	private String rolename;

	@Column(name = "UPDATED_BY")
	private String updatedby;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updateddate;

	public Role() {
	}

	public long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
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

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", createdby=" + createdby + ", createddate=" + createddate + ", rolename="
				+ rolename + ", updatedby=" + updatedby + ", updateddate=" + updateddate + "]";
	}

}