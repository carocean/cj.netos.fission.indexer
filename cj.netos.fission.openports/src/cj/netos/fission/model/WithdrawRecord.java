package cj.netos.fission.model;

/**
 * Table: withdraw_record
 */
public class WithdrawRecord {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: withdrawer
     * Remark: 退款人
     */
    private String withdrawer;

    /**
     * Column: nick_name
     * Remark: 充值时退款者的昵称
     */
    private String nickName;

    /**
     * Column: currency
     * Remark: 币种
     */
    private String currency;

    /**
     * Column: amount
     */
    private Long amount;

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

    public String getWithdrawer() {
        return withdrawer;
    }

    public void setWithdrawer(String withdrawer) {
        this.withdrawer = withdrawer == null ? null : withdrawer.trim();
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