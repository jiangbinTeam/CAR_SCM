package com.scm.pojo;

import java.util.List;

public class DealerList {
	
	private  List<YearPlanDealerAnalyze> dealers;

	public List<YearPlanDealerAnalyze> getDealers() {
		return dealers;
	}

	public void setDealers(List<YearPlanDealerAnalyze> dealers) {
		this.dealers = dealers;
	}

	public DealerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DealerList(List<YearPlanDealerAnalyze> dealers) {
		super();
		this.dealers = dealers;
	}

	@Override
	public String toString() {
		return "DealerList [dealers=" + dealers + "]";
	}

	
}
