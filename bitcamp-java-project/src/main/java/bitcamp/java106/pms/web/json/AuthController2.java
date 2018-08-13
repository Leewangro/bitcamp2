// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import bitcamp.java106.pms.dao.SNSMemberDao;
import bitcamp.java106.pms.domain.SNSMember;

@RestController
@RequestMapping("/auth2")
public class AuthController2 {
    
/*    @RequestMapping("/info")
    public Object info() {
        
    }*/
    SNSMemberDao snsMemberDao;
    SNSMember member;
    
    public AuthController2(SNSMemberDao snsMemberDao) {
        // TODO Auto-generated constructor stub
        this.snsMemberDao = snsMemberDao;
        this.member = null;
    }
    
    @RequestMapping("/logout2")
    public void logout(HttpSession session) throws Exception {
        System.out.println("invalidate");
        this.member = null;
    }
    
    @GetMapping("/facebookLogin2")
    public Object facebookLogin(String accessToken, HttpSession session) {
        //System.out.println(accessToken);
        Map<String, Object> obj = new HashMap<>();
        String id="", name="", email="", gender="";
        SNSMember member = null;
        
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
            

            
            id = (String)dataMap.get("id");
            name = (String)dataMap.get("name");
            email = (String)dataMap.get("email");
            gender = (String)dataMap.get("gender");

            member = snsMemberDao.selectOne(id);

            obj.put("name", member.getName());
            obj.put("status", "success");
            
            System.out.println("dqwew"+session.getAttribute("userInfo")); // 정상
            System.out.println("insert time:"+ new Date(session.getCreationTime())); // 정상
        } catch (Exception e) {
            member.setId(id);
            member.setName(name);
            member.setEmail(email);
            member.setEmail(gender);
            System.out.println("memberInput");
            System.out.println(member);
            
            try {
                snsMemberDao.insert(member);
            } catch(Exception e2) {
                obj.put("status", "fail");
            }
            
            session.setAttribute("userInfo", member);
            
            obj.put("name", member.getName());
            obj.put("status", "success");
        }
        this.member = member;
        return obj;
    }
    
    @GetMapping("/kakaoLogin2")
    public Object kakaoLogin(String accessToken,  HttpSession session) {
        Map<String, Object> obj = new HashMap<>();
        String id="", name="", email="", gender="";
        SNSMember member = null;
        
        try {
            URL urlstr = new URL("https://kapi.kakao.com/v2/user/me?fields=id,kakao_account.email&access_token=" + accessToken);
            HttpsURLConnection con = (HttpsURLConnection)urlstr.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buf = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                buf.append(line);
            }
            in.close();
            
            String jsonResult = StringEscapeUtils.unescapeJson(buf.toString());
            ObjectMapper mapper = new ObjectMapper();
            Map kakaoMap = mapper.readValue(jsonResult, Map.class);
            Map properties = (Map) kakaoMap.get("properties");
            Map kakao_account = (Map) kakaoMap.get("kakao_account");
            id = (String) kakaoMap.get("id").toString();
            name = (String) properties.get("nickname");
            email = (String) kakao_account.get("email");
            member = snsMemberDao.selectOne(id);
            
            obj.put("name", member.getName());
            obj.put("status", "success");
            
            System.out.println("dqwew"+session.getAttribute("userInfo")); // 정상
            System.out.println("insert time:"+ new Date(session.getCreationTime())); // 정상
        } catch (Exception e ) {
            System.out.println(email);
            member.setId(id);
            member.setName(name);
            member.setEmail(gender);
            if (member.getEmail() == null) {
                member.setEmail(email);
            }
            System.out.println(email);
            System.out.println(member);
            try {
                snsMemberDao.insert(member);
            } catch(Exception e2) {
                obj.put("status", "fail");
            }
            
            session.setAttribute("userInfo", member);
            
            obj.put("name", member.getName());
            obj.put("status", "success");
        }
        this.member = member;
        return obj;
    }
    
    
    @RequestMapping(value="/islogin")
    public String isLogin(HttpSession session, HttpServletRequest request) {
        if(this.member != null)
            try {
                return URLEncoder.encode(this.member.getName(), "UTF-8"); 
            } catch(Exception e) {
                return "n";
            }
        else
            return "n";
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
