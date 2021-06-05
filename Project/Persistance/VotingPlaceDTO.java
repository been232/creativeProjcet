package Project.Persistance;

public class VotingPlaceDTO {
    private String sgId;
    private String psCode;
    private String psName;
    private String sdName;
    private String wiwName;
    private String emdName;
    private String placeName;
    private String addr;
    private String floor;

    public VotingPlaceDTO(){
    }

    public VotingPlaceDTO(String sgId, String psCode, String psName, String sdName, String wiwName, String emdName, String placeName, String addr, String floor) {
        this.sgId = sgId;
        this.psCode = psCode;
        this.psName = psName;
        this.sdName = sdName;
        this.wiwName = wiwName;
        this.emdName = emdName;
        this.placeName = placeName;
        this.addr = addr;
        this.floor = floor;
    }

    public String getSgId() {
        return sgId;
    }

    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public String getWiwName() { return wiwName; }

    public void setWiwName(String wiwName) { this.wiwName = wiwName; }

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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "VotingPlaceDTO{" +
                "sgId='" + sgId + '\'' +
                ", psCode='" + psCode + '\'' +
                ", psName='" + psName + '\'' +
                ", sdName='" + sdName + '\'' +
                ", wiwName='" + wiwName + '\'' +
                ", emdName='" + emdName + '\'' +
                ", placeName='" + placeName + '\'' +
                ", addr='" + addr + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
