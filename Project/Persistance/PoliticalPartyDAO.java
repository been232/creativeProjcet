package Project.Persistance;

import java.net.URL;


public class PoliticalPartyDAO {
    public static void main(String[] args) {
        String key = "y9FWlTb%2BlJWwvrBNeooAhHEHzOKRLkQkNz8RsSVu5TTpBz9lFSobT9LwSUOa1hFFYcL%2FWjMMZ%2Bm8yJxUdwsiGg%3D%3D";

        String result = "";

        try {
            URL url = new URL("http://apis.data.go.kr/9760000/PartyPlcInfoInqireService/getPartyPlcInfoInqire?pageNo=1&numOfRows=10&resultType=xml&partyName=%EB%8D%94%EB%B6%88%EC%96%B4%EB%AF%BC%EC%A3%BC%EB%8B%B9&sgId=20200415&resultType=xml&ServiceKey=");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
