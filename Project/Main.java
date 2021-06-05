package Project;

import Project.Persistance.CountingDAO;

public class Main {
    public static void main(String[] args) {
        CountingDAO dao = new CountingDAO();
        dao.parsing();
    }
}
