package com.mainapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@NamedNativeQuery(name = "insert",query = "insert into employe(eid,ename,eaddress,esalary) values(:eid,:ename,:eaddress,:esalary)")
public class Employe {

	@Id
	private int eid;

	private String ename;
	
	private String eaddress;
	
	private int esalary;
	
	
	
	
	public Employe() {
		
	}
	
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public int getEsalary() {
		return esalary;
	}
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	public Employe(int eid, String ename, String eaddress, int esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}
	@Override
	public String toString() {
		return "Employe [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + "]";
	}
	
}
