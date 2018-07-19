package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelAccompany implements Serializable {
    private static final long serialVersionUID = 1L;

    private String authorComment;
    private String boardNum;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    private Date endDate;
    
    
    
    @Override
    public String toString() {
        return "TravelAccompany [authorComment=" + authorComment + ", boardNum=" + boardNum + ", startDate=" + startDate
                + ", endDate=" + endDate + "]";
    }
    public String getAuthorComment() {
        return authorComment;
    }
    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment;
    }
    public String getBoardNum() {
        return boardNum;
    }
    public void setBoardNum(String boardNum) {
        this.boardNum = boardNum;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
    
   
   


}