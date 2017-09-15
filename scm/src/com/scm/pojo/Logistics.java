package com.scm.pojo;

import java.io.Serializable;

/*
 * 物流公司的pojo类
 */
public class Logistics implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer logisticsId;//物流公司主键
	private String logisticsName;//公司名称
	private String logisticsTel;//公司电话
	private String logisticsContact;//公司联系人
	private String logisticsContactTel;//联系人手机号码

	public Logistics() {
		super();
	}

	public Logistics(Integer logisticsId, String logisticsName, String logisticsTel, String logisticsContact,
			String logisticsContactTel) {
		super();
		this.logisticsId = logisticsId;
		this.logisticsName = logisticsName;
		this.logisticsTel = logisticsTel;
		this.logisticsContact = logisticsContact;
		this.logisticsContactTel = logisticsContactTel;
	}

	public Integer getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
	}

	public String getLogisticsName() {
		return logisticsName;
	}

	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}

	public String getLogisticsTel() {
		return logisticsTel;
	}

	public void setLogisticsTel(String logisticsTel) {
		this.logisticsTel = logisticsTel;
	}

	public String getLogisticsContact() {
		return logisticsContact;
	}

	public void setLogisticsContact(String logisticsContact) {
		this.logisticsContact = logisticsContact;
	}

	public String getLogisticsContactTel() {
		return logisticsContactTel;
	}

	public void setLogisticsContactTel(String logisticsContactTel) {
		this.logisticsContactTel = logisticsContactTel;
	}

	@Override
	public String toString() {
		return "Scm_Logistics [logisticsId=" + logisticsId + ", logisticsName=" + logisticsName + ", logisticsTel="
				+ logisticsTel + ", logisticsContact=" + logisticsContact + ", logisticsContactTel="
				+ logisticsContactTel + "]";
	}

}
