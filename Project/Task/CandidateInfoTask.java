package Project.Task;

import Project.Persistance.CandidateDAO;
import Project.Persistance.CandidateDTO;

import java.util.ArrayList;


public class CandidateInfoTask {
    ArrayList<CandidateDTO> candidateDTOList = new ArrayList<>();
    CandidateDAO candidateDAO = new CandidateDAO();

    public ArrayList<CandidateDTO> progressRequest() {
        candidateDTOList = candidateDAO.getCandidateInfo();
        return candidateDTOList;
    }

}
