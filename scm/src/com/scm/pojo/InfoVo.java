package com.scm.pojo;

import java.io.Serializable;

//将Excel每一行数值转换为对象
public class InfoVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String index;
	private String id;
	private String vinNumber;
	private String sellMoney;
	private String payMoney;

	public InfoVo() {
		super();
	}

	public InfoVo(String index, String id, String vinNumber, String sellMoney, String payMoney) {
		super();
		this.index = index;
		this.id = id;
		this.vinNumber = vinNumber;
		this.sellMoney = sellMoney;
		this.payMoney = payMoney;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getSellMoney() {
		return sellMoney;
	}

	public void setSellMoney(String sellMoney) {
		this.sellMoney = sellMoney;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	@Override
	public String toString() {
		return "InfoVo [index=" + index + ", id=" + id + ", vinNumber=" + vinNumber + ", sellMoney=" + sellMoney
				+ ", payMoney=" + payMoney + "]";
	}

}
