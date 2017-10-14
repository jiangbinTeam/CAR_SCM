package com.scm.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.ColorChange;
import com.scm.pojo.Dealer;
import com.scm.pojo.DealerOrder;
import com.scm.pojo.DealerOrderDetails;
import com.scm.pojo.DealerOrderDetails2;
import com.scm.pojo.TypeDictionary;

@Repository("DealerOrderMapper")
public interface DealerOrderMapper {
	// 多条件查询订单
	List<DealerOrder> list(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			@Param("dealerId") Integer dealerId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
			@Param("orderNumber") String orderNumber);

	// 查询所有订单
	List<DealerOrder> listAllDealerOrder(@Param("dealerId") Integer dealerId, @Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("orderNumber") String orderNumber);

	// 统计订单记录总数
	int total(@Param("dealerId") Integer dealerId, @Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("orderNumber") String orderNumber);

	// 统计订单量
	int countDealerOrder(@Param("dealerId") Integer dealerId, @Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate, @Param("orderNumber") String orderNumber);

	@Select("select count(dealerOrderDetailsId) from scm_dealerOrderDetails" + " where dealerOrderId=#{dealerOrderId}")
	// 按订单ID统计订单明细
	int countDetails(Integer dealerOrderId);

	// 按订单ID查找订单
	DealerOrder findById(Integer dealerOrderId);

	// 添加数据到订单明细表
	@Insert("insert into scm_dealerOrderDetails values(#{dealerOrderDetailsId}," + "#{dealerOrderId},#{colorCode},"
			+ "#{typeCode},#{addAccessorizeNote}," + "#{ifCreateStartAccounting})")

	int addDetails(DealerOrderDetails dod);

	// 右链接查询订单明细所需数据
	@Select("select * from( select distinct st.DEALERORDERDETAILSID, rownum rnn,st.TYPECODE,st.BRAND,st.CARCHARACTER,st.DEALERORDERID,"
			+ " st.ADDACCESSORIZENOTE,st.IFCREATESTARTACCOUNTING,qq.colorname" + " from scm_colorChange qq right join "
			+ " (select g.typecode,brand,carcharacter, dealerOrderDetailsId,"
			+ " DEALERORDERID,COLORCODE,ADDACCESSORIZENOTE,IFCREATESTARTACCOUNTING"
			+ " from scm_typeDictionary g right join "
			+ " (select d.* from  scm_dealerOrder e  right join scm_dealerOrderDetails d on e.dealerorderid=d.dealerorderid"
			+ " where d.dealerorderid=#{dealerorderid}) tn"
			+ " on tn.typecode=g.typecode) st on st.COLORCODE =qq.COLORCODE where  rownum <=#{pageMax} ) where rnn>=#{pageMin} ")
	List<DealerOrderDetails2> findByDetails(@Param("dealerorderid") Integer dealerorderid,
			@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	// 添加数据到订单表
	@Insert("insert into scm_dealerOrder values"
			+ "(#{dealerOrderId},#{dealerId},concat('qe',Logistics.Nextval),#{certificateDate})")
	int addDealerOrder(DealerOrder dealoOrder);

	// 查所有经销商
	@Select("select * from scm_dealer ")
	List<Dealer> dealers();

	// 查所有车型
	@Select("select * from scm_typeDictionary ")
	List<TypeDictionary> typeDictionaries();

	// 查所有颜色
	@Select("select * from scm_colorChange")
	List<ColorChange> colorChanges();

	// 查询Vin号
	@Select("select vinNumber from VIN t where  " + "outOfStorage=1 and procedureComplete=1 "
			+ " and ifsell=1 and t.typeCode " + " in (select typecode from scm_dealerOrderDetails  "
			+ "where DEALERORDERID = #{dealerOrderId,jdbcType=INTEGER} ) ")
	List<String> vinn(Integer dealerOrderId);

	@Select("select dealerOrder.Currval from dual")
	// 查询订单表的当前订单Id
	int dealerOrderId();

	// 添加发车台账数据到Vin表
	@Update("update VIN set sellPrice=#{sellPrice,jdbcType=DOUBLE},"
			+ " ifRetrofitting=#{ifRetrofitting,jdbcType=INTEGER},"
			+ " addAccessorizeNote=#{addAccessorizeNote,jdbcType=VARCHAR} where"
			+ " vinNumber=#{vinNumber,jdbcType=VARCHAR}")
	int addAccounting(@Param("sellPrice") Double sellPrice, @Param("ifRetrofitting") Integer ifRetrofitting,
			@Param("addAccessorizeNote") String addAccessorizeNote, @Param("vinNumber") String vinNumber);

	// 添加数据到发车台账表
	@Insert("insert into scm_startAccounting (startAccountingId,vinNumber,"
			+ "dealerOrderId,startAccountingStates) values " + "(110,#{vinNumber},#{dealerOrderId}, 0) ")
	int addStartAccounting1(@Param("vinNumber") String vinNumber, @Param("dealerOrderId") Integer dealerOrderId);

	// 修改订单明细表状态
	@Update("update scm_dealerOrderDetails set "
			+ "ifCreateStartAccounting=1 where dealerOrderDetailsId=#{dealerOrderDetailsId}")
	int update(Integer dealerOrderDetailsId);
}
