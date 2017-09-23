package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.ProcurementPlanAnalyze;
import com.scm.pojo.YearProcurement;
import com.scm.pojo.YearProcurementPlan;

@Repository("procurementPlanMapper")
public interface ProcurementPlanMapper {

	//创建全年分解采购计划
	@Insert("insert into scm_procurementPlanAnalyze(yearProcurementPlanId,procurementPlanAnalyzeMonth,procurementPlanAnalyzeCount)"
			+ "values(#{yearProcurementPlanId,jdbcType=INTEGER},#{procurementPlanAnalyzeMonth,jdbcType=INTEGER},#{procurementPlanAnalyzeCount,jdbcType=INTEGER})")
	int add(ProcurementPlanAnalyze procurementPlanAnalyze);
	
	//修改全年分解采购计划
	@Update("update scm_procurementPlanAnalyze set procurementPlanAnalyzeCount=#{procurementPlanAnalyzeCount}"
			+ "where procurementPlanAnalyzeId=#{procurementPlanAnalyzeId}")
	int updates(ProcurementPlanAnalyze procurementPlanAnalyze);
	
	//按年份id查询全年采购计划
	@Select("select yearProcurementPlanId,yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,y.typecode,brand from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode where yearProcurementPlanId=#{yearProcurementPlanId}")
	YearProcurement findById(Integer yearProcurementPlanId);
	
	//按年份、id查看分解计划
	@Select("select brand,y.typeCode,yearProcurementPlanYear,yearProcurementPlanCount,p.yearProcurementPlanId,procurementPlanAnalyzeId,procurementPlanAnalyzeMonth,procurementPlanAnalyzeCount,carProcurementListCount from scm_procurementPlanAnalyze p "
			+ "left join scm_yearProcurementPlan y on p.yearProcurementPlanId=y.yearProcurementPlanId	left join scm_typeDictionary d on y.typeCode=d.typeCode left join scm_carProcurementList c on d.typecode=c.typecode "
			+ "where y.yearProcurementPlanYear=#{0} and p.yearProcurementPlanId=#{1} order by procurementPlanAnalyzeId")
	List<YearProcurement> findByYear(Integer yearProcurementPlanYear, Integer yearProcurementPlanId);
	
	//按年份查看分解计划
	@Select("select brand,y.typeCode,yearProcurementPlanYear,p.yearProcurementPlanId,procurementPlanAnalyzeMonth,procurementPlanAnalyzeCount,carProcurementListCount from scm_procurementPlanAnalyze p "
			+ "left join scm_yearProcurementPlan y on p.yearProcurementPlanId=y.yearProcurementPlanId	left join scm_typeDictionary d on y.typeCode=d.typeCode left join scm_carProcurementList c on d.typecode=c.typecode "
			+ "where y.yearProcurementPlanYear=#{yearProcurementPlanYear} order by procurementPlanAnalyzeId")
	List<YearProcurement> find(Integer yearProcurementPlanYear);
	
	//根据id修改状态 是否已经分解
	@Update("update scm_yearProcurementPlan set ifDecomposition=1 where yearProcurementPlanId=#{yearProcurementPlanId,jdbcType=INTEGER}")
	int update(Integer yearProcurementPlanId);
	
	//分页查询
	@Select("select * from  (select rownum nb,e.* from  (select brand,y.typeCode,yearProcurementPlanYear,p.yearProcurementPlanId,procurementPlanAnalyzeId,procurementPlanAnalyzeMonth,procurementPlanAnalyzeCount,carProcurementListCount from scm_procurementPlanAnalyze p "
			+ "left join scm_yearProcurementPlan y on p.yearProcurementPlanId=y.yearProcurementPlanId	left join scm_typeDictionary d on y.typeCode=d.typeCode left join scm_carProcurementList c on d.typecode=c.typecode "
			+ "where y.yearProcurementPlanYear=#{yearProcurementPlanYear} order by procurementPlanAnalyzeId DESC,procurementPlanAnalyzeMonth ASC) e) t where t.nb>=#{pageMin} and t.nb<=#{pageMax}")
	List<YearProcurement> findByPage(@Param("pageMin") Integer pageMin, 
																 @Param("pageMax") Integer pageMax,
																 @Param("yearProcurementPlanYear") Integer yearProcurementPlanYear);
			
	//查询记录条数
	@Select("select count(procurementPlanAnalyzeId) from  (select * from scm_procurementPlanAnalyze )")
	int countPage();
}
