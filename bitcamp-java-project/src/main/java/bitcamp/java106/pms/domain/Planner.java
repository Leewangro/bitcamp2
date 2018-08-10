package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Planner implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no; // 번호
    private int num; // 인원
    private String people; // 일행
    private String theme; // 테마
    private String title;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate; // 시작일
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;   // 종료일

    


    @Override
    public String toString() {
        return "Planner [no=" + no + ", num=" + num + ", people=" + people + ", theme=" + theme + ", title=" + title
                + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public int getNo() {
        return no;
    }


    public void setNo(int no) {
        this.no = no;
    }


    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }


    public String getPeople() {
        return people;
    }


    public void setPeople(String people) {
        this.people = people;
    }


    public String getTheme() {
        return theme;
    }


    public void setTheme(String theme) {
        this.theme = theme;
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

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경






