// 서비스 컴포넌트 - 팀관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import bitcamp.java106.pms.domain.TravelAccompany;

public interface TravelAccompanyService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!

    TravelAccompany get(String name);

    TravelAccompany list(int pageNo, int pageSize);
    
}

//ver 53 - 인터페이스 추가







