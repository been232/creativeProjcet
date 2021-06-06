package Project.Persistance;

import java.io.Serializable;
import java.util.Date;

public class CandidateDTO implements Serializable {  //후보자 정보
	private String sgId;
	private String huboId;
	private String sggName;
	private String sdName;
	private String wiwName;
	private int giho;
	private String jdName;
	private String jdCode;
	private String name;
	private String hanjaName;
	private String gender;
	private Date birthday;
	private int age;
	private String job;
	private String edu;
	private String career1; // (현)
	private String career2; // (전)
	private String status;

	public CandidateDTO(){
	}
	public CandidateDTO(String sgId, String huboId, String sggName, String sdName, String wiwName, int giho, String jdName, String jdCode, String name, String hanjaName, String gender, Date birthday, int age, String job, String edu, String career1, String career2, String status) {
		this.sgId = sgId;
		this.huboId = huboId;
		this.sggName = sggName;
		this.sdName = sdName;
		this.wiwName = wiwName;
		this.giho = giho;
		this.jdName = jdName;
		this.jdCode = jdCode;
		this.name = name;
		this.hanjaName = hanjaName;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.job = job;
		this.edu = edu;
		this.career1 = career1;
		this.career2 = career2;
		this.status = status;
	}

	public String getSgId() {
		return sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	public String getHuboId() {
		return huboId;
	}

	public void setHuboId(String huboId) {
		this.huboId = huboId;
	}

	public String getSggName() {
		return sggName;
	}

	public void setSggName(String sggName) {
		this.sggName = sggName;
	}

	public String getSdName() {
		return sdName;
	}

	public void setSdName(String sdName) {
		this.sdName = sdName;
	}

	public String getWiwName() {
		return wiwName;
	}

	public void setWiwName(String wiwName) {
		this.wiwName = wiwName;
	}

	public int getGiho() {
		return giho;
	}

	public void setGiho(int giho) {
		this.giho = giho;
	}

	public String getJdName() {
		return jdName;
	}

	public void setJdName(String jdName) {
		this.jdName = jdName;
	}

	public String getJdCode() {
		return jdCode;
	}

	public void setJdCode(String jdCode) {
		this.jdCode = jdCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHanjaName() {
		return hanjaName;
	}

	public void setHanjaName(String hanjaName) {
		this.hanjaName = hanjaName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getCareer1() {
		return career1;
	}

	public void setCareer1(String career1) {
		this.career1 = career1;
	}

	public String getCareer2() {
		return career2;
	}

	public void setCareer2(String career2) {
		this.career2 = career2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CandidateDTO{" +
				"sgId='" + sgId + '\'' +
				", huboId='" + huboId + '\'' +
				", sggName='" + sggName + '\'' +
				", sdName='" + sdName + '\'' +
				", wiwName='" + wiwName + '\'' +
				", giho=" + giho +
				", jdName='" + jdName + '\'' +
				", jdCode='" + jdCode + '\'' +
				", name='" + name + '\'' +
				", hanjaName='" + hanjaName + '\'' +
				", gender='" + gender + '\'' +
				", birthday=" + birthday +
				", age=" + age +
				", job='" + job + '\'' +
				", edu='" + edu + '\'' +
				", career1='" + career1 + '\'' +
				", career2='" + career2 + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
