package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Dealer;

@Repository("dealerMapper")
public interface DealerMapper {

	@Select("select dealerId,dealerBalance,dealerName,storefrontAddress,storefrontName,dealerMobile,dealerFaxes,portAddress,principalName from Scm_Dealer where dealerId=#{dealerId}")
	Dealer findByid(Integer dealerId);

	@Select("select dealerId,dealerBalance,dealerName,storefrontAddress,storefrontName,dealerMobile,dealerFaxes,portAddress,principalName from Scm_Dealer")
	List<Dealer> All();

	@Update("update  Scm_Dealer set dealerBalance=#{dealerBalance,jdbcType=INTEGER}, "
			+ "dealerName=#{dealerName,jdbcType=VARCHAR},storefrontAddress=#{storefrontAddress,jdbcType=VARCHAR},"
			+ "storefrontName=#{storefrontName,jdbcType=VARCHAR},dealerMobile=#{dealerMobile,jdbcType=VARCHAR},"
			+ "dealerFaxes=#{dealerFaxes,jdbcType=VARCHAR},portAddress=#{portAddress,jdbcType=VARCHAR},"
			+ "principalName=#{principalName,jdbcType=VARCHAR} where dealerId=#{dealerId}")
	int modifa(Dealer scm);

	@Insert("insert into Scm_Dealer(dealerId,dealerBalance,dealerName,storefrontAddress,storefrontName,"
			+ "dealerMobile,dealerFaxes,portAddress,principalName) values(#{dealerId},#{dealerBalance,jdbcType=INTEGER},"
			+ "#{dealerName,jdbcType=VARCHAR},#{storefrontAddress,jdbcType=VARCHAR},#{storefrontName,jdbcType=VARCHAR},"
			+ "#{dealerMobile,jdbcType=VARCHAR},#{dealerFaxes,jdbcType=VARCHAR},#{portAddress,jdbcType=VARCHAR},"
			+ "#{principalName,jdbcType=VARCHAR})")
	@SelectKey(keyProperty = "dealerId", statement = "select dealer.nextval from dual", before = true, resultType = int.class)
	int add(Dealer scm);

	List<Dealer> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order, @Param("dealerName") String dealerName);

	int findPagerTotal(@Param("dealerName") String dealerName);

	@Select("select count(DEALERID) from Scm_Dealer")
	int total();// 总记录数

	@Select("select * from (select rownum rn,d.* from Scm_Dealer d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax}")
	List<Dealer> listByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);// 分页查询

}
