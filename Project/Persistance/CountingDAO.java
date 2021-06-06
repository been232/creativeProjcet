package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.*;

public class CountingDAO extends BasicDAOImpl{
    public CountingDAO () {}
    public int parsing() {
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        int dbResult = 0;

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/VoteXmntckInfoInqireService2/getXmntckSttusInfoInqire?sgId=20200415&sgTypecode=2&pageNo=1&numOfRows=1000&resultType=json&serviceKey=" + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject countingResult = (JSONObject) jsonObject.get("getXmntckSttusInfoInqire");
            JSONArray item = (JSONArray) countingResult.get("item");
            int SIZE = 50;
            for(Object o : item) {
                JSONObject counting = (JSONObject) o;
                String sgId = (String) counting.get("SG_ID");
                String sggName = (String) counting.get("SGG_NAME");
                String sdName = (String) counting.get("SD_NAME");
                String wiwName = (String) counting.get("WIW_NAME");
                if (!sdName.equals("합계") && !wiwName.equals("합계")) {
                    ArrayList<String> jd = new ArrayList<>();
                    for (int i = 0; i < SIZE; i++) {
                        String jdNum = String.format("%02d", i + 1);
                        String jdTag = "JD" + jdNum;
                        String parsedJd = (String) counting.get(jdTag);
                        if (!(parsedJd).equals(""))
                            jd.add(parsedJd);
                    }
                    ArrayList<String> hubo = new ArrayList<>();
                    for (int i = 0; i < SIZE; i++) {
                        String huboNum = String.format("%02d", i + 1);
                        String huboTag = "HBJ" + huboNum;
                        String parsedHubo = (String) counting.get(huboTag);
                        if (!(parsedHubo).equals(""))
                            hubo.add(parsedHubo);
                    }
                    ArrayList<String> dugsu = new ArrayList<>();
                    for (int i = 0; i < SIZE; i++) {
                        String dugsuNum = String.format("%02d", i + 1);
                        String dugsuTag = "DUGSU" + dugsuNum;
                        String parsedDugsu = (String) counting.get(dugsuTag);
                        if (!(parsedDugsu).equals(""))
                            dugsu.add(parsedDugsu);
                    }
                    insert(sgId, sggName, sdName, wiwName, jd, hubo, dugsu);
                }
            }
         } catch (Exception e) {
            e.printStackTrace();
        }
        return dbResult;
    }

    public int insert(String sgId, String sggName, String sdName, String wiwName, ArrayList<String> jd, ArrayList<String> hubo, ArrayList<String> dugsu) {
        String sql = "INSERT INTO counting(sgId, sggName, sdName, wiwName, jdName, hbName, dugsu) values(?,?,?,?,?,?,?)";

        PreparedStatement pstmt = null;
        int result = 0;
        for(int i = 0; i < jd.size(); i++) {
            try {
                getConnection();

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, sgId);
                pstmt.setString(2, sggName);
                pstmt.setString(3, sdName);
                pstmt.setString(4, wiwName);
                pstmt.setString(5, jd.get(i));
                pstmt.setString(6, hubo.get(i));
                pstmt.setString(7, dugsu.get(i));

                result = pstmt.executeUpdate();
            } catch (SQLException se) {
 //               System.out.println(sggName + " " + sdName + " " + wiwName + hubo.get(i) + " " + jd.get(i));
                se.printStackTrace();
            } finally {
                try {
                    if(pstmt != null) pstmt.close();
                    if(conn != null) conn.close();
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }

        return result;
    }

    public ArrayList<CountingDTO> getCountingInfo() {
        ArrayList<CountingDTO> countingList = new ArrayList<>();
        String sql = "SELECT * FROM counting";

        PreparedStatement pstmt = null;
        ResultSet result = null;

        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();

            while(result.next()) {
                CountingDTO counting = new CountingDTO();
                counting.setSgID(result.getString("sgId"));
                counting.setSggName(result.getString("sggName"));
                counting.setSdName(result.getString("sdName"));
                counting.setWiwName(result.getString("wiwName"));
                counting.setJdName(result.getString("jdName"));
                counting.setHbName(result.getString("hbName"));
                counting.setDugsu(result.getInt("dugsu"));

                countingList.add(counting);
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

        return countingList;
    }
}
