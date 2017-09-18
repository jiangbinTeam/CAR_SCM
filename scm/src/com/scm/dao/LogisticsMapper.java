package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Logistics;

@Repository("logisticsMapper")
public interface LogisticsMapper {

	@Insert("insert into scm_Logistics(logisticsId,logisticsName,logisticsTel,logisticsContact,logisticsContactTel)"
			+ "values(#{logisticsId},#{logisticsName,jdbcType=VARCHAR},#{logisticsTel,jdbcType=VARCHAR},"
			+ "#{logisticsContact,jdbcType=VARCHAR},#{logisticsContactTel,jdbcType=VARCHAR})")
	@SelectKey(keyProperty = "logisticsId", statement = "select Logistics.Nextval from dual", resultType = int.class, before = true)
	int add(Logistics scmLogistics);// 增加物流公司

	@Select("select logisticsId,logisticsName,logisticsTel,logisticsContact,logisticsContactTel from scm_Logistics")
	List<Logistics> findAll();// 查询所有的物流公司信息

	@Update("update scm_Logistics set logisticsName=#{logisticsName,jdbcType=VARCHAR},logisticsTel=#{logisticsTel,jdbcType=VARCHAR},"
			+ "logisticsContact=#{logisticsContact,jdbcType=VARCHAR},logisticsContactTel=#{logisticsContactTel,jdbcType=VARCHAR}"
			+ "where logisticsId=#{logisticsId}")
	int update(Logistics scmLogistics);// 修改物流公司信息

	@Select("select logisticsId,logisticsName,logisticsTel,logisticsContact,logisticsContactTel from scm_Logistics "
			+ "where logisticsId=#{logisticsId}")
	Logistics findById(Integer logisticsId);// 按id值查询物流公司信息

	@Select("select * from  (select rownum nb,e.* from  scm_Logistics e) t "
			+ "where t.nb>=#{pageMin} and t.nb<=#{pageMax}") // 分页
	List<Logistics> findByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	@Select("select count(logisticsId) from  scm_Logistics")
	int count();// 查询记录条数
}
