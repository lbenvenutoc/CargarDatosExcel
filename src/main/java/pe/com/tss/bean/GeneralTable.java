package pe.com.tss.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="GENERAL_TABLE")
@NamedQueries({
	@NamedQuery(name = "GeneralTable.existGeneralTable", query = "SELECT COUNT(g.generaltableid) FROM GeneralTable g WHERE g.value=:value"),
	@NamedQuery(name = "GeneralTable.getAll", query = "SELECT g FROM GeneralTable g"),
	@NamedQuery(name = "GeneralTable.getGeneralTable", query = "SELECT g FROM GeneralTable g WHERE g.code=:code")
})

public class GeneralTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1094420543319274738L;
	
	@Id
	@Basic(optional = false)
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "GENERAL_TABLE_ID")	
	private long generaltableid;
	
	@Column(name = "TABLE_NAME")	
	private String tablename;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "SORT_ORDER")
	private int sortorder;
	
	
	public long getGeneraltableid() {
		return generaltableid;
	}
	public void setGeneraltableid(long generaltableid) {
		this.generaltableid = generaltableid;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	
	

}
