package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class HashTag implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cno;
    private String content;
    private int hno;
    
    
    @Override
    public String toString() {
        return "HashTag [cno=" + cno + ", content=" + content + ", hno=" + hno + "]";
    }
    
    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno = cno;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    
    
    
}