// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TourDao;
import bitcamp.java106.pms.domain.Tour;
import bitcamp.java106.pms.service.TourService;

@Service
public class TourServiceImpl implements TourService {
    
    TourDao tourDao;
    
    public TourServiceImpl(TourDao tourDao) {
        this.tourDao = tourDao;
    }
    
    @Override
    public List<Tour> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return tourDao.selectList(params);
    }
    
    @Override
    public Tour get(int no) {
        return tourDao.selectOne(no);
    }
    
    @Override
    public int add(Tour tour) {
        return tourDao.insert(tour);
    }
    
    @Override
    public int update(Tour tour) {
        return tourDao.update(tour);
    }
    
    @Override
    public int delete(int no) {
        return tourDao.delete(no);
    }
}

//ver 53 - 클래스 추가






