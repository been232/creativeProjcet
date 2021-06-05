package Project.Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class VotingDAO {
    public static void main(String[] args) {
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/VoteXmntckInfoInqireService2/getVoteSttusInfoInqire?sgId=20200415&sgTypecode=7&pageNo=1&numOfRows=300&resultType=json&ServiceKey=" + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject votingResult = (JSONObject) jsonObject.get("getVoteSttusInfoInqire");
            JSONArray item = (JSONArray) votingResult.get("item");

            for(Object o : item) {
                JSONObject voting = (JSONObject) o;
                String sgId = (String) voting.get("SG_ID");
                String sdName = (String) voting.get("SD_NAME");
                String wiwName = (String) voting.get("WIW_NAME");
                String totTusu = (String) voting.get("TOT_TUSU");
                String turnOut = (String) voting.get("TURNOUT");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
