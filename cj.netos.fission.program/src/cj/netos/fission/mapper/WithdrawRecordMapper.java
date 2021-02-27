package cj.netos.fission.mapper;

import cj.netos.fission.model.WithdrawRecord;
import cj.netos.fission.model.WithdrawRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WithdrawRecord> selectByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WithdrawRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WithdrawRecord record);
}