package cj.netos.fission.mapper;

import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.PayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<PayRecord> selectByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    PayRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(PayRecord record);
}