package pe.com.tss.bean;

import java.io.Serializable;

import javax.persistence.Column;

public class UserOfficeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4000858896767728663L;

	@Column(name = "USER_ID")
	private long userid;
	@Column(name = "OFFICE_ID")
	private long officeid;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (officeid ^ (officeid >>> 32));
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
		UserOfficeId other = (UserOfficeId) obj;
		if (officeid != other.officeid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

}
