package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.TravelAccompanyRegi;

public interface TravelAccompanyRegiDao {
    
    List<TravelAccompanyRegi> selectList(Map<String,Object> params);
    int insert(TravelAccompanyRegi travelAccompanyRegi);
    TravelAccompanyRegi selectOne(int no);
}  