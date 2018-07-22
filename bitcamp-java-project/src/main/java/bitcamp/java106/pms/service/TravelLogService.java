// 서비스 컴포넌트 - 팀관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.TravelLog;

public interface TravelLogService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!
    List<TravelLog> list(int pageNo, int pageSize);
//    TravelLog get(String name);
//    int add(TravelLog team);
//    int update(TravelLog team);
//    int delete(int tlno);
//    int addContent(String title, String memberId);
//    int deleteMember(String teamName, String memberId);
//    List<Member> getMembersWithEmail(String teamName);
}

//ver 53 - 인터페이스 추가







