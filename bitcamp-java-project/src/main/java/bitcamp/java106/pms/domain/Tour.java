package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private String content;
    private Date createdtime;
    
    // 개발하는 동안 객체의 내용을 확인하기 위해서 toString()을 오버라이딩 한다.
    @Override
    public String toString() {
        return "Tour [no=" + no + ", title=" + title + ", content=" + content + ", createdDate=" + createdtime + "]";
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return createdtime;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdtime = createdDate;
    }
    
    
}






