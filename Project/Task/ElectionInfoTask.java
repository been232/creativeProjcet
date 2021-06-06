package Project.Task;

import Project.Persistance.ElectionDAO;
import Project.Persistance.ElectionDTO;

import java.util.ArrayList;

public class ElectionInfoTask {
    ArrayList<ElectionDTO> electionDTOList = new ArrayList<>();
    ElectionDAO electionDAO = new ElectionDAO();

    public ArrayList<ElectionDTO> progressRequest() {
        electionDTOList = electionDAO.getElectionInfo();
        return electionDTOList;
    }
}
