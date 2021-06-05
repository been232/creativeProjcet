package Project.Persistance;

public class VotingDTO {
    private String sgId;
    private String sdName;
    private String wiwName;
    private int totTusu;
    private int turnOut;

    public VotingDTO() {
    }

    public VotingDTO(String sgId, String sdName, String wiwName, int totTusu, int turnOut) {
        this.sgId = sgId;
        this.sdName = sdName;
        this.wiwName = wiwName;
        this.totTusu = totTusu;
        this.turnOut = turnOut;
    }

    public String getSgId() {
        return sgId;
    }

    public void setSgId(String sgId) {
        this.sgId = sgId;
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

    public int getTotTusu() {
        return totTusu;
    }

    public void setTotTusu(int totTusu) {
        this.totTusu = totTusu;
    }

    public int getTurnOut() {
        return turnOut;
    }

    public void setTurnOut(int turnOut) {
        this.turnOut = turnOut;
    }

    @Override
    public String toString() {
        return "VotingDTO{" +
                "sgId='" + sgId + '\'' +
                ", sdName='" + sdName + '\'' +
                ", wiwName='" + wiwName + '\'' +
                ", totTusu=" + totTusu +
                ", turnOut=" + turnOut +
                '}';
    }
}
