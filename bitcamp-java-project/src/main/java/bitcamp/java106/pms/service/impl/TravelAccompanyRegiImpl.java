package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelAccompanyRegiDao;
import bitcamp.java106.pms.domain.TravelAccompanyRegi;
import bitcamp.java106.pms.service.TravelAccompanyRegiService;

@Service
public class TravelAccompanyRegiImpl implements TravelAccompanyRegiService {
    
    TravelAccompanyRegiDao tavelAccompanyRegiDao;
    
    public TravelAccompanyRegiImpl(TravelAccompanyRegiDao tavelAccompanyRegiDao) {
        this.tavelAccompanyRegiDao = tavelAccompanyRegiDao;
    }

    @Override
    public List<TravelAccompanyRegi> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return tavelAccompanyRegiDao.selectList(params);
    }
 
    @Override
    public TravelAccompanyRegi selectOne(int no) {
        return tavelAccompanyRegiDao.selectOne(no);
    }

    @Override
    public int add(TravelAccompanyRegi travelAccompanyRegi) {
        System.out.println("insert");
        System.out.println(travelAccompanyRegi);
        return tavelAccompanyRegiDao.insert(travelAccompanyRegi);
    }
}