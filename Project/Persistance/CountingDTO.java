package Project.Persistance;

public class CountingDTO {
    private String sgID;
    private String sggName;
    private String sdName;
    private String wiwName;
    private String jdName;
    private String hbName;
    private int dugsu;

    public CountingDTO() {
  }

    public CountingDTO(String sgID, String sggName, String sdName, String wiwName, String jdName, String hbName, int dugsu) {
        this.sgID = sgID;
        this.sggName = sggName;
        this.sdName = sdName;
        this.wiwName = wiwName;
        this.jdName = jdName;
        this.hbName = hbName;
        this.dugsu = dugsu;
    }

    public String getSgID() {
        return sgID;
    }

    public void setSgID(String sgID) {
        this.sgID = sgID;
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

    public String getJdName() {
        return jdName;
    }

    public void setJdName(String jdName) {
        this.jdName = jdName;
    }

    public String getHbName() {
        return hbName;
    }

    public void setHbName(String hbName) {
        this.hbName = hbName;
    }

    public int getDugsu() {
        return dugsu;
    }

    public void setDugsu(int dugsu) {
        this.dugsu = dugsu;
    }

    @Override
    public String toString() {
        return "CountingDTO{" +
                "sgID='" + sgID + '\'' +
                ", sggName='" + sggName + '\'' +
                ", sdName='" + sdName + '\'' +
                ", wiwName='" + wiwName + '\'' +
                ", jdName='" + jdName + '\'' +
                ", hbName='" + hbName + '\'' +
                ", dugsu=" + dugsu +
                '}';
    }
}
