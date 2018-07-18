// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelLogContentDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.service.TravelLogContentService;

@Service
public class TravelLogContentImpl implements TravelLogContentService {
    
	TravelLogContentDao travelLogContentDao;
    
    public TravelLogContentImpl(TravelLogContentDao travelLogContentDao) {
        this.travelLogContentDao = travelLogContentDao;
    }
    
    @Override
    public int list(int tlno) {
        
        return travelLogContentDao.selectList(tlno);
    }
    
    @Override
    public Task get(int no) {
        return taskDao.selectOne(no);
    }
    
    @Override
    public int add(Task task) {
        return taskDao.insert(task);
    }
    
    @Override
    public int update(Task task) {
        return taskDao.update(task);
    }
    
    @Override
    public int delete(int no) {
        return taskDao.delete(no);
    }
}

//ver 53 - 클래스 추가






