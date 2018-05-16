package bitcamp.java106.pms.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.server.ServerResponse;

// 새규칙에 따라 기존에 만든 클래스를 사용할 수 있도록
// 중간에서 중계해주는 역할 - Adapter
// => 이런 방식으로 설계하는 것을 "Adapter 패턴" 이라 부른다.
public class ServerResponseAdapter extends ServerResponse {
    HttpServletResponse response;
    public ServerResponseAdapter(HttpServletResponse response) {
        super(null);
        this.response = response;
    }
    @Override
    public PrintWriter getWriter() {
        try {
            return response.getWriter();
        } catch (Exception e) {
            return null;
        }
    }
}
