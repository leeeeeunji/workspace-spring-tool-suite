package com.mybatis3.domain;

import java.io.Serializable;
import java.util.List;


public class Address implements Serializable
{
	/*
	이름      널?       유형           
	------- -------- ------------ 
	ADDR_ID NOT NULL NUMBER(11)   
	STREET  NOT NULL VARCHAR2(50) 
	CITY    NOT NULL VARCHAR2(50) 
	STATE   NOT NULL VARCHAR2(50) 
	ZIP              VARCHAR2(10) 
	COUNTRY NOT NULL VARCHAR2(50)
	 */
	private Integer addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private List<Student> studentList;
	
	
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", street=" + street + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + ", studentList=" + studentList + "]";
	}
	public Address()
	{
	}
	public Address(Integer addrId)
	{
		this.addrId = addrId;
	}
	public Address(Integer addrId, String street, String city, String state,
			String zip, String country)
	{
		this.addrId = addrId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
