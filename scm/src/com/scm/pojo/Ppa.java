package com.scm.pojo;

import java.io.Serializable;
import java.util.List;

public class Ppa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ProcurementPlanAnalyze> ppa;

	public List<ProcurementPlanAnalyze> getPpa() {
		return ppa;
	}

	public void setPpa(List<ProcurementPlanAnalyze> ppa) {
		this.ppa = ppa;
	}

	public Ppa() {
		super();
	}

	@Override
	public String toString() {
		return "Ppa [ppa=" + ppa + "]";
	}
	

}
