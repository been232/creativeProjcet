package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.*;

public class ElectionDAO extends BasicDAOImpl  {
    public ElectionDAO(){
    }
    public int parsing(){
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        int dbResult = 0;

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/CommonCodeService/getCommonSgCodeList?pageNo=1&numOfRows=300&resultType=json&ServiceKey=" + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject electionResult = (JSONObject) jsonObject.get("getCommonSgCodeList");
            JSONArray item = (JSONArray) electionResult.get("item");
            ArrayList<String> aList = new ArrayList<>();

            for(Object o : item) {
                JSONObject election = (JSONObject) o;
                String sgId = (String) election.get("SG_ID");
                String sgName = (String) election.get("SG_NAME");
                String sgVotedate = (String) election.get("SG_VOTEDATE");
                insert(sgId, sgName, sgVotedate);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dbResult;
    }
    public int insert(String sgId, String sgName, String sgVotedate){
        String sql = "INSERT INTO election(sgId,sgName,sgVotedate) values(?,?,?)";

        PreparedStatement pstmt = null;
        int result = 0;
        try {
            getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sgId);
            pstmt.setString(2, sgName);
            pstmt.setString(3, sgVotedate);

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

    public ArrayList<ElectionDTO> getElectionInfo() {
        ArrayList<ElectionDTO> electionList = new ArrayList<>();
        String sql = "SELECT * FROM election";

        PreparedStatement pstmt = null;

        ResultSet result = null;

        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();

            while(result.next()) {
                ElectionDTO election = new ElectionDTO();
                election.setSgId(result.getString("sgId"));
                election.setSgName(result.getString("sgName"));
                election.setSgVotedate(result.getDate("sgVotedate"));

                electionList.add(election);
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

        return electionList;
    }
}
