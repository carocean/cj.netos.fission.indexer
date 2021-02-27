package cj.netos.fission.model;

/**
 * Table: property_tag
 */
public class LimitTag {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: tag
     */
    private String tag;
    private String direct;

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}