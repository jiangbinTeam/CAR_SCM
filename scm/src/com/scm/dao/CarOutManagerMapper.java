package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.TypeDictionary;
import com.scm.pojo.Warehouse;

@Repository("carOutManager")
public interface CarOutManagerMapper {
  

   //总记录条数
	@Select("select count(warehouseId) from Dictionarymanagegc")
	int total();
   //分页 
	@Select("select * from (select rownum rn,d.* from Dictionarymanagegc d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax} ")
	List<Warehouse> listByPagek(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	//汽车出库模糊查询
	List <Warehouse> findBychuku(@Param("warehouseId")Integer warehouseId,
			                     @Param("typeCode")String typeCode,
			                     @Param("vinNumber")String vinNumber 
			                             );
	
	//汽车出去
	@Update("update scm_storageAreas set vinNumber=null where storageAreasId=#{storageAreasId}")
	int modifa(Integer storageAreasId);
	
	
	//分页
		List<Warehouse> pageList(
				@Param("pageMin")Integer pageMin,
				@Param("pageMax")Integer pageMax,
				@Param("warehouseId")Integer warehouseId,
				@Param("typeCode")String typeCode,
				@Param("vinNumber")String vinNumber);
		
		//总记录
		int totalcount(
				@Param("warehouseId")Integer warehouseId,
				@Param("typeCode")String typeCode,
				@Param("vinNumber")String vinNumber); 
		
		//拿到仓库
		@Select("select distinct warehouseName,warehouseId from scm_warehouse")
		List<Warehouse> listid();
		
		//拿到车型
		@Select("select * from scm_typeDictionary")
		List<TypeDictionary> listtypeCode();
		
		//拿到车型
		@Select("select vinNumber from Dictionarymanagegc")
		List<Warehouse> listvinNumber();
		
	
}
