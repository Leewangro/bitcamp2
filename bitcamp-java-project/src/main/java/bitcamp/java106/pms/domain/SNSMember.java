package bitcamp.java106.pms.domain;

import java.io.Serializable;

/**
 * @author Bit
 *
 */
public class SNSMember implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String email;
    private String name;
    private String profileImg;
    private String gender;
    private int phone;
    
    
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


    public void setId(String id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getProfileImg() {
        return profileImg;
    }


    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getPhone() {
        return phone;
    }


    public void setPhone(int phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "SNSMember [id=" + id + ", email=" + email + ", userName=" + name + ", profileImg=" + profileImg
                + ", gender=" + gender + ", phone=" + phone + "]";
    }

    
    
    
}

//ver 31 - 생성자 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - 생성자 추가
//ver 17 - toString() 재정의.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.