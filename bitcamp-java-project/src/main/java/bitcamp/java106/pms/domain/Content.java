package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Content implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private String id;
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Seoul")
    private Date createDate;


	@Override
    public String toString() {
        return "Content [no=" + no + ", title=" + title + ", id=" + id + ", createDate=" + createDate + "]";
    }
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
    

    
    
}