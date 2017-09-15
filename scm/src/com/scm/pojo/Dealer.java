package com.scm.pojo;

import java.io.Serializable;

public class Dealer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer dealerId;
	private Integer dealerBalance;
	private String dealerName;
	private String storefrontAddress;
	private String storefrontName;
	private String dealerMobile;
	private String dealerFaxes;
	private String portAddress;
	private String principalName;

	public Dealer(Integer dealerId, Integer dealerBalance, String dealerName, String storefrontAddress,
			String storefrontName, String dealerMobile, String dealerFaxes, String portAddress, String principalName) {
		super();
		this.dealerId = dealerId;
		this.dealerBalance = dealerBalance;
		this.dealerName = dealerName;
		this.storefrontAddress = storefrontAddress;
		this.storefrontName = storefrontName;
		this.dealerMobile = dealerMobile;
		this.dealerFaxes = dealerFaxes;
		this.portAddress = portAddress;
		this.principalName = principalName;
	}

	public Dealer() {
		super();
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public Integer getDealerBalance() {
		return dealerBalance;
	}

	public void setDealerBalance(Integer dealerBalance) {
		this.dealerBalance = dealerBalance;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getStorefrontAddress() {
		return storefrontAddress;
	}

	public void setStorefrontAddress(String storefrontAddress) {
		this.storefrontAddress = storefrontAddress;
	}

	public String getStorefrontName() {
		return storefrontName;
	}

	public void setStorefrontName(String storefrontName) {
		this.storefrontName = storefrontName;
	}

	public String getDealerMobile() {
		return dealerMobile;
	}

	public void setDealerMobile(String dealerMobile) {
		this.dealerMobile = dealerMobile;
	}

	public String getDealerFaxes() {
		return dealerFaxes;
	}

	public void setDealerFaxes(String dealerFaxes) {
		this.dealerFaxes = dealerFaxes;
	}

	public String getPortAddress() {
		return portAddress;
	}

	public void setPortAddress(String portAddress) {
		this.portAddress = portAddress;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	@Override
	public String toString() {
		return "Scm_Dealer [dealerId=" + dealerId + ", dealerBalance=" + dealerBalance + ", dealerName=" + dealerName
				+ ", storefrontAddress=" + storefrontAddress + ", storefrontName=" + storefrontName + ", dealerMobile="
				+ dealerMobile + ", dealerFaxes=" + dealerFaxes + ", portAddress=" + portAddress + ", principalName="
				+ principalName + "]";
	}

}
