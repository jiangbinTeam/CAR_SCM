package com.scm.pojo;

import java.io.Serializable;

public class sailingPlan implements Serializable {
  private static final long serialVersionUID = -5514366538062195489L;

  /*29.船期安排（scm_sailingPlan）
  船期安排ID	sailingPlanID
  装运港	shippingPort
  船名	shipName
  目的港	aimPort
  船期编号	sailingPlanCode
  租赁费用	leasingCharge*/

  private Integer sailingPlanID;
  private String shippingPort;
  private String shipName;
  private String aimPort;
  private String sailingPlanCode;
  private Integer leasingCharge;

  public Integer getSailingPlanID() {
    return sailingPlanID;
  }

  public void setSailingPlanID(Integer sailingPlanID) {
    this.sailingPlanID = sailingPlanID;
  }

  public String getShippingPort() {
    return shippingPort;
  }

  public void setShippingPort(String shippingPort) {
    this.shippingPort = shippingPort;
  }

  public String getShipName() {
    return shipName;
  }

  public void setShipName(String shipName) {
    this.shipName = shipName;
  }

  public String getAimPort() {
    return aimPort;
  }

  public void setAimPort(String aimPort) {
    this.aimPort = aimPort;
  }

  public String getSailingPlanCode() {
    return sailingPlanCode;
  }

  public void setSailingPlanCode(String sailingPlanCode) {
    this.sailingPlanCode = sailingPlanCode;
  }

  public Integer getLeasingCharge() {
    return leasingCharge;
  }

  public void setLeasingCharge(Integer leasingCharge) {
    this.leasingCharge = leasingCharge;
  }

  public sailingPlan() {
    super();
  }

  @Override
  public String toString() {
    return "sailingPlan{" +
            "sailingPlanID=" + sailingPlanID +
            ", shippingPort='" + shippingPort + '\'' +
            ", shipName='" + shipName + '\'' +
            ", aimPort='" + aimPort + '\'' +
            ", sailingPlanCode='" + sailingPlanCode + '\'' +
            ", leasingCharge=" + leasingCharge +
            '}';
  }
}

