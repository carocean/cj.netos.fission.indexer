package cj.netos.fission.model;

import java.util.List;

public class PersonInfo {
    Person person;
    long balance;
    double distance;
    Cashier cashier;
    List<Tag> propTags;
    List<Tag> payerTags;
    List<Tag> payeeTags;
    Area payerArea;
    Area payeeArea;

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Tag> getPropTags() {
        return propTags;
    }

    public void setPropTags(List<Tag> propTags) {
        this.propTags = propTags;
    }

    public List<Tag> getPayerTags() {
        return payerTags;
    }

    public void setPayerTags(List<Tag> payerTags) {
        this.payerTags = payerTags;
    }

    public List<Tag> getPayeeTags() {
        return payeeTags;
    }

    public void setPayeeTags(List<Tag> payeeTags) {
        this.payeeTags = payeeTags;
    }

    public Area getPayerArea() {
        return payerArea;
    }

    public void setPayerArea(Area payerArea) {
        this.payerArea = payerArea;
    }

    public Area getPayeeArea() {
        return payeeArea;
    }

    public void setPayeeArea(Area payeeArea) {
        this.payeeArea = payeeArea;
    }
}
