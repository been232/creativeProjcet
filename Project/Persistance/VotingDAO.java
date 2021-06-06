package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.*;


public class VotingDAO extends BasicDAOImpl  {
    public VotingDAO(){

    }
    public int parsing(){
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        int dbResult = 0;

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/VoteXmntckInfoInqireService2/getVoteSttusInfoInqire?sgId=20200415&sgTypecode=7&pageNo=1&numOfRows=300&resultType=json&ServiceKey=" + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject votingResult = (JSONObject) jsonObject.get("getVoteSttusInfoInqire");
            JSONArray item = (JSONArray) votingResult.get("item");
            ArrayList<String> aList = new ArrayList<>();

            for(Object o : item) {
                JSONObject voting = (JSONObject) o;
                String sgId = (String) voting.get("SG_ID");
                String sdName = (String) voting.get("SD_NAME");
                String wiwName = (String) voting.get("WIW_NAME");
                String totTusu = (String) voting.get("TOT_TUSU");
                String turnOut = (String) voting.get("TURNOUT");
                if (!sdName.equals("합계") && !wiwName.equals("합계")) {
                    insert(sgId, sdName, wiwName, totTusu, turnOut);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dbResult;
    }
    public int insert(String sgId, String sdName, String wiwName, String totTusu, String turnOut){
        String sql = "INSERT INTO voting(sgId,sdName,wiwName,totTusu,turnOut) values(?,?,?,?,?)";

        PreparedStatement pstmt = null;
        int result = 0;
        try {
            getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sgId);
            pstmt.setString(2, sdName);
            pstmt.setString(3, wiwName);
            pstmt.setString(4, totTusu);
            pstmt.setString(5, turnOut);

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

    public ArrayList<VotingDTO> getVotingInfo() {
        ArrayList<VotingDTO> votingList = new ArrayList<>();
        String sql = "SELECT * FROM voting";

        PreparedStatement pstmt = null;

        ResultSet result = null;

        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();

            while(result.next()) {
                VotingDTO voting = new VotingDTO();
                voting.setSgId(result.getString("sgId"));
                voting.setSdName(result.getString("sdName"));
                voting.setWiwName(result.getString("wiwName"));
                voting.setTotTusu(result.getInt("totTusu"));
                voting.setTurnOut(result.getInt("turnOut"));
                votingList.add(voting);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
                if(result != null) result.close();
            } catch(Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return votingList;
    }
}
