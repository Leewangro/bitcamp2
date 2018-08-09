package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tlno;
    private int memberNo;
    private int partner;
    private int preference;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    @Override
    public String toString() {
        return "TravelLog [tlno=" + tlno + ", memberNo=" + memberNo + ", partner=" + partner + ", preference="
                + preference + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    public int getTlno() {
        return tlno;
    }
    public void setTlno(int tlno) {
        this.tlno = tlno;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
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