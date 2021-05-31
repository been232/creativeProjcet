package Persistance;

public class CountingDTO {
    private String sgCode;
    private String votingCode;
    private String countingCode;
    private String jdName;
    private String hbName;
    private int dugsu;

    public CountingDTO() {
  }

    public CountingDTO(String sgCode, String votingCode, String countingCode, String jdName, String hbName, int dugsu) {

        this.sgCode = sgCode;
        this.votingCode = votingCode;
        this.countingCode = countingCode;
        this.jdName = jdName;
        this.hbName = hbName;
        this.dugsu = dugsu;
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

    public String getCountingCode() {
        return countingCode;
    }

    public void setCountingCode(String countingCode) {
        this.countingCode = countingCode;
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
        return "Counting{" +
                "sgCode='" + sgCode + '\'' +
                ", votingCode='" + votingCode + '\'' +
                ", countingCode='" + countingCode + '\'' +
                ", jdName='" + jdName + '\'' +
                ", hbName='" + hbName + '\'' +
                ", dugsu=" + dugsu +
                '}';
    }
}
