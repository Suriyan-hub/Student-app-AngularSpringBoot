package com.project.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
  @Id
  @GeneratedValue
  @Column(name="sid")
  private int sid;
  
  @Column(name="scourse")
  private String scourse;
  
  @Column(name="sdisc")
  private double sdisc;
  
  
  @Column(name="sfee")
  private double sfee;
  
 
  @Column(name="sgst")
  private double sgst;
  
  @Column(name="sname")
  private String sname;
  
  public double getSdisc() {
	return sdisc;
}
public void setSdisc(double sdisc) {
	this.sdisc = sdisc;
}
public double getSgst() {
	return sgst;
}
public void setSgst(double sgst) {
	this.sgst = sgst;
}

  
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public double getSfee() {
	return sfee;
}
public void setSfee(double sfee) {
	this.sfee = sfee;
}
public String getScourse() {
	return scourse;
}
public void setScourse(String scourse) {
	this.scourse = scourse;
}

public Student() {
	super();
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", scourse=" + scourse + ", sdisc=" + sdisc + ", sfee=" + sfee + ", sgst=" + sgst
			+ ", sname=" + sname + "]";
}

  
}