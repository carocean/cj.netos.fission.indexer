package cj.netos.fission.model;

/**
 * Table: recharge_record
 */
public class RechargeRecord {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: recharger
     * Remark: 交个朋友中的person
     */
    private String recharger;

    /**
     * Column: nick_name
     * Remark: 充值时充值者的昵称
     */
    private String nickName;

    /**
     * Column: currency
     * Remark: 币种
     */
    private String currency;

    /**
     * Column: amount
     * Remark: 金额
     */
    private Long amount;

    /**
     * Column: recharge_strategy
     * Remark: 付款采用的规则 - 0手动付款，表示这个钱是用户主动充的 - 1按日付款，表示这个钱是系统按日取的
     */
    private Integer rechargeStrategy;

    /**
     * Column: day_limit_amount
     * Remark: 如果支付采用的是日限规则，才有日限制金额
     */
    private Long dayLimitAmount;

    /**
     * Column: state
     * Remark: 0为创建 1为完成
     */
    private Integer state;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: ref_order_sn
     * Remark: 关联钱包的支付订单的商品单号
     */
    private String refOrderSn;

    /**
     * Column: ref_order_title
     * Remark: 商品订单的标题
     */
    private String refOrderTitle;

    /**
     * Column: ref_pay_sn
     * Remark: 关联支付单号
     */
    private String refPaySn;

    /**
     * Column: status
     * Remark: 处理状态
     */
    private Integer status;

    /**
     * Column: message
     * Remark: 处理消息
     */
    private String message;

    /**
     * Column: note
     */
    private String note;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getRecharger() {
        return recharger;
    }

    public void setRecharger(String recharger) {
        this.recharger = recharger == null ? null : recharger.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getRechargeStrategy() {
        return rechargeStrategy;
    }

    public void setRechargeStrategy(Integer rechargeStrategy) {
        this.rechargeStrategy = rechargeStrategy;
    }

    public Long getDayLimitAmount() {
        return dayLimitAmount;
    }

    public void setDayLimitAmount(Long dayLimitAmount) {
        this.dayLimitAmount = dayLimitAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getRefOrderSn() {
        return refOrderSn;
    }

    public void setRefOrderSn(String refOrderSn) {
        this.refOrderSn = refOrderSn == null ? null : refOrderSn.trim();
    }

    public String getRefOrderTitle() {
        return refOrderTitle;
    }

    public void setRefOrderTitle(String refOrderTitle) {
        this.refOrderTitle = refOrderTitle == null ? null : refOrderTitle.trim();
    }

    public String getRefPaySn() {
        return refPaySn;
    }

    public void setRefPaySn(String refPaySn) {
        this.refPaySn = refPaySn == null ? null : refPaySn.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}