package cj.netos.fission.mapper;

import cj.netos.fission.model.CashierBill;
import cj.netos.fission.model.CashierBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashierBillMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CashierBill> selectByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    CashierBill selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") CashierBill record, @Param("example") CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") CashierBill record, @Param("example") CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(CashierBill record);
}