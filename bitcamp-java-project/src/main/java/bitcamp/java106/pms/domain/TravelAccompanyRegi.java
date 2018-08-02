package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelAccompanyRegi implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cno;
    private String mTitle;
    private String pDesc;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date sDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eDate;
    
    private String mTem;
    private String mWithNum;
    private int gen;
    private String cDesc;
    private String tokenVal;
    @Override
    public String toString() {
        return "TravelAccompanyRegi [cno=" + cno + ", mTitle=" + mTitle + ", pDesc=" + pDesc + ", sDate=" + sDate
                + ", eDate=" + eDate + ", mTem=" + mTem + ", mWithNum=" + mWithNum + ", gen=" + gen + ", cDesc=" + cDesc
                + ", tokenVal=" + tokenVal + "]";
    }
    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno = cno;
    }
    public String getmTitle() {
        return mTitle;
    }
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public String getpDesc() {
        return pDesc;
    }
    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }
    public Date getsDate() {
        return sDate;
    }
    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }
    public Date geteDate() {
        return eDate;
    }
    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }
    public String getmTem() {
        return mTem;
    }
    public void setmTem(String mTem) {
        this.mTem = mTem;
    }
    public String getmWithNum() {
        return mWithNum;
    }
    public void setmWithNum(String mWithNum) {
        this.mWithNum = mWithNum;
    }
    public int getGen() {
        return gen;
    }
    public void setGen(int gen) {
        this.gen = gen;
    }
    public String getcDesc() {
        return cDesc;
    }
    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }
    public String getTokenVal() {
        return tokenVal;
    }
    public void setTokenVal(String tokenVal) {
        this.tokenVal = tokenVal;
    }
    
    
    
}