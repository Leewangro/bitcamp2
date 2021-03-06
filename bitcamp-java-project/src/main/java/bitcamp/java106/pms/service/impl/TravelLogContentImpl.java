// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TravelLogContentDao;
import bitcamp.java106.pms.domain.TravelLogContent;
import bitcamp.java106.pms.service.TravelLogContentService;

@Service
public class TravelLogContentImpl implements TravelLogContentService {

    TravelLogContentDao travelLogContentDao;

    public TravelLogContentImpl(
            TravelLogContentDao travelLogContentDao) {
        this.travelLogContentDao = travelLogContentDao;
    }

    @Override
    public List<TravelLogContent> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);

        return travelLogContentDao.selectList(params);
    }
    

    @Override
    public List<TravelLogContent> get(int no) {
        return travelLogContentDao.selectListWithNo(no);
    }
        
//    @Override
//    public Team getWithMembers(String name) {
//        return teamDao.selectOneWithMembers(name);
//    }
//    
    @Override
    public int add(TravelLogContent travelLogContent) {
        return travelLogContentDao.insert(travelLogContent);
    }
//    
//    @Override
//    public int update(Team member) {
//        return teamDao.update(member);
//    }
//    
//    @Override
//    public int delete(String name) {
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("teamName", name);
//        
//        teamMemberDao.delete(params);
//        taskDao.deleteByTeam(name);
//        return teamDao.delete(name);
//    }
//    
//    @Override
//    public boolean isMember(String teamName, String memberId) {
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("teamName", teamName);
//        params.put("memberId", memberId);
//        
//        return teamMemberDao.isExist(params);
//    }
//    
//    @Override
//    public int addMember(String teamName, String memberId) {
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("teamName", teamName);
//        params.put("memberId", memberId);
//        
//        return teamMemberDao.insert(params);
//    }
//    
//    @Override
//    public int deleteMember(String teamName, String memberId) {
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("teamName", teamName);
//        params.put("memberId", memberId);
//        
//        return teamMemberDao.delete(params);
//    }
//    
//    @Override
//    public List<Member> getMembersWithEmail(String teamName) {
//        return teamMemberDao.selectListWithEmail(teamName);
//    }
}

//ver 53 - 클래스 추가






