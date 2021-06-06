package Project.Persistance;

import java.io.Serializable;
import java.util.Date;

public class ElectionDTO implements Serializable {
    private String sgId;
    private String sgName;
    private Date sgVotedate;

    public ElectionDTO(){
    }

    public ElectionDTO(String sgId, String sgName, Date sgVotedate) {
        this.sgId = sgId;
        this.sgName = sgName;
        this.sgVotedate = sgVotedate;
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

    public String getSgId() {
        return sgId;
    }

    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    @Override
    public String toString() {
        return "ElectionDTO{" +
                "sgId='" + sgId + '\'' +
                ", sgName='" + sgName + '\'' +
                ", sgVotedate=" + sgVotedate +
                '}';
    }
}
