// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.SNSMemberDao;
import bitcamp.java106.pms.domain.SNSMember;
import bitcamp.java106.pms.service.SNSMemberService;

@Service
public class SNSMemberServiceImpl implements SNSMemberService {
    
    SNSMemberDao SnsMemberDao;
    
    public SNSMemberServiceImpl(SNSMemberDao SnsMemberDao) {
        this.SnsMemberDao = SnsMemberDao;
    }
    
    @Override
    public SNSMember get(String id) {
        return SnsMemberDao.selectOne(id);
    }
    
    @Override
    public boolean isExist(String id, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        
        return SnsMemberDao.count(params) > 0 ? true : false;
    }
    
    @Override
    public int add(SNSMember SnsMember) {
        return SnsMemberDao.insert(SnsMember);
    }
    
    @Override
    public int update(SNSMember SnsMember) {
        return SnsMemberDao.update(SnsMember);
    }
    
    @Override
    public int delete(String id) {
        return SnsMemberDao.delete(id);
    }
}

//ver 53 - 클래스 추가






