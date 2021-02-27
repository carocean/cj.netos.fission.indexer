package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: cashier
 */
public class Cashier {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: state
     * Remark: 0 正常营业 1 停止营业
     */
    private Integer state;

    /**
     * Column: type
     * Remark: 0 为手动 1 为按日自动
     */
    private Integer type;

    /**
     * Column: day_amount
     * Remark: 如果是按日自动充，此为每日限额,单位为分
     */
    private Long dayAmount;

    /**
     * Column: cac_average
     * Remark: 获客成本，获取一个用户的平均成本，单位为分
     */
    private Long cacAverage;

    /**
     * Column: amplitude_factor
     * Remark: 振幅因子，默认2.0 并不等同于振幅，用于调整每个红包的最大上限
     */
    private BigDecimal amplitudeFactor;

    /**
     * Column: closed_cause
     * Remark: 停业原因： 主人手停 余额不足1元自动停
     */
    private String closedCause;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Long dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Long getCacAverage() {
        return cacAverage;
    }

    public void setCacAverage(Long cacAverage) {
        this.cacAverage = cacAverage;
    }

    public BigDecimal getAmplitudeFactor() {
        return amplitudeFactor;
    }

    public void setAmplitudeFactor(BigDecimal amplitudeFactor) {
        this.amplitudeFactor = amplitudeFactor;
    }

    public String getClosedCause() {
        return closedCause;
    }

    public void setClosedCause(String closedCause) {
        this.closedCause = closedCause == null ? null : closedCause.trim();
    }
}