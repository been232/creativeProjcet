package Model;

public class PoliticalParty { // 정당정책 정보
	private String id;
	private String partyName;
	private int prmsOrd;
	private String prmsTitle;
	private String prmsCont;

	public PoliticalParty() {
		super();
	}
	public PoliticalParty(String id, String partyName, int prmsOrd, String prmsTitle, String prmsCont) {
		super();
		this.id = id;
		this.partyName = partyName;
		this.prmsOrd = prmsOrd;
		this.prmsTitle = prmsTitle;
		this.prmsCont = prmsCont;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public int getPrmsOrd() {
		return prmsOrd;
	}
	public void setPrmsOrd(int prmsOrd) {
		this.prmsOrd = prmsOrd;
	}
	public String getPrmsTitle() {
		return prmsTitle;
	}
	public void setPrmsTitle(String prmsTitle) {
		this.prmsTitle = prmsTitle;
	}
	public String getPrmsCont() {
		return prmsCont;
	}
	public void setPrmsCont(String prmsCont) {
		this.prmsCont = prmsCont;
	}

	
}
