package pe.com.tss.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.ReturnInsert;

@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "User.getUser", query = "SELECT u FROM User u WHERE u.username=:username")
	
})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4532144724295801515L;

	@Id
	//@Basic(optional = false)
	@Column(name = "USER_ID")
	@ReturnInsert(returnOnly=true)
	private long userid;

	@Column(name = "MANAGER_ID")
	private BigDecimal managerid=null;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firtsname;

	@Column(name = "LAST_NAME")
	private String lastname;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TITLE")
	private String title="-";
	
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

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public BigDecimal getManagerid() {
		return managerid;
	}

	public void setManagerid(BigDecimal managerid) {
		this.managerid = managerid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirtsname() {
		return firtsname;
	}

	public void setFirtsname(String firtsname) {
		this.firtsname = firtsname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", managerid=" + managerid + ", username=" + username + ", password="
				+ password + ", firtsname=" + firtsname + ", lastname=" + lastname + ", status=" + status + ", title="
				+ title + ", createdby=" + createdby + ", createddate=" + createddate + ", updatedby=" + updatedby
				+ ", updateddate=" + updateddate + "]";
	}

}
