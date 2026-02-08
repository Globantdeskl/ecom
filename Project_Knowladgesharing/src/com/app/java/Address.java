package com.app.java;

public class Address {

	private String city;
	private String country;
	private int code;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Address(String city, String country, int code) {
		super();
		this.city = city;
		this.country = country;
		this.code = code;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", code=" + code + "]";
	}

}
