package cj.netos.fission.mapper;

import cj.netos.fission.model.Cashier;
import cj.netos.fission.model.CashierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashierMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Cashier> selectByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Cashier selectByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Cashier record, @Param("example") CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Cashier record, @Param("example") CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Cashier record);
}