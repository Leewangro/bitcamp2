package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelPlan implements Serializable {
    private static final long serialVersionUID = 1L;

    private int plno; // 플랜번호
    private int tno; // 여행지번호
    private int ttype; // 여행지타입
    private String memo; // 메모
    private String pltime; // 플랜시간값
    private int ttpno; // 여행지 플랜 연동번호
    private int plday; // 여행 날짜 번호
    
    @Override
    public String toString() {
        return "TravelPlan [plno=" + plno + ", tno=" + tno + ", ttype=" + ttype + ", memo=" + memo + ", pltime="
                + pltime + ", ttpno=" + ttpno + ", plday=" + plday + "]";
    }
    
    public int getTtype() {
        return ttype;
    }

    public void setTtype(int ttype) {
        this.ttype = ttype;
    }

    public int getPlno() {
        return plno;
    }
    public void setPlno(int plno) {
        this.plno = plno;
    }
    public int getTno() {
        return tno;
    }
    public void setTno(int tno) {
        this.tno = tno;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getPltime() {
        return pltime;
    }
    public void setPltime(String pltime) {
        this.pltime = pltime;
    }
    public int getTtpno() {
        return ttpno;
    }
    public void setTtpno(int ttpno) {
        this.ttpno = ttpno;
    }
    public int getPlday() {
        return plday;
    }
    public void setPlday(int plday) {
        this.plday = plday;
    }

    
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경






