package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class Travel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tno; // 플랜번호
    private String desc; // 내용
    private String addr; // 주소
    private String tel; // 전화번호
    private String weat; // 날씨
    private int type; // 유형
    private String guide; // 이용안내
    private String review; // 내부리뷰
    private String latd; // 위도
    private String lotd; // 경도
    
    @Override
    public String toString() {
        return "Travel [tno=" + tno + ", desc=" + desc + ", addr=" + addr + ", tel=" + tel + ", weat=" + weat
                + ", type=" + type + ", guide=" + guide + ", review=" + review + ", latd=" + latd + ", lotd=" + lotd
                + "]";
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeat() {
        return weat;
    }

    public void setWeat(String weat) {
        this.weat = weat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getLatd() {
        return latd;
    }

    public void setLatd(String latd) {
        this.latd = latd;
    }

    public String getLotd() {
        return lotd;
    }

    public void setLotd(String lotd) {
        this.lotd = lotd;
    }
    
    
    


    
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경







