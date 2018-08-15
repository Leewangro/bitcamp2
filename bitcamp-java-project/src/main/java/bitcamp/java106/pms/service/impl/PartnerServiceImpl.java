package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.PartnerDao;
import bitcamp.java106.pms.domain.Partner;
import bitcamp.java106.pms.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {
    
    PartnerDao partnerDao;
    
    public PartnerServiceImpl(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }
    
    @Override
    public List<Partner> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return partnerDao.selectList(params);
    }
    
    @Override
    public List<Partner> listwithPage(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return partnerDao.selectListwithPage(params);
    }
    
    @Override
    public Partner get(int no) {
        return partnerDao.selectOne(no);
    }
     
    @Override
    public int add(Partner partner) {
        return partnerDao.insert(partner);
    }
    
    @Override
    public int update(Partner partner) {
        return partnerDao.update(partner);
    }
    
    @Override
    public int delete(int no) {
        return partnerDao.delete(no);
    }
}

//ver 53 - 클래스 추가