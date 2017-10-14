package com.scm.pojo;

import java.io.Serializable;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Billing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String vinNumber;
	private String invoiceNumber;//��Ʊ��
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date invoiceDate;//��Ʊʱ��
	private String carCharacter; //��������
	private String colorName;//����ɫ
	public Billing(String vinNumber, String invoiceNumber, Date invoiceDate, String carCharacter, String colorName) {
		super();
		this.vinNumber = vinNumber;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.carCharacter = carCharacter;
		this.colorName = colorName;
	}
	public Billing() {
		super();
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCarCharacter() {
		return carCharacter;
	}
	public void setCarCharacter(String carCharacter) {
		this.carCharacter = carCharacter;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	@Override
	public String toString() {
		return "Billing [vinNumber=" + vinNumber + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", carCharacter=" + carCharacter + ", colorName=" + colorName + "]";
	}
	
	
	

}
