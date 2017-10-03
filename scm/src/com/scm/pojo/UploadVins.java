package com.scm.pojo;

import java.io.Serializable;

public class UploadVins implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String vinNumber;
	private String vinLast;
	private String engineCode;
	private String colorCode;
	private String explain;

	public UploadVins() {
		super();
	}

	public UploadVins(String vinNumber, String vinLast, String engineCode, String colorCode, String explain) {
		super();
		this.vinNumber = vinNumber;
		this.vinLast = vinLast;
		this.engineCode = engineCode;
		this.colorCode = colorCode;
		this.explain = explain;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getVinLast() {
		return vinLast;
	}

	public void setVinLast(String vinLast) {
		this.vinLast = vinLast;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return "UploadVins [vinNumber=" + vinNumber + ", vinLast=" + vinLast + ", engineCode=" + engineCode
				+ ", colorCode=" + colorCode + ", explain=" + explain + "]";
	}

}
