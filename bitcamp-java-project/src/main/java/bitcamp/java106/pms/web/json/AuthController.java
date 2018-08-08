// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
/*    @RequestMapping("/info")
    public Object info() {
        
    }*/
    
    @RequestMapping("/logout")
    public void logout(HttpSession session) throws Exception {
        
        session.invalidate();
        
    }
    
    @GetMapping("/facebookLogin")
    public Object facebookLogin(String accessToken) {
        Map<String,Object> result = new HashMap<>();
        //System.out.println(accessToken);
        
        try {
            URL url = new URL("https://graph.facebook.com/v3.0/me?fields=id,name,email,gender&access_token=" + accessToken);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            StringBuffer buf = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                buf.append(line);
            }
            in.close();
            
            String jsonResult = StringEscapeUtils.unescapeJson(buf.toString());
            
            ObjectMapper mapper = new ObjectMapper();
            Map dataMap = mapper.readValue(jsonResult, Map.class);
            
            // DB에서 해당 이메일로 사용자를 찾아본다.
            // 있으면, 꺼내서 세션에 보관하여 로그인 처리하고,
            // 없으면, DB에 넣고 세션에 보관하여 로그인 처리한다.
            
            result.put("status", "success");
            result.put("id", dataMap.get("id"));
            result.put("name", dataMap.get("name"));
            result.put("email", dataMap.get("email"));
            
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        return result;
    }
}

//               [웹브라우저]                                  [웹서버] 
// GET 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: 로그인폼 
// POST 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: redirect URL
// GET 요청: /java106-java-project ===> 
//                                                       <=== 응답: index.html
// 메인화면 출력!

//ver 51 - redirect URL 변경
//ver 50 - DAO 변경에 따른 메서드 호출 변경
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 41 - 클래스 추가
