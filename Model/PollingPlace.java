package Model;

public class PollingPlace { //투표소 정보
	private String id;
	private String sdName;
	private String emdName;
	private String placeName;
	private String addr;
	
	public PollingPlace() {
		super();
	}
	public PollingPlace(String id, String sdName, String emdName, String placeName, String addr) {
		super();
		this.id = id;
		this.sdName = sdName;
		this.emdName = emdName;
		this.placeName = placeName;
		this.addr = addr;
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
	public String getEmdName() {
		return emdName;
	}
	public void setEmdName(String emdName) {
		this.emdName = emdName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
