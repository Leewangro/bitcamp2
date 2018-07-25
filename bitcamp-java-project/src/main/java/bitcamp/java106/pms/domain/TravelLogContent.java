package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class TravelLogContent implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tlno;
	private int tcno;
	private String place;
	private String address;
	private String photo;
	private String review;
	private String day;
    @Override
    public String toString() {
        return "TravelLogContent [tlno=" + tlno + ", tcno=" + tcno + ", place=" + place + ", address=" + address
                + ", photo=" + photo + ", review=" + review + ", day=" + day + "]";
    }
    public int getTlno() {
        return tlno;
    }
    public void setTlno(int tlno) {
        this.tlno = tlno;
    }
    public int getTcno() {
        return tcno;
    }
    public void setTcno(int tcno) {
        this.tcno = tcno;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
	
	


}