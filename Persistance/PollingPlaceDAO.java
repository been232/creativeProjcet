package Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PollingPlaceDAO {
    public static void main(String args[]) {
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";
        String result = "";
        ArrayList<String> sdNameList = new ArrayList<String>();
        try {
            URL url = new URL("http://apis.data.go.kr/9760000/PolplcInfoInqireService2/getPolplcOtlnmapTrnsportInfoInqire?serviceKey="+key+"&pageNo=1&numOfRows=10&sgId=20200415&sdName=서울특별시&");

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

