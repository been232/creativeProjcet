package Persistance;

import java.util.Date;

public class ElectionDTO {
    private String sgCode;
    private String sgName;
    private Date sgVotedate;

    public ElectionDTO(){
    }
    public ElectionDTO(String sgCode, String sgName, Date sgVotedate){
        this.sgCode=sgCode;
        this.sgName=sgName;
        this.sgVotedate=sgVotedate;
    }

    public Date getSgVotedate() {
        return sgVotedate;
    }
    public void setSgVotedate(Date sgVotedate) {
        this.sgVotedate = sgVotedate;
    }
    public String getSgName() {
        return sgName;
    }
    public void setSgName(String sgName) {
        this.sgName = sgName;
    }
    public String getSgCode() {
        return sgCode;
    }
    public void setSgCode(String sgCode) {
        this.sgCode = sgCode;
    }
    @Override
    public String toString() {
        return "ElectionDTO{" +
                "sgCode='" + sgCode + '\'' +
                ", sgName='" + sgName + '\'' +
                ", sgVotedate=" + sgVotedate +
                '}';
    }
}
