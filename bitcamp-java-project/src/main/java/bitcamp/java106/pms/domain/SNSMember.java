package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class SNSMember implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String email;
    private String userName;
    private String profileImg;
    private String jender;
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SNSMember other = (SNSMember) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public String getId() {
        return id;
    }
    public SNSMember setId(String id) {
        this.id = id;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public SNSMember setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getUserName() {
        return userName;
    }
    public SNSMember setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    public String getProfileImg() {
        return profileImg;
    }
    public SNSMember setProfileImg(String profileImg) {
        this.profileImg = profileImg;
        return this;
    }
    public String getJender() {
        return jender;
    }
    public SNSMember setJender(String jender) {
        this.jender = jender;
        return this;
    }
    @Override
    public String toString() {
        return "SNSMember [id=" + id + ", email=" + email + ", userName=" + userName + ", profileImg=" + profileImg
                + ", jender=" + jender + "]";
    }
    
    
}

//ver 31 - 생성자 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - 생성자 추가
//ver 17 - toString() 재정의.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.