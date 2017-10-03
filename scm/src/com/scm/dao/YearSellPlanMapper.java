package com.scm.dao;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Dealer;
import com.scm.pojo.SelectSell;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.YearPlanDealerAnalyze;
import com.scm.pojo.YearPlanMonthAnalyze;
import com.scm.pojo.YearSellPlan;


@Repository("yearSellPlanMapper")
public interface YearSellPlanMapper {
	@Insert("insert into Scm_YearSellPlan(typeCode,year,sellcount) "
			+ "values(#{typeCode,jdbcType=VARCHAR},#{year,jdbcType=INTEGER},#{sellcount,jdbcType=INTEGER})")
	int add(YearSellPlan yearSellPlan);
	
	@Select("select   year,sellcount,yearProcurementPlanCount,b.* "
			+ "from scm_yearProcurementPlan a  right join scm_typeDictionary b on "
			+ "a.typeCode=b.typeCode left join  scm_yearSellPlan c on b.typeCode=c.typeCode where sellcount is null order by year ")
	List<SelectSell> list();//创建销售单
	
	@Select("select distinct year  from scm_yearSellPlan a left join scm_typeDictionary b on a.typeCode=b.typeCode ")
	List<SelectSell> selYearTypt();
	
	@Select("select distinct b.*  from scm_yearSellPlan a left join scm_typeDictionary b on a.typeCode=b.typeCode ")
	List<SelectSell> selYearTypt2();
	

