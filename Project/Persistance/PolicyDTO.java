package Project.Persistance;

public class PolicyDTO {
    private String sgId;
    private String jdCode;
    private int prmsCnt;
    private String prmsRealmName;
    private String prmsTitle;
    private String prmsCont;

    public PolicyDTO(){
    }

    public PolicyDTO(String sgId, String jdCode, int prmsCnt, String prmsRealmName, String prmsTitle, String prmsCont) {
        this.sgId = sgId;
        this.jdCode = jdCode;
        this.prmsCnt = prmsCnt;
        this.prmsRealmName = prmsRealmName;
        this.prmsTitle = prmsTitle;
        this.prmsCont = prmsCont;
    }

    public String getSgId() {
        return sgId;
    }

    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    public String getJdCode() {
        return jdCode;
    }

    public void setJdCode(String jdCode) {
        this.jdCode = jdCode;
    }

    public int getPrmsCnt() {
        return prmsCnt;
    }

    public void setPrmsCnt(int prmsCnt) {
        this.prmsCnt = prmsCnt;
    }

    public String getPrmsRealmName() {
        return prmsRealmName;
    }

    public void setPrmsRealmName(String prmsRealmName) {
        this.prmsRealmName = prmsRealmName;
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

    @Override
    public String toString() {
        return "PolicyDTO{" +
                "sgId='" + sgId + '\'' +
                ", jdCode='" + jdCode + '\'' +
                ", prmsCnt=" + prmsCnt +
                ", prmsRealmName='" + prmsRealmName + '\'' +
                ", prmsTitle='" + prmsTitle + '\'' +
                ", prmsCont='" + prmsCont + '\'' +
                '}';
    }
}
