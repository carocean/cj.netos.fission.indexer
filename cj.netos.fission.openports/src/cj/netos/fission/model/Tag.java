package cj.netos.fission.model;

/**
 * Table: tag
 */
public class Tag {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: name
     */
    private String name;

    /**
     * Column: opposite
     * Remark: 相反的标签，此处为相反标签的标识 如：男对女(femail)，女对男(male)
     */
    private String opposite;
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOpposite() {
        return opposite;
    }

    public void setOpposite(String opposite) {
        this.opposite = opposite == null ? null : opposite.trim();
    }
}