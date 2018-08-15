// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelPlanDao;
import bitcamp.java106.pms.domain.TravelPlan;
import bitcamp.java106.pms.service.TravelPlanService;

@Service
public class TravelPlanServiceImpl implements TravelPlanService {
    
    TravelPlanDao travelPlanDao;
    
    public TravelPlanServiceImpl(TravelPlanDao travelPlanDao) {
        this.travelPlanDao = travelPlanDao;
    }
    
    @Override
    public List<TravelPlan> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return travelPlanDao.selectList(params);
    }
    
    @Override
    public List<TravelPlan> get(int planno, int no) {
       Map<String, Object> params = new HashMap<>();
       params.put("plno", planno);
       params.put("dayno", no);
       
        return travelPlanDao.selectListWithPlan(params);
    }
    
    @Override
    public int get2(int planno) {
       Map<String, Object> params = new HashMap<>();
       params.put("plno", planno);
        return travelPlanDao.selectListWithPlanDay(params);
    }
    
    @Override
    public int add(TravelPlan travelPlan) {
        return travelPlanDao.insert(travelPlan);
    }
    @Override
    public int add2(TravelPlan travelPlan) {
        return travelPlanDao.insert2(travelPlan);
    }
    
    @Override
    public int update(int planday, int no, String text) {
        
        System.out.println(planday);
        System.out.println(no);
        System.out.println(text);
        
        Map<String, Object> params = new HashMap<>();
        params.put("plno", planday);
        params.put("tno", no);
        params.put("descr", text);
        
        int lines = travelPlanDao.update(params);
        System.out.println("변경된 행 : " + lines);
        
        return lines;
    }
    
    @Override
    public int delete(int no) {
        return travelPlanDao.delete(no);
    }
    @Override
    public List<TravelPlan> selectOne(int no) {
        return travelPlanDao.selectOne(no);
    }

    @Override
    public int update(TravelPlan travelPlan) {
        // TODO Auto-generated method stub
        return 0;
    }
}

//ver 53 - 클래스 추가