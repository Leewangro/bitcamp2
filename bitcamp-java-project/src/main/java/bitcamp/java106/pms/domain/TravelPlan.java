package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelPlan implements Serializable {
    private static final long serialVersionUID = 1L;

    private int plno; // 플랜번호
    private int tno; // 여행지번호
    private String memo; // 일행
    private List<Travel> travels;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date pltime;
    
    
    

    @Override
    public String toString() {
        return "TravelPlan [plno=" + plno + ", tno=" + tno + ", memo=" + memo + ", travels=" + travels + ", pltime="
                + pltime + "]";
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

    public List<Travel> getTravels() {
        return travels;
    }

    public void setTravels(List<Travel> travels) {
        this.travels = travels;
    }

    public Date getPltime() {
        return pltime;
    }

    public void setPltime(Date pltime) {
        this.pltime = pltime;
    }
    
    

    
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경






