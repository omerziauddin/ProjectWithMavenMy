package com.tut;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
	//we want addressId to be primary key of table student_address
	
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen
				+ ", x=" + x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}

	//hibernate will automatically generate primary key valye for @GeneratedValue we provide paramaeter
	//strategy jo id aapki autoincrement hogi wo kis hisaab se hogi sequence hogi ki identity hogi
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	
	//we want street length to be only 50
	@Column(length=50,name="STREET")
	private String street;
	
	
	@Column(length=100,name="CITY")
	private String city;
	
	
	
	@Column(name="is_open")
	private boolean isOpen;
	
	//i want hibernate not to create this column so use @ Transient
	@Transient
	private double x;
	
	
	//y address kab add hoga uska date muje store karana h 
	@Column(name="added_date")
	@Temporal(TemporalType.DATE)    //me chahta hoon ki time na aye sirf date aye used to format date
	private Date addedDate;
	
	
	
	//image leke byte type ki array me convert karne k liye;	
	@Lob    //to tell hibernate that image is a large object
	private byte[] image;
	
	
	
	
    
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

	public Address() {
		super();
		
	}

	
	
	
	
}
