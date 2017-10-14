package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Warehouse;

@Repository("carInManagerManager")
public interface CarInManagerMapper {
 

		//入库添加查询
		@Select("select warehouseId,warehouseName,storageAreasName,vinNumber,storageAreasId,storageAreasName from Dictionarymanageg  ")
		List<Warehouse> findByidruku();
		//车辆入库
		@Update("update scm_storageAreas set vinNumber=#{vinNumber,jdbcType=VARCHAR} where storageAreasId=#{storageAreasId}")
		int modifa(Warehouse who);
		
		
		//分页查询
		List<Warehouse> pageList(
				@Param("pageMin")Integer pageMin,
				@Param("pageMax")Integer pageMax,
				@Param("warehouseId")Integer warehouseId);
		
		//计算符合条件的总记录数
		int totalcount(
				@Param("warehouseId")Integer warehouseId
				);
		
		@Select("select distinct warehouseName,warehouseId from Dictionarymanagegc")
		List<Warehouse> listid();//获取仓库名
		
		
		

}
