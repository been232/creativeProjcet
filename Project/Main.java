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
        //VotingDAO dao = new VotingDAO();
        //dao.getSdName();

    }
}