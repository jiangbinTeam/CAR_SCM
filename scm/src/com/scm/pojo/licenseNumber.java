package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class licenseNumber implements Serializable {
  private static final long serialVersionUID = 7854968377668315359L;
  /*30.许可证（scm_licenseNumber）
  Name	Code	Data Type
 许可证ID	licenseNumberId	INT
 许可证编号	licenseNumber	NVARCHAR2(200)
 颁发日期	startDate	DATE
 到期日期	endDate	DATE*/

  private Integer licenseNumberId;
  private String licenseNumber;
  private Date startDate;
  private Date endDate;

  public licenseNumber() {
    super();
  }

  public Integer getLicenseNumberId() {
    return licenseNumberId;
  }

  public void setLicenseNumberId(Integer licenseNumberId) {
    this.licenseNumberId = licenseNumberId;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "licenseNumber{" +
            "licenseNumberId=" + licenseNumberId +
            ", licenseNumber='" + licenseNumber + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            '}';
  }
}
