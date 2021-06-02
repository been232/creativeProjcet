package Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CountingDAO {
    public static void main(String[] args) {
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/VoteXmntckInfoInqireService2/getXmntckSttusInfoInqire?sgId=20200415&sgTypecode=2&pageNo=1&numOfRows=10&resultType=json&serviceKey=" + key);

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
                String jdName = (String) counting.get("JD_NAME");
                ArrayList<String> jd = new ArrayList<>();
                for(int i = 0; i < SIZE; i++) {
                    String jdNum = String.format("%02d", i + 1);
                    String jdTag = "JD" + jdNum;
                    String parsedJd = (String) counting.get(jdTag);
                    if(!(parsedJd).equals(""))
                        jd.add(parsedJd);
                }
                ArrayList<String> hubo = new ArrayList<>();
                for(int i = 0; i < SIZE; i++) {
                    String huboNum = String.format("%02d", i + 1);
                    String huboTag = "HBJ" + huboNum;
                    String parsedHubo = (String) counting.get(huboTag);
                    if(!(parsedHubo).equals(""))
                        hubo.add(parsedHubo);
                }
                ArrayList<String> dugsu = new ArrayList<>();
                for(int i = 0; i < SIZE; i++) {
                    String dugsuNum = String.format("%02d", i + 1);
                    String dugsuTag = "DUGSU" + dugsuNum;
                    String parsedDugsu = (String) counting.get(dugsuTag);
                    if(!(parsedDugsu).equals(""))
                        dugsu.add(parsedDugsu);
                }

            }
         } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
