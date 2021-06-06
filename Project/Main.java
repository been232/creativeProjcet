package Project;

import Project.Persistance.CandidateDTO;
import Project.Persistance.PolicyDTO;
import Project.Task.CandidateInfoTask;
import Project.Persistance.PolicyDAO;
import java.util.ArrayList;

public class Main {
    public static ClientConnecting connect;

    public static void main(String[] args) {

//        connect = new ClientConnecting();
//        connect.start();
        PolicyDAO dao = new PolicyDAO();

        ArrayList<PolicyDTO> list = dao.getPolicyInfo("공화당");

//        ArrayList<CandidateDTO> list
//
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getPrmsCont1());
        }
    }
}