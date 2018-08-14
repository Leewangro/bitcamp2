package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tlno;
    private int partner;
    private int preference;
    private String title;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    public int getTlno() {
        return tlno;
    }
    public void setTlno(int tlno) {
        this.tlno = tlno;
    }
    public int getPartner() {
        return partner;
    }
    public void setPartner(int partner) {
        this.partner = partner;
    }
    public int getPreference() {
        return preference;
    }
    public void setPreference(int preference) {
        this.preference = preference;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
    @Override
    public String toString() {
        return "TravelLog [tlno=" + tlno + ", partner=" + partner + ", preference=" + preference + ", title=" + title
                + ", createDate=" + createDate + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    
    
    
}