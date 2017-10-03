package com.scm.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Dealer;
import com.scm.pojo.Invoice;
import com.scm.pojo.Invoice2;
import com.scm.pojo.Invoice3;
import com.scm.pojo.Logistics;

@Repository("InvoiceMapper")
public interface InvoiceMapper {
	// 按条件查询发车管理数据
	List<Invoice2> findInvoice(@Param("dealerId") Integer dealerId, @Param("startDate") Date startDate,
			@Param("accessCarDate") Date accessCarDate, @Param("pageMin") Integer pageMin,
			@Param("pageMax") Integer pageMax);

	// 按条件统计发车管理数据记录
	int countIod(@Param("dealerId") Integer dealerId, @Param("startDate") Date startDate,
			@Param("accessCarDate") Date accessCarDate);

	// 查所有经销商
	@Select("select * from scm_dealer ")
	List<Dealer> dealers();

	// 确认发车添加日期到发车管理表
	@Update("update scm_invoice set startDate=#{startDate} where invoiceId=#{invoiceId}")
	int addStartDate(@Param("invoiceId") Integer invoiceId, @Param("startDate") Date startDate);

	// 确认接车添加日期到发车管理表
	@Update("update scm_invoice set accessCarDate=#{accessCarDate} where invoiceId=#{invoiceId} ")
	int addAccessCarDate(@Param("invoiceId") Integer invoiceId, @Param("accessCarDate") Date accessCarDate);

	// 添加运费经销商付运费表
	@Insert("insert into scm_paymentCarriageCharge values(1,#{invoiceId},#{carriageCharge},0)")
	int addYunFei(@Param("invoiceId") Integer invoiceId, @Param("carriageCharge") Double carriageCharge);

	// 按发货表ID查询发车管理表信息
	@Select("select rownum rnn,sgs.logisticsname,ts.* from  scm_logistics sgs right join "
			+ "(select sve.*,sle.dealername,sle.principalname from scm_invoice sve "
			+ " left join scm_dealer sle on sve.dealerid = sle.dealerid) ts  on ts.logisticsid =sgs.logisticsid"
			+ " where INVOICEID=#{invoiceId}")
	Invoice2 findInvoiceById(@Param("invoiceId") Integer invoiceId);

	// 修改发车台账中发车状态
	@Update("update scm_startAccounting set startAccountingStates=#{startAccountingStates} where "
			+ " invoiceId=#{invoiceId}")
	int updStartA(@Param("invoiceId") Integer invoiceId, @Param("startAccountingStates") Integer startAccountingStates);

	// 查看某发车单号下详情
	@Select("select * from(select rownum rnn,tyd.brand,tyd.carcharacter,dsv.* from "
			+ " scm_typeDictionary tyd right join (select  v.typeCode,ds.* from vin v  right join "
			+ " (select dea.ordernumber,sta.* from scm_startAccounting sta left join"
			+ " scm_dealerOrder dea on sta.dealerorderid=dea.dealerorderid   where sta.invoiceId=#{invoiceId}) ds "
			+ " on ds.vinnumber=v.vinnumber) dsv on dsv.typeCode=tyd.typecode "
			+ " where rownum<=#{pageMax}) where rnn>=#{pageMin}")

	List<Invoice3> findInvoice3s(@Param("invoiceId") Integer invoiceId, @Param("pageMin") Integer pageMin,
			@Param("pageMax") Integer pageMax);

	// 统计某发车单号下车辆数量
	@Select("select count(startAccountingId) from scm_startAccounting where invoiceId=#{invoiceId}")
	int countStadInv(Integer invoiceId);

	// 查询所有物流公司
	@Select("select * from scm_logistics")
	List<Logistics> findLogs();

	// 查询所有已出库可以生成发车单的汽车
	@Select("select * from ( select rownum rnn, typ.brand,typ.carcharacter,dtv.* from scm_typeDictionary typ  right join "
			+ " (select v.typecode,dst.* from VIN v right join "
			+ " (select dea.Ordernumber,sta.startAccountingId,sta.vinNumber,sta.startAccountingStates "
			+ " from scm_startAccounting sta left join "
			+ " scm_dealerOrder dea on sta.dealerorderid=dea.dealerorderid where "
			+ " sta.invoiceid is null and sta.STARTACCOUNTINGSTATES=0) dst on dst.vinnumber=v.vinnumber"
			+ " )dtv on dtv.typecode = typ.typecode where rownum<=#{pageMax}) where rnn >=#{pageMin}")
	List<Invoice3> findtdyvs(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	// 统计所有已出库可以生成发车单的汽车的数量
	@Select("select count(startAccountingId) from scm_startAccounting where invoiceId is null and STARTACCOUNTINGSTATES=0")
	int countCinv();

	// 按ID修改发车单所需数据
	@Select(" select * from (select rownum rnn, typ.brand,typ.carcharacter,dtv.* from scm_typeDictionary typ  right join "
			+ " (select v.typecode,dst.* from VIN v right join "
			+ " (select dea.Ordernumber,sta.startAccountingId,sta.vinNumber,sta.startAccountingStates from "
			+ " scm_startAccounting staleft join scm_dealerOrder dea on sta.dealerorderid=dea.dealerorderid "
			+ " sta.invoiceid=#{invoiceId}) dst on dst.vinnumber=v.vinnumber"
			+ " )dtv on dtv.typecode = typ.typecode where rownum<=#{pageMax}) where rnn>=#{pageMin} ")
	List<Invoice3> findtdyvs2(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			@Param("invoiceId") Integer invoiceId);

	// 按ID统计修改发车单数据量
	@Select("select count(startAccountingId) from scm_startAccounting where invoiceId =#{invoiceId}")
	int countUinv(Integer invoiceId);

	// 修改发车单数据
	@Update("update scm_invoice set logisticsId=#{logisticsId,jdbcType=INTEGER},dealerId=#{dealerId,jdbcType=INTEGER},"
			+ "carriageCharge=#{carriageCharge,jdbcType=DOUBLE},invoiceNumber=#{invoiceNumber,jdbcType=VARCHAR} where invoiceId=#{invoiceId,jdbcType=INTEGER}")
	int xgInv(@Param("logisticsId") Integer logisticsId, @Param("dealerId") Integer dealerId,
			@Param("carriageCharge") Double carriageCharge, @Param("invoiceNumber") String invoiceNumber,
			@Param("invoiceId") Integer invoiceId);

	// 创建发车单
	@Insert("Insert into scm_invoice" + "(invoiceId,logisticsId,dealerId,carriageCharge,invoiceNumber)values"
			+ "(1,#{logisticsId},#{dealerId},#{carriageCharge},#{invoiceNumber})")
	int createInv(@Param("logisticsId") Integer logisticsId, @Param("dealerId") Integer dealerId,
			@Param("carriageCharge") Double carriageCharge, @Param("invoiceNumber") String invoiceNumber);

	// 拿到创建发车单时发车单ID
	@Select("select invoice.currval from dual")
	int findInvoiceId();

	// 创建发车单时在发车台账中添加发车单ID
	@Update("update scm_startAccounting set invoiceId=#{invoiceId} where startAccountingId=#{startAccountingId}")
	int upstata(@Param("invoiceId") Integer invoiceId, @Param("startAccountingId") Integer startAccountingId);

	@Select("select * from scm_invoice where invoiceId =#{invoiceId}")
	Invoice findById(Integer invoiceId);

}
