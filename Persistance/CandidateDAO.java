package Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CandidateDAO {
    public static void main(String args[]) {        // parsing으로 네이밍 변경 필요
        // 인증키 (개인이 받아와야함)
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        // 파싱한 데이터를 저장할 변수
        String result = "";

        try {

            URL url = new URL("http://apis.data.go.kr/9760000/PofelcddInfoInqireService/getPofelcddRegistSttusInfoInqire?sgId=20200415&sgTypecode=2&numOfRows=1118&resultType=json&ServiceKey="
                    + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
            JSONObject candidateResult = (JSONObject)jsonObject.get("getPofelcddRegistSttusInfoInqire");
            JSONArray item = (JSONArray) candidateResult.get("item");
            int i = 0;
            for (Object o : item) {
                JSONObject candidate = (JSONObject) o;
                String sgId = (String) candidate.get("SG_ID");
                String huboId = (String) candidate.get("HUBOID");
                String sggName = (String) candidate.get("SGG_NAME");
                String sdName = (String) candidate.get("SD_NAME");
                String wiwName = (String) candidate.get("WIW_NAME");
                String giho = (String) candidate.get("GIHO");
                String jdName = (String) candidate.get("JD_NAME");
                String jdCode; // 차후 수작업으로 DB에 업로드
                String name = (String) candidate.get("NAME");
                String hanjaName = (String) candidate.get("HANJA_NAME");
                String gender = (String) candidate.get("GENDER");
                String birthday = (String) candidate.get("BIRTHDAY");
                String age = (String) candidate.get("AGE");
                String job = (String) candidate.get("JOB");
                String edu = (String) candidate.get("EDU");
                String career = (String) candidate.get("CAREER1");
                String status = (String) candidate.get("STATUS");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}