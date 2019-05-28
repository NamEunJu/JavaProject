package project_sample1;

import java.io.Serializable;

public class CafeVO1 implements Serializable{
	
	private String id;
	private String pwd1;
	private String name;
	private String gender;
	private String birth;
	private String email;
	private String tel;
	private String rank;
	private int appen;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel2) {
		this.tel = tel2;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getAppen() {
		return appen;
	}
	public void setAppen(int appen) {
		this.appen = appen;
	}
	
}
