// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.HashTagDao;
import bitcamp.java106.pms.domain.HashTag;
import bitcamp.java106.pms.service.HashTagService;

@Service
public class HashTagServiceImpl implements HashTagService {
    
    HashTagDao hashTagDao;
    
    public HashTagServiceImpl(HashTagDao hashTagDao) {
        this.hashTagDao = hashTagDao;
    }
    
    @Override
    public List<HashTag> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return hashTagDao.selectList(params);
    }
    
    @Override
    public int add(HashTag hashTag) {
        return hashTagDao.insert(hashTag);
    }
    
    @Override
    public int update(HashTag hashTag) {
        return hashTagDao.update(hashTag);
    }
    
    @Override
    public int delete(int no) {
        return hashTagDao.delete(no);
    }
    @Override
    public List<HashTag> selectOne(int no) {
        return hashTagDao.selectOne(no);
    }
}

//ver 53 - 클래스 추가





