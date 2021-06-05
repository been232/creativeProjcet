package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class VotingPlaceDAO {
    public VotingPlaceDAO() {}

    public static void main(String[] args) {        // parsing으로 네이밍 변경 필요
        String[] sd = new String[]{
                "서울특별시", "부산광역시", "대구광역시",
                "인천광역시", "광주광역시", "대전광역시",
                "울산광역시", "세종특별자치시", "경기도",
                "강원도", "충청북도", "충청남도",
                "전라북도", "전라남도", "경상북도",
                "경상남도", "제주특별자치도"
        };
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";
        String result = "";
        try {
            for(int i = 0; i < sd.length; i++) {
                String sdEncodeResult = URLEncoder.encode(sd[i], "UTF-8");
                URL url = new URL("http://apis.data.go.kr/9760000/PolplcInfoInqireService2/getPolplcOtlnmapTrnsportInfoInqire?serviceKey=" + key + "&pageNo=1&numOfRows=5000&resultType=json&sgId=20200415&sdName=" + sdEncodeResult + "&");

                BufferedReader bf;

                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONObject votingPlaceResult = (JSONObject) jsonObject.get("getPolplcOtlnmapTrnsportInfoInqire");
                JSONArray item = (JSONArray) votingPlaceResult.get("item");
                for(Object o : item) {
                    JSONObject votingPlace = (JSONObject) o;
                    String sgId = (String) votingPlace.get("SG_ID");
                    String psName = (String) votingPlace.get("PS_NAME");
                    String sdName = (String) votingPlace.get("SD_NAME");
                    String wiwName = (String) votingPlace.get("WIW_NAME");
                    String emdName = (String) votingPlace.get("EMD_NAME");
                    String placeName = (String) votingPlace.get("PLACE_NAME");
                    String addr = (String) votingPlace.get("ADDR");
                    String floor = (String) votingPlace.get("FLOOR");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

