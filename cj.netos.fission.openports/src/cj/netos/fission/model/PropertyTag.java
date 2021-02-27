package cj.netos.fission.model;

/**
 * Table: property_tag
 */
public class PropertyTag {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: tag
     */
    private String tag;

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