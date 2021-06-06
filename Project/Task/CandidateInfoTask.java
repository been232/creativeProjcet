package Project.Task;

import Project.Persistance.CandidateDAO;
import Project.Persistance.CandidateDTO;

import java.util.ArrayList;


public class CandidateInfoTask {
    ArrayList<CandidateDTO> candidateDTOList = new ArrayList<>();
    CandidateDAO candidateDAO = new CandidateDAO();

    public ArrayList<CandidateDTO> progressRequest() {
        String result = "후보자 정보"; //null;
        candidateDTOList = candidateDAO.getCandidateInfo();

//        System.out.println(candidateDTO.get(0).getName());


        return candidateDTOList;
    }

}
