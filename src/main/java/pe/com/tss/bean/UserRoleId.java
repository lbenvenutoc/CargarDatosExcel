package pe.com.tss.bean;

import java.io.Serializable;

import javax.persistence.Column;


public class UserRoleId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 497574909359481627L;
	
	@Column(name = "USER_ID")
	private long userid;
	@Column(name = "ROLE_ID")
	private long roleid;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roleid ^ (roleid >>> 32));
		result = prime * result + (int) (userid ^ (userid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleId other = (UserRoleId) obj;
		if (roleid != other.roleid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	

}
