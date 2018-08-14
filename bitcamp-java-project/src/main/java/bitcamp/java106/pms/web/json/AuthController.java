// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.web.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import bitcamp.java106.pms.dao.SNSMemberDao;
import bitcamp.java106.pms.domain.SNSMember;

@RestController
@RequestMapping("/auth")
public class AuthController {

    SNSMemberDao snsMemberDao;
    SNSMember member;
    
    public AuthController(SNSMemberDao snsMemberDao) {
        // TODO Auto-generated constructor stub
        this.snsMemberDao = snsMemberDao;
        this.member = null;
    }
    
    @RequestMapping("/logout")
    public void logout(HttpSession session) throws Exception {
        System.out.println("invalidate");
        session.invalidate();
        this.member = null;
    }
    
    @GetMapping("/facebookLogin")
    public Object facebookLogin(String accessToken, HttpServletResponse response, HttpSession session) throws Exception {
    	Map<String, Object> obj = new HashMap<>();
        String id="", name="", email="", gender="", picurl="";
        SNSMember member = new SNSMember();
            
            URL url = new URL("https://graph.facebook.com/v3.1/me?fields=id,name,email,gender,picture&access_token=" + accessToken);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            
            StringBuffer buf = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                buf.append(line);
            }
            in.close();
            
            String jsonResult = StringEscapeUtils.unescapeJson(buf.toString());
            ObjectMapper mapper = new ObjectMapper();
            Map facebookMap = mapper.readValue(jsonResult, Map.class);
            
            id = (String)facebookMap.get("id");
            name = (String)facebookMap.get("name");
            email = (String)facebookMap.get("email");
            gender = (String)facebookMap.get("gender");
            Map picture = (Map)facebookMap.get("picture");
            Map picdata = (Map)picture.get("data");
            picurl = (String)picdata.get("url");
            
            
            if(snsMemberDao.selectOne(id) == null) {
                member.setId(id);
                member.setName(name);
                member.setEmail(email);
                member.setGender(gender);
                member.setProfileImg(picurl);
                session.setAttribute("userInfo", member);
                try {
                    snsMemberDao.insert(member);
                    } catch(Exception e2 ) {                    
                        return "fail";
                    }
                    obj.put("name", member.getName());
                    obj.put("status", "success");
                    return obj;
            } else 
            member = snsMemberDao.selectOne(id);
            session.setAttribute("userInfo", member);
            System.out.println(session.getAttribute("userInfo"));
            obj.put("name", member.getName());
            obj.put("id", member.getId());
            obj.put("status", "success");
            this.member = member;
            return obj;
    }
    
    @GetMapping("/kakaoLogin")
    public Object kakaoLogin(String accessToken, HttpServletResponse response, HttpSession session) {
        Map<String, Object> obj = new HashMap<>();
        String id="", name="", email="", gender="", picurl="";
        SNSMember member = new SNSMember();
        
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
            System.out.println(jsonResult);
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
            
        } catch (Exception e ) {
            System.out.println(email);
            member.setId(id);
            member.setName(name);
            member.setEmail(gender);
            member.setEmail(email);
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
            obj.put("id", member.getId());
        }
        return obj;
    }
    
    @RequestMapping(value="/islogin")
    public Object isLogin(HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        if(this.member != null)
            try {
                map.put("id", URLEncoder.encode(this.member.getId(), "UTF-8"));
                map.put("name", URLEncoder.encode(this.member.getName(), "UTF-8")); 
                return map;
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
