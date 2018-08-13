// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelLogDao;
import bitcamp.java106.pms.domain.TravelLog;
import bitcamp.java106.pms.service.TravelLogService;

@Service
public class TravelLogServiceImpl implements TravelLogService {
    
    TravelLogDao travelLogDao;
    
    public TravelLogServiceImpl(TravelLogDao travelLogDao) {
        this.travelLogDao = travelLogDao;
    }
    
    @Override
    public List<TravelLog> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return travelLogDao.selectList(params);
    }
    
    @Override
    public List<TravelLog> listwithPage(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return travelLogDao.selectListwithPage(params);
    }
    
    @Override
    public TravelLog get(int no) {
        return travelLogDao.selectOne(no);
    }
    
    @Override
    public int add(TravelLog travelLog) {
        return travelLogDao.insert(travelLog);
    }
    
    @Override
    public int update(TravelLog travelLog) {
        return travelLogDao.update(travelLog);
    }
    
    @Override
    public int delete(int no) {
        return travelLogDao.delete(no);
    }
}

//ver 53 - 클래스 추가






