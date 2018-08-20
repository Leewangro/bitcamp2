package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class HashTag implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cno;
    private String content;
    private int hno;
    private int tourno;
    private String photo;
    private String title;
    


    @Override
    public String toString() {
        return "HashTag [cno=" + cno + ", content=" + content + ", hno=" + hno + ", tourno=" + tourno + ", photo="
                + photo + ", title=" + title + "]";
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTourno() {
        return tourno;
    }

    public void setTourno(int tourno) {
        this.tourno = tourno;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno = cno;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    
    
    
}