// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.ContentDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Content;
import bitcamp.java106.pms.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
    
    ContentDao contentDao;
    
    public ContentServiceImpl(ContentDao contentDao) {
        this.contentDao = contentDao;
    }
    
    @Override
    public List<Content> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return contentDao.selectList(params);
    }
    
    @Override
    public Content get(int no) {
        return contentDao.selectOne(no);
    }
    
    @Override
    public int add(Content content) {
        return contentDao.insert(content);
    }
    
    @Override
    public int update(Content content) {
        return contentDao.update(content);
    }
    
    @Override
    public int delete(int no) {
        return contentDao.delete(no);
    }
}

//ver 53 - 클래스 추가






