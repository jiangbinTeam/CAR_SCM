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
  

   //�ܼ�¼����
	@Select("select count(warehouseId) from Dictionarymanagegc")
	int total();
   //��ҳ 
	@Select("select * from (select rownum rn,d.* from Dictionarymanagegc d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax} ")
	List<Warehouse> listByPagek(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	//��������ģ����ѯ
	List <Warehouse> findBychuku(@Param("warehouseId")Integer warehouseId,
			                     @Param("typeCode")String typeCode,
			                     @Param("vinNumber")String vinNumber 
			                             );
	
	//������ȥ
	@Update("update scm_storageAreas set vinNumber=null where storageAreasId=#{storageAreasId}")
	int modifa(Integer storageAreasId);
	
	
	//��ҳ
		List<Warehouse> pageList(
				@Param("pageMin")Integer pageMin,
				@Param("pageMax")Integer pageMax,
				@Param("warehouseId")Integer warehouseId,
				@Param("typeCode")String typeCode,
				@Param("vinNumber")String vinNumber);
		
		//�ܼ�¼
		int totalcount(
				@Param("warehouseId")Integer warehouseId,
				@Param("typeCode")String typeCode,
				@Param("vinNumber")String vinNumber); 
		
		//�õ��ֿ�
		@Select("select distinct warehouseName,warehouseId from scm_warehouse")
		List<Warehouse> listid();
		
		//�õ�����
		@Select("select * from scm_typeDictionary")
		List<TypeDictionary> listtypeCode();
		
		//�õ�����
		@Select("select vinNumber from Dictionarymanagegc")
		List<Warehouse> listvinNumber();
		
	
}
