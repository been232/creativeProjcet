package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PolicyDAO {

    public PolicyDAO() {}

    static public void main(String[] args) {
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

                for(Object o : item) {
                    JSONObject policy = (JSONObject) o;
                    String sgId = (String) policy.get("sgId");
                    String jdName = (String) policy.get("partyName");
                    String prmsCnt = (String) policy.get("prmsCnt");

//                    for(int j = 1; j <= Integer.parseInt(prmsCnt); j++) {
//                        String prmsRealmNameTag = "prmsRealmName" + j;
//                        String prmsTitleTag = "prmsTitle" + j;
//                        String prmmContTag = "prmmCont" + j;
//
//                        String prmsRealmName = (String) policy.get(prmsRealmNameTag);
//                        String prmsTitle = (String) policy.get(prmsTitleTag);
//                        String prmmCont = (String) policy.get(prmmContTag);
//
//
//                    }
                    System.out.println(jdName + ": " + prmsCnt);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
       // return dbResult;
    }
}
