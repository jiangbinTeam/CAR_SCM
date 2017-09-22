package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;

import com.scm.pojo.TypeDictionary;

@Repository("typeDicMapper")
public interface TypeDicMapper {

	@Insert("insert into scm_typeDictionary(typecode,Brand,Carcharacter) "
			+ "values(#{typeCode,jdbcType=VARCHAR},#{brand,jdbcType=VARCHAR},#{carCharacter,jdbcType=VARCHAR})")
	int add(TypeDictionary scmTypeDictionary);// 增加车系

	@Update("update scm_typeDictionary set brand=#{brand,jdbcType=VARCHAR},carCharacter=#{carCharacter,jdbcType=VARCHAR}"
			+ " where typecode=#{typeCode,jdbcType=VARCHAR}")
	int update(TypeDictionary scmTypeDictionary);// 修改车系信息

	@Select("select typecode,Brand,Carcharacter from scm_typeDictionary where typecode=#{typeCode,jdbcType=VARCHAR}")
	TypeDictionary findByTypecode(String typeCode);// 使用车型编码来查询车型信息

	@Select("select typecode,Brand,Carcharacter from scm_typeDictionary")
	List<TypeDictionary> list();// 查询所有的车型信息

	@Select("select * from  (select rownum nb,e.* from  scm_typeDictionary e) t "
			+ " where t.nb>=#{pageMin} and t.nb<=#{pageMax}") // 分页
	List<TypeDictionary> findByPageTdy(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	@Select("select count(typeCode) from  scm_typeDictionary")
	int countTypeDictionary();// 查询记录条数
}
