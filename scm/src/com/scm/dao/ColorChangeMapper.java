package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.ColorChange;

@Repository("colorChangeMapper")
public interface ColorChangeMapper {
	
	@Insert("insert into Scm_ColorChange(colorcode,colorname,typecode) "
			+ "values(#{colorCode,jdbcType=VARCHAR},#{colorName,jdbcType=VARCHAR},#{typeDictionary.typeCode,jdbcType=VARCHAR})")
	int add(ColorChange colorChange);
	
	@Update("update Scm_ColorChange set colorName=#{colorName,jdbcType=VARCHAR},typeCode=#{typeDictionary.typeCode,jdbcType=VARCHAR}"
			+ "where colorCode=#{colorCode,jdbcType=VARCHAR}")
	int update(ColorChange colorChange);
	
	List<ColorChange> list();
	
	ColorChange findByColorCode(String colorCode);
}
