// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.PlannerDao;
import bitcamp.java106.pms.domain.Planner;
import bitcamp.java106.pms.service.PlannerService;

@Service
public class PlannerServiceImpl implements PlannerService {
    
    PlannerDao plannerDao;
    
    public PlannerServiceImpl(PlannerDao plannerDao) {
        this.plannerDao = plannerDao;
    }
    
    @Override
    public List<Planner> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return plannerDao.selectList(params);
    }
    
    @Override
    public Planner get(int no) {
        return plannerDao.selectOne(no);
    }
     
    @Override
    public int add(Planner planner) {
        return plannerDao.insert(planner);
    }
    
    @Override
    public int update(Planner planner) {
        return plannerDao.update(planner);
    }
    
    @Override
    public int delete(int no) {
        return plannerDao.delete(no);
    }
}

//ver 53 - 클래스 추가






