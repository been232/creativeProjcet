package Project.Persistance;

import java.util.Date;

public class PoliticalPartyDTO { // 정당정책 정보
	private String jdCode;
	private String jdName;
	private Date regDate;
	private String addr;
	private String telNum;

	public PoliticalPartyDTO(){
	}
	public PoliticalPartyDTO(String jdCode, String jdName, Date regDate, String addr, String telNum) {
		this.jdCode = jdCode;
		this.jdName = jdName;
		this.regDate = regDate;
		this.addr = addr;
		this.telNum = telNum;
	}

	public String getJdCode() {
		return jdCode;
	}

	public void setJdCode(String jdCode) {
		this.jdCode = jdCode;
	}

	public String getJdName() {
		return jdName;
	}

	public void setJdName(String jdName) {
		this.jdName = jdName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	@Override
	public String toString() {
		return "PoliticalPartyDTO{" +
				"jdCode='" + jdCode + '\'' +
				", jdName='" + jdName + '\'' +
				", regDate=" + regDate +
				", addr='" + addr + '\'' +
				", telNum='" + telNum + '\'' +
				'}';
	}
}
