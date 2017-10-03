package com.scm.dao;

import java.util.List;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Warehouse;

@Repository("warehouseMapper")
public interface WarehouseMapper {



    //库位分页 
	@Select("select * from (select rownum rn,d.* from warehousekuweiidc d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax}")
	List<Warehouse> listByPagek(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	//库位查单个集合
	@Select("select warehouseId,warehouseName,storageAreasName,vinNumber,storageAreasId from warehousekuweiidc where warehouseId=#{warehouseId}")
	List<Warehouse> findByidk(Integer warehouseId);
	
	//库位添加查所有
	@Select("select warehouseId,warehouseName,storageAreasName,vinNumber from warehousekuweiidc" )
	List<Warehouse> findAll();
	
	//库位查单个
	@Select("select warehouseId,warehouseName,storageAreasName,vinNumber,storageAreasId from warehousekuweiidc "
			+ " where storageAreasId=#{storageAreasId}")
	Warehouse findByidkk(Integer storageAreasId);
	 
	
	//修改库位
	@Update("update scm_storageAreas set storageAreasName=#{storageAreasName,jdbcType=VARCHAR} "
			+ " where storageAreasId=#{storageAreasId}")
    int modifa1(Warehouse warc);
	
	//添加库位
	@Insert("insert into scm_storageAreas(storageAreasId,warehouseId,storageAreasName)values"
			+ " (#{storageAreasId},#{warehouseId,jdbcType=INTEGER},#{storageAreasName,jdbcType=VARCHAR}) ")
	@SelectKey(keyProperty = "storageAreasId", statement = "select storageAreas.nextval from dual", before = true, resultType = int.class)
	int addku(Warehouse warc);
	
	//分页查询 
	List<Warehouse> pageList(
			@Param("pageMin")Integer pageMin,
			@Param("pageMax")Integer pageMax,
			@Param("warehouseId")Integer warehouseId);
	
	//计算符合条件的总记录数
	int totalcount(
			@Param("warehouseId")Integer warehouseId
			);
	
	@Select("select distinct warehouseName,warehouseId from scm_warehouse")
	List<Warehouse> listid();//获取仓库名 
	
	
	
	
	
	
	
	
	//添加仓库
	@Insert("insert into scm_warehouse(warehouseId,warehouseName,warehouseAddress) values  "
			+ "(#{warehouseId}, #{warehouseName,jdbcType=VARCHAR},#{warehouseAddress,jdbcType=VARCHAR})")
	@SelectKey(keyProperty = "warehouseId", statement = "select warehouse.nextval from dual", before = true, resultType = int.class)
	int add(Warehouse warh);
	
	//修改仓库
	@Update("update scm_warehouse set warehouseName=#{warehouseName,jdbcType=VARCHAR},warehouseAddress=#{warehouseAddress,jdbcType=VARCHAR} "
			+ " where warehouseId=#{warehouseId} ")
	int modifa(Warehouse warh);
	//查单个
	@Select("select warehouseId,warehouseName,warehouseAddress from scm_warehouse where warehouseId=#{warehouseId}")
	Warehouse findByid(Integer warehouseId);

    //总记录条数
	@Select("select count(warehouseId) from warehouseofff")
	int total();
	

    //分页
	@Select("select warehouseId,warehouseName,warehouseAddress,vinnumbercount  from (select rownum rn,d.* from warehouseofff d)sd where sd.rn>=#{pageMin} and sd.rn<=#{pageMax} ")
	List<Warehouse> listByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

}
