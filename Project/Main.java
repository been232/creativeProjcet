package Project;

import Project.Persistance.PolicyDAO;

public class Main {
    public static void main(String[] args) {
        PolicyDAO dao = new PolicyDAO();
        dao.parsing();
    }
}
