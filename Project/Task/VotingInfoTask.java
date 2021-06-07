package Project.Task;

import Project.Persistance.VotingDAO;
import Project.Persistance.VotingDTO;

import java.util.ArrayList;

public class VotingInfoTask {
    ArrayList<VotingDTO> votingDTOList = new ArrayList<>();
    VotingDAO votingDAO = new VotingDAO();

    public ArrayList<VotingDTO> progressRequest() {
        votingDTOList = votingDAO.getSdName();
        return votingDTOList;
    }
}
