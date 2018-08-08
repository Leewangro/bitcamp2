package bitcamp.java106.pms.web.json;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Content;
import bitcamp.java106.pms.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {
    
    ContentService contentService;
    
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    public Object add(Content content) throws Exception {
        contentService.add(content);
        return content.getNo();
    }
    
    @RequestMapping("delete")
    public int delete(@RequestParam("no") int no) throws Exception {
        
        return contentService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public List<Content> list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize,
            Map<String,Object> map) {        
        
        
        return contentService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    public int update(Content content) throws Exception {
        
        return contentService.update(content);
    }
    
    @RequestMapping("{no}")
    public Content view(
            @PathVariable int no, 
            Map<String,Object> map) throws Exception {
        
        return contentService.get(no);
    }

}

//ver 53 - DAO 대신 Service 객체 사용
//ver 52 - InternalResourceViewResolver 적용
//         *.do 대신 /app/* 을 기준으로 URL 변경
//         페이지 관련 파라미터에 matrix variable 적용
//ver 51 - Spring WebMVC 적용
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 






