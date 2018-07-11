package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Board_bak implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private String content;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdDate;
    
    // ê°œë°œ?•˜?Š” ?™?•ˆ ê°ì²´?˜ ?‚´?š©?„ ?™•?¸?•˜ê¸? ?œ„?•´?„œ toString()?„ ?˜¤ë²„ë¼?´?”© ?•œ?‹¤.
    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate + "]";
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
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
}

//ver 31 - ?ƒ?„±? ? œê±? ë°? count ë³??ˆ˜ ? œê±?
//ver 27 - java.io.Serializable ?¸?„°?˜?´?Š¤ êµ¬í˜„
//ver 24 - setNo() ë³?ê²?
//ver 18 - ê²Œì‹œë¬? ê°ì²´?˜ ê³ ìœ  ë²ˆí˜¸(no)ë¥? static ë³??ˆ˜(count)ë¥? ?´?š©?•˜?—¬ ??™ ?„¤? •?•œ?‹¤. 
// ver 16 - ìº¡ìŠ?™” ? ?š©. ê²Ÿí„°, ?…‹?„° ì¶”ê?.
// ver 13 - ?“±ë¡ì¼?˜ ?°?´?„° ???…?„ String?—?„œ Date?œ¼ë¡? ë³?ê²?






