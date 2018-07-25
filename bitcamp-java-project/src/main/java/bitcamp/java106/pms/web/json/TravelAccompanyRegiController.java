
package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.TravelAccompanyRegi;
import bitcamp.java106.pms.service.TravelAccompanyRegiService;

@RestController
@RequestMapping("/accompanyregi")
public class TravelAccompanyRegiController {
    
    TravelAccompanyRegiService travelAccompanyRegiService;
    
    public TravelAccompanyRegiController(TravelAccompanyRegiService travelAccompanyRegiService) {
        this.travelAccompanyRegiService = travelAccompanyRegiService;
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {
                
        return travelAccompanyRegiService.list(pageNo, pageSize);
    }
    
    @RequestMapping("list/{no}")
    public TravelAccompanyRegi selectOne(@PathVariable int no) {
        
        return travelAccompanyRegiService.selectOne(no);
    } 
    
    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public int add(TravelAccompanyRegi travelAccompanyRegi) throws Exception {
        System.out.println(travelAccompanyRegi);
        System.out.println("ctrl");
        return travelAccompanyRegiService.add(travelAccompanyRegi);
    }
}