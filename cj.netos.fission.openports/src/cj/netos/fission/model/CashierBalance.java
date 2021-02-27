package cj.netos.fission.model;

/**
 * Table: cashier_balance
 */
public class CashierBalance {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: balance
     * Remark: 余额
     */
    private Long balance;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}