	@Select("select * from  (select rownum nb,e.* from  (select distinct c.ifDecomposition,year,sellcount,yearSellPlanId,yearProcurementPlanCount,b.* "
			+ "from scm_yearProcurementPlan a  right join scm_typeDictionary b on "
			+ "a.typeCode=b.typeCode left join  scm_yearSellPlan c on b.typeCode=c.typeCode where sellcount>0 order by year ) e) t "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}") // 分页
	List<SelectSell> findByPageSell(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	@Select("select count(sellcount) from  (select distinct year,sellcount,yearProcurementPlanCount,b.* "
			+ "from scm_yearProcurementPlan a  right join scm_typeDictionary b on "
			+ "a.typeCode=b.typeCode left join  scm_yearSellPlan c on b.typeCode=c.typeCode where sellcount>0 order by year  )")
	int countPageSell();// 查询记录条数
	
	@Select("select year,sellcount,yearSellPlanId,yearProcurementPlanCount,b.* "
			+ "from scm_yearProcurementPlan a  right join scm_typeDictionary b on "
			+ "a.typeCode=b.typeCode left join  scm_yearSellPlan c on b.typeCode=c.typeCode where "
			+ "yearSellPlanId=#{yearSellPlanId,jdbcType=INTEGER}   order by year ")
	SelectSell  findByid(@Param("yearSellPlanId")Integer yearSellPlanId);//根据ID查询
	
	
	@Update("update scm_yearSellPlan set sellcount=#{sellcount} where yearSellPlanId=#{yearSellPlanId,jdbcType=INTEGER}")
	int updateSell(YearSellPlan yearSellPlan);//根据ID修改数量
	
	@Insert("insert into scm_yearPlanMonthAnalyze(yearSellPlanId,yearPlanMouth,yearPlanCount) "
			+ "values(#{yearSellPlanId,jdbcType=INTEGER},#{yearPlanMouth,jdbcType=INTEGER},#{yearPlanCount,jdbcType=INTEGER})")
	int addMonth(YearPlanMonthAnalyze yearPlanMonthAnalyze);//按月份分解
	
	@Update("update scm_yearSellPlan set ifDecomposition=1 where yearSellPlanId=#{yearSellPlanId,jdbcType=INTEGER}")
	int updateDec(Integer yearSellPlanId);//根据ID修改月分解状态
	
	@Select("select  ifDec,yearPlanMouth,yearPlanCount,yearPlanMonthAnalyzeId,year,a.yearSellPlanId,b.* "
			+ " from scm_yearSellPlan a  left join scm_typeDictionary b on a.typeCode=b.typeCode "
			+ " right join  scm_yearPlanMonthAnalyze c on a.yearSellPlanId=c.yearSellPlanId where  "
			+ " a.yearSellPlanId=#{yearSellPlanId,jdbcType=INTEGER}   order by  c.yearPlanMonthAnalyzeId ")
	List<SelectSell> findByMouth(Integer yearSellPlanId );//根据ID查月份
	
	@Select("select  yearPlanMouth,yearPlanCount,yearPlanMonthAnalyzeId,year,a.yearSellPlanId,b.* "
			+ " from scm_yearSellPlan a  left join scm_typeDictionary b on a.typeCode=b.typeCode "
			+ " right join  scm_yearPlanMonthAnalyze c on a.yearSellPlanId=c.yearSellPlanId where  "
			+ " yearPlanMonthAnalyzeId=#{yearPlanMonthAnalyzeId,jdbcType=INTEGER}   order by  c.yearPlanMonthAnalyzeId ")
	SelectSell findByMouthID(Integer yearPlanMonthAnalyzeId );//根据ID查单个月份
	
	@Update("update scm_yearPlanMonthAnalyze set yearPlanCount=#{yearPlanCount} where yearPlanMonthAnalyzeId=#{yearPlanMonthAnalyzeId,jdbcType=INTEGER}")
	int updateMonth(YearPlanMonthAnalyze yearPlanMonthAnalyze);//根据ID修改数量
	
	@Select("select * from scm_dealer")
	List<Dealer> listDealer();//查所有经销商
	
	@Insert("insert into scn_yearPlanDealerAnalyze(yearPlanMonthAnalyzeId,dealerId,yearPlanDealerCount) "
			+ "values(#{yearPlanMonthAnalyzeId,jdbcType=INTEGER},#{dealerId,jdbcType=INTEGER},#{yearPlanDealerCount,jdbcType=INTEGER})")
	int addDealer(YearPlanDealerAnalyze yearPlanDealerAnalyze);//添加经销商分解计划
	
	@Update("update scm_yearPlanMonthAnalyze set ifDec=1 where yearPlanMonthAnalyzeId=#{yearPlanMonthAnalyzeId,jdbcType=INTEGER}")
	int updateifDec(Integer yearPlanMonthAnalyzeId);//根据ID修改经销商分解状态
	
	@Select("select yearSellPlanId from scm_yearPlanMonthAnalyze where yearPlanMonthAnalyzeId=#{yearPlanMonthAnalyzeId,jdbcType=INTEGER}")
	Integer findYearId(Integer yearPlanMonthAnalyzeId );//查所有经销商
		
	@Select("select * from  (select rownum nb,e.* from  (select  ifDec,yearPlanMouth,yearPlanCount,yearPlanMonthAnalyzeId,year,a.yearSellPlanId,b.* "
			+ " from scm_yearSellPlan a  left join scm_typeDictionary b on a.typeCode=b.typeCode "
			+ " right join  scm_yearPlanMonthAnalyze c on a.yearSellPlanId=c.yearSellPlanId  "
			+ "  where year=#{year,jdbcType=INTEGER} and b.typeCode=#{typeCode,jdbcType=VARCHAR}  order by  c.yearPlanMonthAnalyzeId ) e) t "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}") // month分页
	List<SelectSell> findAllMouth(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax
									, @Param("year") Integer year,@Param("typeCode") String  typeCode);
	
	@Select("select count(yearPlanMonthAnalyzeId) from  (select  ifDec,yearPlanMouth,yearPlanCount,yearPlanMonthAnalyzeId,year,a.yearSellPlanId,b.* "
			+ " from scm_yearSellPlan a  left join scm_typeDictionary b on a.typeCode=b.typeCode "
			+ " right join  scm_yearPlanMonthAnalyze c on a.yearSellPlanId=c.yearSellPlanId  "
			+ "	 where year=#{year,jdbcType=INTEGER} and b.typeCode=#{typeCode,jdbcType=VARCHAR}  order by  c.yearPlanMonthAnalyzeId   )")
	int countPageDealer( @Param("year") Integer year,@Param("typeCode") String  typeCode);// month查询记录条数
	
	
	@Select("select * from  (select rownum nb,l.* from  (select year,yearPlanMouth,d.*,principalName,storefrontName,yearPlanDealerCount "
			+ "from  scn_yearPlanDealerAnalyze a left join scm_dealer e on a.dealerId=e.Dealerid "
			+ "left join scm_yearPlanMonthAnalyze b on a.yearPlanMonthAnalyzeId=b.yearPlanMonthAnalyzeId "
			+ " left join scm_yearSellPlan c on b.yearSellPlanId=c.yearSellPlanId "
			+ " left join scm_typeDictionary d on c.typeCode=d.typecode  order by  principalName) l) t "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}")
	List<SelectSell> findAllDea(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
						  
	@Select("select count(yearplandealeranalyzeid) from  (select rownum nb,l.* from  (select yearplandealeranalyzeid, year,yearPlanMouth,d.*,principalName,storefrontName,yearPlanDealerCount "
			+ "from  scn_yearPlanDealerAnalyze a left join scm_dealer e on a.dealerId=e.Dealerid "
			+ "left join scm_yearPlanMonthAnalyze b on a.yearPlanMonthAnalyzeId=b.yearPlanMonthAnalyzeId "
			+ " left join scm_yearSellPlan c on b.yearSellPlanId=c.yearSellPlanId "
			+ " left join scm_typeDictionary d on c.typeCode=d.typecode  order by  principalName  )l )")
	int countPageDea();// 经销商查询记录条数
	
	
	@Select("select * from  (select rownum nb,l.* from  (select year,yearPlanMouth,d.*,principalName,storefrontName,yearPlanDealerCount "
			+ "from  scn_yearPlanDealerAnalyze a left join scm_dealer e on a.dealerId=e.Dealerid "
			+ "left join scm_yearPlanMonthAnalyze b on a.yearPlanMonthAnalyzeId=b.yearPlanMonthAnalyzeId "
			+ " left join scm_yearSellPlan c on b.yearSellPlanId=c.yearSellPlanId "
			+ " left join scm_typeDictionary d on c.typeCode=d.typecode where principalName=#{principalName,jdbcType=VARCHAR}  order by  principalName) l) t "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}")
	List<SelectSell> findAllDea2(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			 @Param("principalName") String  principalName);
						  
	@Select("select count(yearplandealeranalyzeid) from  (select rownum nb,l.* from  (select yearplandealeranalyzeid, year,yearPlanMouth,d.*,principalName,storefrontName,yearPlanDealerCount "
			+ "from  scn_yearPlanDealerAnalyze a left join scm_dealer e on a.dealerId=e.Dealerid "
			+ "left join scm_yearPlanMonthAnalyze b on a.yearPlanMonthAnalyzeId=b.yearPlanMonthAnalyzeId "
			+ " left join scm_yearSellPlan c on b.yearSellPlanId=c.yearSellPlanId "
			+ " left join scm_typeDictionary d on c.typeCode=d.typecode where principalName=#{principalName,jdbcType=VARCHAR}  order by  principalName  )l )")
	int countPageDea2( @Param("principalName") String  principalName);// 经销商查询记录条数
	
	@Select("select * from scm_dealer")
	List<Dealer> selYearTypt3();
}
