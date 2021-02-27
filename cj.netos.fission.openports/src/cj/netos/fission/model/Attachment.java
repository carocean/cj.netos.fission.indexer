package cj.netos.fission.model;

/**
 * Table: attachment
 */
public class Attachment {
    /**
     * Column: id
     */
    private String person;

    /**
     * Column: src
     */
    private String src;

    /**
     * Column: type
     * Remark: image图片 video视频 qrcode二维码
     */
    private String type;
    private String note;
    /**
     * Column: ctime
     */
    private String ctime;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}