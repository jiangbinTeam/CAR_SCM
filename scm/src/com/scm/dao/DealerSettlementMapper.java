package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Dealer;
import com.scm.pojo.DealerSettlement;

@Repository("dealerSettlementMapper")
public interface DealerSettlementMapper {

	List<DealerSettlement> listByDealerId(@Param("dealerId") Integer dealerId);

	// 分页查询
	List<DealerSettlement> pageList(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			@Param("dealerId") Integer dealerId);

	// 计算符合条件的总记录数
	int totalcount(@Param("dealerId") Integer dealerId);

	@Select("select * from scm_dealer")
	List<Dealer> listid();// 拿到经销商
}
