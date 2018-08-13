package bitcamp.java106.pms.web.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.SNSMember;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    
    @RequestMapping("info")
    public Object weather(int nx, int ny) {
        BufferedReader br = null;
        
        //현재 날짜 받아오기
        SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        SimpleDateFormat hr = new SimpleDateFormat("HH", Locale.KOREA);
        SimpleDateFormat M = new SimpleDateFormat("M", Locale.KOREA);
        SimpleDateFormat D = new SimpleDateFormat("d", Locale.KOREA);
        SimpleDateFormat E = new SimpleDateFormat("E", Locale.KOREA);
        SimpleDateFormat min = new SimpleDateFormat("mm", Locale.KOREA);
        Calendar c1 = Calendar.getInstance();
        int today = Integer.parseInt(day.format(c1.getTime()));
        int hours = Integer.parseInt(hr.format(c1.getTime()));
        int minutes = Integer.parseInt(min.format(c1.getTime()));
        int MONTH = Integer.parseInt(M.format(c1.getTime()));
        int DAY = Integer.parseInt(D.format(c1.getTime()));
        String EM = E.format(c1.getTime()).toString();
 
        HashMap<String, Object> map = new HashMap<>();
        // 기상청 데이터 업데이트 시간 + kkmm 형식으로 변경
        if(minutes < 40) {
            hours = hours -1;
            if(hours < 0) {
                today = today -1;
                hours = 23;
            }
        }
        
        String base_time;
        if (hours < 10) {
            base_time = "0" + hours + "00";
        } else {
            base_time = hours + "00";
        }
        
        try {
            String urlstr = "http://newsky2.kma.go.kr/"
                    + "service/SecndSrtpdFrcstInfoService2/ForecastGrib"
                    + "?ServiceKey=j2KT0WiQsYIQ1daSvlJI9F2%2Be0F0UW%2BacYymDWHHCX3BTq8ObPmb7WJSFxmIkLzxJDpIG%2BgjCRY1GqbWupOSlQ%3D%3D"
                    + "&base_date="
                    + today
                    + "&base_time="
                    + base_time
                    + "&nx=" + nx
                    + "&ny=" + ny
                    + "&numOfRows=10"
                    + "&pageNo=1"
                    + "&_type=json";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
            
            String result = "";
            String line;
            while((line = br.readLine()) != null) {
                result = result + line + "\n";
            }
            br.close();
            
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(result);
            // Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
            JSONObject parse_response = (JSONObject) obj.get("response");
            // response 로 부터 body 찾아옵니다.
            JSONObject parse_body = (JSONObject) parse_response.get("body");
            // body 로 부터 items 받아옵니다.
            JSONObject parse_items = (JSONObject) parse_body.get("items");
             
            // items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
            JSONArray parse_item = (JSONArray) parse_items.get("item");
            
            JSONObject vec_item = (JSONObject)parse_item.get(7); // 풍향
            JSONObject sky_item = (JSONObject)parse_item.get(4); // 하늘상태
            JSONObject rain_item = (JSONObject)parse_item.get(1); // 강수형태
            JSONObject temp_item = (JSONObject)parse_item.get(5); // 기온
            JSONObject wsd_item = (JSONObject)parse_item.get(9); // 풍속
            
            long sky = (Long) sky_item.get("obsrValue");
            long rain = (Long) rain_item.get("obsrValue");
            
            String weather;
            if (rain == 1) {
                weather = "비";
            } else if (rain == 2) {
                weather = "눈비";
            } else if (rain == 3){
                weather = "눈";
            } else if (sky == 1) {
                weather = "맑음";
            } else if (sky == 2) {
                weather = "구름조금";
            } else if (sky == 3) {
                weather = "구름많음";
            } else {
                weather = "흐림";
            }
            
            
            long vec = (Long) vec_item.get("obsrValue");
            
            String vector;
            if(337 < vec && vec < 23) {
                vector = "북";
            } else if(22 < vec && vec < 68) {
                vector = "북동";
            } else if(67 < vec && vec < 113) {
                vector = "동";
            } else if(112 < vec && vec < 158) {
                vector = "남동";
            } else if(157 < vec && vec < 203) {
                vector = "남";
            } else if(202 < vec && vec < 248) {
                vector = "남서";
            } else if(247 < vec && vec < 293) {
                vector = "서";
            } vector = "북서";
            
            map.put("m", MONTH);
            map.put("d", DAY);
            map.put("e", EM);
            map.put("wth", weather);
            map.put("temp", temp_item.get("obsrValue").toString());
            map.put("vec", vector);
            map.put("wsd", wsd_item.get("obsrValue").toString());
                br.close();
            }catch(Exception e){
                member = new SNSMember();

                member.setId(id);
                member.setName(name);
                member.setEmail(email);
                member.setEmail(gender);
                System.out.println(member);
            }
        return map;
        }
    
    }
