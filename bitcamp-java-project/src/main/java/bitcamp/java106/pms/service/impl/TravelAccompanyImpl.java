// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelAccompanyDao;
import bitcamp.java106.pms.domain.TravelAccompany;
import bitcamp.java106.pms.service.TravelAccompanyService;

@Service
public class TravelAccompanyImpl implements TravelAccompanyService {
    
    TravelAccompanyDao tavelAccompanyDao;
    
    public TravelAccompanyImpl(TravelAccompanyDao tavelAccompanyDao) {
        this.tavelAccompanyDao = tavelAccompanyDao;
    }

    @Override
    public TravelAccompany get(String no) {
        return tavelAccompanyDao.selectOne(no);
    }

    @Override
    public TravelAccompany list(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }
}

//ver 53 - 클래스 추가






