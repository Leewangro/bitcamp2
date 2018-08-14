package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ptno; //동행게시판번호
    private String title; // 제목
    private String gender; // 성별
    private String capa; // 인원
    private String memberno; // 회원번호
    @Override
    public String toString() {
        return "Partner [ptno=" + ptno + ", title=" + title + ", gender=" + gender + ", capa=" + capa + ", memberno="
                + memberno + "]";
    }
    public int getPtno() {
        return ptno;
    }
    public void setPtno(int ptno) {
        this.ptno = ptno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCapa() {
        return capa;
    }
    public void setCapa(String capa) {
        this.capa = capa;
    }
    public String getMemberno() {
        return memberno;
    }
    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }
   
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경






