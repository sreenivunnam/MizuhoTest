package com.trivikram.MizuhoTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrument {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int ID;
	private String name;
	private String price;
	private String BusinessDate;
	private String providerName;
	private LocalDateTime time;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getInstrumentName() {
		return name;
	}

	public void setInstrumentName(String instrumentName) {
		this.name = instrumentName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBusinessDate() {
		return BusinessDate;
	}

	public void setBusinessDate(String businessDate) {
		BusinessDate = businessDate;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "Instrument [ID=" + ID + ", instrumentName=" + name + ", price=" + price + ", BusinessDate="
				+ BusinessDate + ", providerName=" + providerName + "]";
	}

	public Instrument(int iD, String instrumentName, String price, String businessDate, String providerName) {
		super();
		ID = iD;
		this.name = instrumentName;
		this.price = price;
		BusinessDate = businessDate;
		this.providerName = providerName;
	}

	public Instrument() {
		super();
		// TODO Auto-generated constructor stub
	}

}
