package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.*;

public class CandidateDAO extends BasicDAOImpl {
    public CandidateDAO() {

    }

    public int parsing() {        // parsing으로 네이밍 변경 필요
        // 인증키 (개인이 받아와야함)
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        // 파싱한 데이터를 저장할 변수
        String result = "";

        int dbResult = 0;

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/PofelcddInfoInqireService/getPofelcddRegistSttusInfoInqire?sgId=20200415&sgTypecode=2&numOfRows=1118&resultType=json&ServiceKey="
                    + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject candidateResult = (JSONObject) jsonObject.get("getPofelcddRegistSttusInfoInqire");
            JSONArray item = (JSONArray) candidateResult.get("item");
            ArrayList<String> aList = new ArrayList<>();


            for (Object o : item) {
                JSONObject candidate = (JSONObject) o;
                String sgId = (String) candidate.get("SG_ID");
                String huboId = (String) candidate.get("HUBOID");
                String sggName = (String) candidate.get("SGG_NAME");
                String sdName = (String) candidate.get("SD_NAME");
                String wiwName = (String) candidate.get("WIW_NAME");
                String giho = (String) candidate.get("GIHO");
                String jdName = (String) candidate.get("JD_NAME");
                String name = (String) candidate.get("NAME");
                String hanjaName = (String) candidate.get("HANJA_NAME");
                String gender = (String) candidate.get("GENDER");
                String birthday = (String) candidate.get("BIRTHDAY");
                String age = (String) candidate.get("AGE");
                String job = (String) candidate.get("JOB");
                String edu = (String) candidate.get("EDU");
                String career = (String) candidate.get("CAREER1");
                String status = (String) candidate.get("STATUS");
                insert(sgId, huboId, sggName, sdName, wiwName, giho, jdName, name, hanjaName, gender, birthday, age, job, edu, career, status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbResult;
    }

    public int insert(String sgId, String huboId, String sggName, String sdName, String wiwName, String giho, String jdName,
                      String name, String hanjaName, String gender, String birthday, String age, String job,
                      String edu, String career, String status) {
        String sql = "INSERT INTO candidate(sgId, huboId, sggName, sdName, wiwName, giho, jdName, name, hanjaName, gender, birthday, age, job, edu, career1, status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sgId);
            pstmt.setString(2, huboId);
            pstmt.setString(3, sggName);
            pstmt.setString(4, sdName);
            pstmt.setString(5, wiwName);
            pstmt.setString(6, giho);
            pstmt.setString(7, jdName);
            pstmt.setString(8, name);
            pstmt.setString(9, hanjaName);
            pstmt.setString(10, gender);
            pstmt.setString(11, birthday);
            pstmt.setString(12, age);
            pstmt.setString(13, job);
            pstmt.setString(14, edu);
            pstmt.setString(15, career);
            pstmt.setString(16, status);

            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return result;
    }


    public ArrayList<CandidateDTO> getCandidateInfo() {
        ArrayList<CandidateDTO> candidateList = new ArrayList<>();
        String sql = "SELECT name, giho, jdName, birthday, edu, career1 FROM candidate";

        PreparedStatement pstmt = null;

        ResultSet result = null;

        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();

            while(result.next()) {
                CandidateDTO candidate = new CandidateDTO();
                candidate.setName(result.getString("name"));
                candidate.setJdName(result.getString("giho"));
                candidate.setBirthday(result.getDate("birthday"));
                candidate.setEdu(result.getString("edu"));
                candidate.setCareer1(result.getString("career1"));

                candidateList.add(candidate);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
                if(result != null) result.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return candidateList;
    }

}