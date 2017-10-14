package com.scm.dao;
/*
 * 全年采购计划 映射器接口
 */

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.TypeDictionary;
import com.scm.pojo.YearProcurement;
import com.scm.pojo.YearProcurementPlan;

@Repository("yearProcurementMapper")
public interface YearProcurementMapper {

	// 创建全年采购计划
	@Insert("insert into scm_yearProcurementPlan(yearProcurementPlanYear,yearProcurementPlanCount,typecode,ifDecomposition)"
			+ "values(#{yearProcurementPlanYear,jdbcType=VARCHAR},#{yearProcurementPlanCount,jdbcType=INTEGER},#{typeCode,jdbcType=VARCHAR},#{ifDecomposition})")
	// // 在 insert 操作之前,产生 Oracle 序列值,赋值给属性 id
	// @SelectKey(keyProperty = "yearProcurementPlanId", statement = "select
	// yearProcurementPlan.NEXTVAL INTO :new.yearProcurementPlanId from dual",
	// resultType = int.class, before = true)
	int add(YearProcurementPlan yearProcurementPlan);

	// 修改全年采购计划
	@Update("update scm_yearProcurementPlan set yearProcurementPlanCount=#{yearProcurementPlanCount,jdbcType=INTEGER}"
			+ "where yearProcurementPlanId=#{yearProcurementPlanId}")
	int update(YearProcurementPlan yearProcurementPlan);

	// 查采购计划年份
	/*
	 * @Select("select yearProcurementPlanId,yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,y.typecode,brand,carCharacter,carProcurementListCount from scm_yearProcurementPlan y "
	 * +
	 * "left join scm_typeDictionary d on y.typecode=d.typecode left join scm_carProcurementList c on y.typecode=c.typecode order by yearProcurementPlanId desc"
	 * )
	 */
	@Select("select distinct yearProcurementPlanYear from scm_yearProcurementPlan order by yearProcurementPlanYear asc")
	List<YearProcurement> findAll();

	// 判断本年是否还有未做采购计划的车型
	@Select("select d.typecode,brand,carCharacter,carProcurementListCount,yearProcurementPlanId from scm_typeDictionary d "
			+ "left join scm_yearProcurementPlan y  on d.typecode=y.typecode left join scm_carProcurementList c on d.typecode=c.typecode where yearProcurementPlanId is null order by yearProcurementPlanId desc")
	List<YearProcurement> find();

	// 按年份查全年采购计划
	@Select("select yearProcurementPlanId,yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,y.typecode,brand,carCharacter,carProcurementListCount from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode left join scm_carProcurementList c on y.typecode=c.typecode where yearProcurementPlanYear=#{yearProcurementPlanYear} order by yearProcurementPlanId desc")
	List<YearProcurement> findYear(Integer yearProcurementPlanYear);

	// 按id查全年采购计划
	@Select("select yearProcurementPlanId,yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,y.typecode,brand,carCharacter,carProcurementListCount from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode left join scm_carProcurementList c on y.typecode=c.typecode where yearProcurementPlanId=#{yearProcurementPlanId}")
	YearProcurement findById(Integer yearProcurementPlanId);

	// 分页查询
	@Select("select * from  (select rownum nb,e.* from  (select y.* ,brand,carCharacter,carProcurementListCount from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode left join scm_carProcurementList c on y.typecode=c.typecode where yearProcurementPlanYear=#{yearProcurementPlanYear} order by yearProcurementPlanId desc) e) t  "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}")
	List<YearProcurement> findByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			@Param("yearProcurementPlanYear") Integer yearProcurementPlanYear);

	// 查询记录条数
	@Select("select count(yearProcurementPlanId) from  (select y.* ,brand,carCharacter,carProcurementListCount from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode left join scm_carProcurementList c on y.typecode=c.typecode) where yearProcurementPlanYear=#{yearProcurementPlanYear}")
	int countPage(Integer yearProcurementPlanYear);

	// 根据年份查车型
	@Select("select yearProcurementPlanId,yearProcurementPlanYear,brand,y.typeCode from scm_yearProcurementPlan y "
			+ "left join scm_typeDictionary d on y.typecode=d.typecode where yearProcurementPlanYear=#{yearProcurementPlanYear} order by yearProcurementPlanId desc")
	List<YearProcurement> findType(Integer yearProcurementPlanYear);
}
