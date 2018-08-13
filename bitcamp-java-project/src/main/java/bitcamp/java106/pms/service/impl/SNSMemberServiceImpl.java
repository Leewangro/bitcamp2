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
    public boolean isExist(String id) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        
        return SnsMemberDao.count(params) > 0 ? true : false;
    }
    
    @Override
    public void add(SNSMember SnsMember) {
        SnsMemberDao.insert(SnsMember);
    }
    
    // @Override
    // public void update(SNSMember SnsMember) {
    //     SnsMemberDao.update(SnsMember);
    // }
    
    // @Override
    // public String delete(String id) {
    //     return SnsMemberDao.delete(id);
    // }
}

//ver 53 - 클래스 추가






