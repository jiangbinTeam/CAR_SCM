package com.scm.dao;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Warehouse;

@Repository("warehouseMapper")
public interface WarehouseMapper {
	
	@Insert("insert into Warehouse(warehouseId,warehouseName,warehouseAddress) values(#{warehouseId}, "
			+ " #{warehouseName,jdbcType=VARCHAR},#{warehouseAddress,jdbcType=VARCHAR})")
	@SelectKey(keyProperty = "warehouseId", statement = "select warehouse.nextval from dual", before = true, resultType = int.class)
	int add(Warehouse warh);
	
	
	List<Warehouse> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order, @Param("warehouseName") String warehouseName);

	int findPagerTotal(@Param("warehouseName") String warehouseName);

	@Select("select count(DEALERID) from scm_warehouse")
	int total();

	@Select("select * from (select rownum rn,d.* from scm_warehouse d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax}")
	List<Warehouse> listByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

}
