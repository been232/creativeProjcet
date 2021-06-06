package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.*;

public class PolicyDAO extends BasicDAOImpl {

    public PolicyDAO() {}

    public void parsing() {
        String[] policyArray = new String[] {
                "더불어민주당", "미래통합당", "우리공화당", "민중당",
                "가자!평화인권당", "공화당", "국가혁명배당금당", "국민새정당",
                "기독자유통일당", "한나라당",
                "정의당", "민생당", "한국복지당", "기본소득당",
                "통일민주당", "친박신당", "노동당", "충청의미래당"
        };
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        int dbResult = 0;

        try {
            for(int i = 0; i < policyArray.length; i++) {
                String pEncodeResult = URLEncoder.encode(policyArray[i], "UTF-8");
                URL url = new URL("http://apis.data.go.kr/9760000/PartyPlcInfoInqireService/getPartyPlcInfoInqire?pageNo=1&numOfRows=100&resultType=json&partyName=" + pEncodeResult + "&sgId=20200415&resultType=xml&ServiceKey=" + key);

                BufferedReader bf;

                bf = new BufferedReader(new InputStreamReader((url.openStream()),"UTF-8"));

                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONObject policyResult = (JSONObject) jsonObject.get("getPartyPlcInfoInqire");
                JSONArray item = (JSONArray) policyResult.get("item");
                System.out.println(item.size());
                for(Object o : item) {
                    JSONObject policy = (JSONObject) o;
                    String sgId = (String) policy.get("sgId");
                    String jdName = (String) policy.get("partyName");
                    String prmsCnt = (String) policy.get("prmsCnt");
                    ArrayList<String> prmsRealmNameList = new ArrayList<>();
                    ArrayList<String> prmsTitleList = new ArrayList<>();
                    ArrayList<String> prmmContList = new ArrayList<>();
                    ArrayList<String> prmsOrdList = new ArrayList<>();
                    for(int j = 1; j <= Integer.parseInt(prmsCnt); j++) {
                        String prmsRealmNameTag = "prmsRealmName" + j;
                        String prmsTitleTag = "prmsTitle" + j;
                        String prmmContTag = "prmmCont" + j;
                        String prmsOrdTag = "prmsOrd" + j;

                        String prmsRealmName = (String) policy.get(prmsRealmNameTag);
                        String prmsTitle = (String) policy.get(prmsTitleTag);
                        String prmmCont = (String) policy.get(prmmContTag);
                        String prmsOrd = (String) policy.get(prmsOrdTag);

                        prmsRealmNameList.add(prmsRealmName);
                        prmsTitleList.add(prmsTitle);
                        prmmContList.add(prmmCont);
                        prmsOrdList.add(prmsOrd);
                    }
                    if(prmsOrdList.size() == 9) {
                        prmsRealmNameList.add("null");
                        prmsTitleList.add("null");
                        prmmContList.add("null");
                        prmsOrdList.add("10");
                    }
                    insert(sgId, jdName, prmsRealmNameList, prmsOrdList, prmsTitleList, prmmContList);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
       // return dbResult;
    }

    public int insert(String sgId, String jdName, ArrayList<String> prmsRealmNameList, ArrayList<String> prmsOrdList, ArrayList<String> prmsTitleList, ArrayList<String> prmmContList) {

        String sql = "INSERT INTO policy(sgId, jdName, prmsOrd1, prmsOrd2, prmsOrd3, prmsOrd4, prmsOrd5, prmsOrd6, prmsOrd7, prmsOrd8, prmsOrd9, prmsOrd10, " +
                "prmsRealmName1, prmsRealmName2, prmsRealmName3, prmsRealmName4, prmsRealmName5, prmsRealmName6, prmsRealmName7, prmsRealmName8, prmsRealmName9, prmsRealmName10, " +
                "prmsTitle1, prmsTitle2, prmsTitle3, prmsTitle4, prmsTitle5, prmsTitle6, prmsTitle7, prmsTitle8, prmsTitle9, prmsTitle10, " +
                "prmmCont1, prmmCont2, prmmCont3, prmmCont4, prmmCont5, prmmCont6, prmmCont7, prmmCont8, prmmCont9, prmmCont10) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = null;

        int result = 0;

        try {
            getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sgId);
            pstmt.setString(2, jdName);
            int i = 3;
            for(int j = 0; j < prmsOrdList.size(); j++) {
                pstmt.setString(j + i, prmsOrdList.get(j));
            }
            i = 13;
            for(int j = 0; j < prmsRealmNameList.size(); j++) {
                pstmt.setString(j + i, prmsRealmNameList.get(j));
            }
            i = 23;
            for(int j = 0; j < prmsTitleList.size(); j++) {
                pstmt.setString(j + i, prmsTitleList.get(j));
            }
            i = 33;
            for(int j = 0; j < prmmContList.size(); j++) {
                pstmt.setString(j + i, prmmContList.get(j));
            };

            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return result;
    }

    public ArrayList<PolicyDTO> getPolicyInfo(String jdName) {
        ArrayList<PolicyDTO> policyList = new ArrayList<>();
        String sql = "SELECT * FROM policy WHERE jdName = ?";

        PreparedStatement pstmt = null;
        ResultSet result = null;
        PolicyDTO policy = new PolicyDTO();

        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jdName);
            result = pstmt.executeQuery();
            while(result.next()) {
                policy.setPrmsRealmName1(result.getString("prmsRealmName1"));
                policy.setPrmsRealmName2(result.getString("prmsRealmName2"));
                policy.setPrmsRealmName3(result.getString("prmsRealmName3"));
                policy.setPrmsRealmName4(result.getString("prmsRealmName4"));
                policy.setPrmsRealmName5(result.getString("prmsRealmName5"));
                policy.setPrmsRealmName6(result.getString("prmsRealmName6"));
                policy.setPrmsRealmName7(result.getString("prmsRealmName7"));
                policy.setPrmsRealmName8(result.getString("prmsRealmName8"));
                policy.setPrmsRealmName9(result.getString("prmsRealmName9"));
                policy.setPrmsRealmName10(result.getString("prmsRealmName10"));

                policy.setPrmsTitle1(result.getString("prmsTitle1"));
                policy.setPrmsTitle2(result.getString("prmsTitle2"));
                policy.setPrmsTitle3(result.getString("prmsTitle3"));
                policy.setPrmsTitle4(result.getString("prmsTitle4"));
                policy.setPrmsTitle5(result.getString("prmsTitle5"));
                policy.setPrmsTitle6(result.getString("prmsTitle6"));
                policy.setPrmsTitle7(result.getString("prmsTitle7"));
                policy.setPrmsTitle8(result.getString("prmsTitle8"));
                policy.setPrmsTitle9(result.getString("prmsTitle9"));
                policy.setPrmsTitle10(result.getString("prmsTitle10"));

                policy.setPrmsCont1(result.getString("prmmCont1"));
                policy.setPrmsCont2(result.getString("prmmCont2"));
                policy.setPrmsCont3(result.getString("prmmCont3"));
                policy.setPrmsCont4(result.getString("prmmCont4"));
                policy.setPrmsCont5(result.getString("prmmCont5"));
                policy.setPrmsCont6(result.getString("prmmCont6"));
                policy.setPrmsCont7(result.getString("prmmCont7"));
                policy.setPrmsCont8(result.getString("prmmCont8"));
                policy.setPrmsCont9(result.getString("prmmCont9"));
                policy.setPrmsCont10(result.getString("prmmCont10"));

                policyList.add(policy);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if(result != null) result.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return policyList;
    }
}
