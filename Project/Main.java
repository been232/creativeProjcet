package Project;

import Project.Persistance.CandidateDTO;
import Project.Persistance.PolicyDTO;
import Project.Task.CandidateInfoTask;
import Project.Persistance.PolicyDAO;
import java.util.ArrayList;

import Project.Persistance.*;

public class Main {
    public static ClientConnecting connect;

    public static void main(String[] args) {

        connect = new ClientConnecting();
        connect.start();
//        CountingDAO dao = new CountingDAO();

//        ArrayList<CountingDTO> list = dao.getCountingInfo();
//        ArrayList<CandidateDTO> list
//
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getHbName() + list.get(i).getDugsu());
//        }
    }
}