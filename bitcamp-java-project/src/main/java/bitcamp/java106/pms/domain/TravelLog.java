package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tlno;
    private String member;
    private String partner;
    private String preference;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    
    @Override
    public String toString() {
        return "TravelLog [tlno=" + tlno + ", member=" + member + ", partner=" + partner + ", preference=" + preference
                + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    public int getNo() {
        return tlno;
    }
    public void setNo(int tlno) {
        this.tlno = tlno;
    }
    public String getMember() {
        return member;
    }
    public void setMember(String member) {
        this.member = member;
    }
    public String getPartner() {
        return partner;
    }
    public void setPartner(String partner) {
        this.partner = partner;
    }
    public String getPreference() {
        return preference;
    }
    public void setPreference(String preference) {
        this.preference = preference;
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