package Project.Protocol;

public enum ProtocolType {
    UNKNOWN(0),
    BAL_REQ(1),  BAL_RES(2),    // BallotCountLocation
    CAN_REQ(3),  CAN_RES(4),    // Candidate
    ELE_REQ(5),  ELE_RES(6),    // Election
    ELP_REQ(7),  ELP_RES(8),    // ElectionPledges
    ELR_REQ(9),  ELR_RES(10),   // ElectionReturns
    PLP_REQ(11), PLP_RES(12),   // PoliticalParty
    PGP_REQ(13), PGP_RES(14),   // PollingPlace
    SUC_REQ(15), SUC_RES(16),   // SuccessfulCandidate
    VOC_REQ(17), VOC_RES(18);   // VoteCounting

    private int value;

    ProtocolType(int value) { this.value = value; }

    public int getValue() { return value; }
}
