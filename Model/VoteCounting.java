package Model;

public class VoteCounting { // 투표소 투표현황
	private String id; // 선거 ID
	private String sdName; // 시도명
	private int totSunsu; // 총 선거인수
	private int totTusu; // 총 투표인수
	private int Turnout; // 투표율
	
	public VoteCounting() {
		super();
	}
	public VoteCounting(String id, String sdName, int totSunsu, int totTusu, int Turnout) {
		super();
		this.id = id;
		this.sdName = sdName;
		this.totSunsu = totSunsu;
		this.totTusu = totTusu;
		this.Turnout = Turnout;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSdName() {
		return sdName;
	}
	public void setSdName(String sdName) {
		this.sdName = sdName;
	}
	public int getTotSunsu() {
		return totSunsu;
	}
	public void setTotSunsu(int totSunsu) {
		this.totSunsu = totSunsu;
	}
	public int getTotTusu() {
		return totTusu;
	}
	public void setTotTusu(int totTusu) {
		this.totTusu = totTusu;
	}
	public int getTurnout() {
		return Turnout;
	}
	public void setTurnout(int turnout) {
		Turnout = turnout;
	}
}
