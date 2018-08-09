// 서비스 컴포넌트 - 회원관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import bitcamp.java106.pms.domain.SNSMember;

public interface SNSMemberService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!
    SNSMember get(String id);
    boolean isExist(String id, String password);
    int add(SNSMember SnsMember);
    int update(SNSMember SnsMember);
    int delete(String id);
}

//ver 53 - 인터페이스 추가







