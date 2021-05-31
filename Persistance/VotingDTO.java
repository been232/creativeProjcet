package Persistance;

public class VotingDTO {
    private String sgCode;
    private String votingCode;
    private String sdName;
    private String wiwName;
    private int totTusu;
    private int turnOut;

    public VotingDTO() {
    }

    public VotingDTO(String sgCode, String votingCode, String sdName, String wiwName, int totTusu, int turnOut) {
        this.sgCode = sgCode;
        this.votingCode = votingCode;
        this.sdName = sdName;
        this.wiwName = wiwName;
        this.totTusu = totTusu;
        this.turnOut = turnOut;
    }

    public String getSgCode() {
        return sgCode;
    }

    public void setSgCode(String sgCode) {
        this.sgCode = sgCode;
    }

    public String getVotingCode() {
        return votingCode;
    }

    public void setVotingCode(String votingCode) {
        this.votingCode = votingCode;
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
        return "Voting{" +
                "sgCode='" + sgCode + '\'' +
                ", votingCode='" + votingCode + '\'' +
                ", sdName='" + sdName + '\'' +
                ", wiwName='" + wiwName + '\'' +
                ", totTusu=" + totTusu +
                ", turnOut=" + turnOut +
                '}';
    }
}
