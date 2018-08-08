package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdDate;

    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", createdDate=" + createdDate + "]";
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    // 개발하는 동안 객체의 내용을 확인하기 위해서 toString()을 오버라이딩 한다.

    
}

