package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.StartAccounting2;

@Repository("StartAccountingMapper")
public interface StartAccountingMapper {
	//按条件查询发车台账管理数据
 List<StartAccounting2> findSatcc(
		 @Param("dealerOrderId") Integer dealerOrderId,
		 @Param("vinNumber") String vinNumber,
		 @Param("startAccountingStates") Integer startAccountingStates,
		 @Param("pageMin") Integer pageMin, 
		 @Param("pageMax") Integer pageMax );
//按条件统计发车台账记录 
 int countSatcc( 
		 @Param("dealerOrderId") Integer dealerOrderId,
		 @Param("vinNumber") String vinNumber,
		 @Param("startAccountingStates") Integer startAccountingStates);
 
 //修改发车台账数据在Vin表中
 @Update("update VIN set sellPrice=#{sellPrice,jdbcType=DOUBLE},"
 		+ " ifRetrofitting=#{ifRetrofitting,jdbcType=INTEGER},"
 		+ " addAccessorizeNote=#{addAccessorizeNote,jdbcType=VARCHAR},"
 		+ "vinNumber=#{vinNumber2,jdbcType=VARCHAR} where "
 		+ "vinNumber=#{vinNumber,jdbcType=VARCHAR}")
 int  updateAccounting(@Param("sellPrice")Double sellPrice,
		 @Param("ifRetrofitting")Integer ifRetrofitting,
		 @Param("addAccessorizeNote") String addAccessorizeNote,
		 @Param("vinNumber2")String vinNumber2,
		 @Param("vinNumber")String vinNumber);
 
//按车型及其它条件查已生产发车台账的 VIN
 @Select("select vinNumber from VIN where typeCode=#{typeCode} and outOfStorage=1 and procedureComplete=1 "
 		+ " and ifsell=1 and issell is null")
 List<String> findVins(String typeCode);
 //修改 VIN表中Vin 号
 @Update("update VIN  set vinNumber=#{vinNumber3} where VinNumber=#{vinNumber4} ")
 int updateVin (@Param("vinNumber3") String vinNumber3,
		          @Param("vinNumber4") String vinNumber4
		        );
 //修改有误台账 Vin表中信息
 @Update("update VIN set sellPrice=#{sellPrice},ifRetrofitting=#{ifRetrofitting}, "
 		+ "addAccessorizeNote=#{addAccessorizeNote} where vinNumber=#{vinNumberx} ")
 int updateVinX(@Param("sellPrice") Double sellPrice,
		        @Param("ifRetrofitting") Integer ifRetrofitting,
		        @Param("addAccessorizeNote") String addAccessorizeNote,
		        @Param("vinNumberx") String vinNumberx); 
 
 
 //清除填错的Vin 号的相关信息
 @Update("update VIN set sellPrice=null,ifRetrofitting=null,addAccessorizeNote=null "
 		+ "where vinNumber=#{vinNumber5}")
 int updateVin2( String vinNumber5);
 //修改台账管理中Vin号
 @Update("update scm_startAccounting set vinNumber=#{vinNumber6} where vinNumber=#{vinNumber7} ")
 int updateSat(@Param("vinNumber6") String vinNumber6,
         @Param("vinNumber7") String vinNumber7);
 
//修改台账管理中Vin号发车状态
 @Update("update scm_startAccounting set vinNumber=#{vinNumber6}, "
 		+ "startAccountingStates=0 where vinNumber=#{vinNumber7} ")
 int  updateStat3(@Param("vinNumber6") String vinNumber9,
         @Param("vinNumber7") String vinNumber10);

 //查看某Vin号在已生成的台账中是否存在
 @Select("select count(vinNumber) FROM scm_startAccounting WHERE vinNumber=#{vinNumber8}")
 int seeVin(String vinNumber8);
}
