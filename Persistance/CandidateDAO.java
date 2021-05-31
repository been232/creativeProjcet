package Persistance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CandidateDAO {
    public static void main(String[] args) {

        // 인증키 (개인이 받아와야함)
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        // 파싱한 데이터를 저장할 변수
        String result = "";

        try {

            URL url = new URL("http://apis.data.go.kr/9760000/PofelcddInfoInqireService/getPofelcddRegistSttusInfoInqire?sgId=20200415&sgTypecode=2&sdName=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C&sggName=%EC%A2%85%EB%A1%9C%EA%B5%AC&pageNo=1&numOfRows=10&resultType=json&ServiceKey="
                    + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
            JSONObject jdResult = (JSONObject)jsonObject.get("getPofelcddRegistSttusInfoInqire");
            JSONArray jdInfo = (JSONArray) jdResult.get("item");
            //System.out.println(jdInfo.get(0));
            JSONObject jd1 = (JSONObject) jdInfo.get(0);

            System.out.println(jdInfo.size());
//            JSONObject jdInfo = (JSONObject)jdResult.get("item");
//
//            JSONArray item = (JSONArray)jdInfo.get(0);
//            System.out.println("Num : " + jdInfo.get("NUM"));


//            JSONArray directors = (JSONArray)jdInfo.get("directors");
//            JSONObject directors_peopleNm = (JSONObject)directors.get(0);
//
//            JSONArray genres = (JSONArray)jdInfo.get("genres");
//
//            JSONArray actors = (JSONArray)jdInfo.get("actors");
//
//            System.out.println("영화코드 : " + jdInfo.get("movieCd"));
//            System.out.println("영화명(한글) : " + jdInfo.get("movieNm"));
//            System.out.println("영화명(영문) : " + jdInfo.get("movieNmEn"));
//            System.out.println("재생시간 : " + jdInfo.get("showTm"));
//            System.out.println("개봉일 : " + jdInfo.get("openDt"));
//            System.out.println("영화유형 : " + jdInfo.get("typeNm"));
//            System.out.println("제작국가명 : " + nations_nationNm.get("nationNm"));
//
//            String genreNm = "";
//
//            for(int i = 0; i < genres.size(); i++) {
//                JSONObject genres_genreNm = (JSONObject)genres.get(i);
//                genreNm += genres_genreNm.get("genreNm") + " ";
//            }
//
//            System.out.println("장르 : " + genreNm);
//
//            System.out.println("감독명 : " + directors_peopleNm.get("peopleNm"));
//
//            String peopleNm = "";
//
//            for(int i = 0; i < actors.size(); i++) {
//                JSONObject actors_peopleNm = (JSONObject)actors.get(i);
//                peopleNm += actors_peopleNm.get("peopleNm") + " ";
//                peopleNm = peopleNm + actors_peopleNm.get("peopleNm") + " ";
//            }
//
//            System.out.println("출연배우 : " + peopleNm);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}