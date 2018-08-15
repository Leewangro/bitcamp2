package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Planner;
import bitcamp.java106.pms.service.PlannerService;

@RestController
@RequestMapping("/planner")
public class PlannerController {
    
    PlannerService plannerService;
    
    public PlannerController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }

    @RequestMapping("form")
    public void form() {
    }
    
    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(Planner planner) throws Exception {
        plannerService.add(planner);
        return planner.getNo();
    }
    
    @RequestMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam("no") int no) throws Exception {
        plannerService.delete(no);
    }
    
    @RequestMapping("list")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="10") int pageSize) {
        
        return plannerService.list(pageNo, pageSize);
    }
    @RequestMapping("list{page}")
    public Object listwithPage(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="6") int pageSize) {
                
        return plannerService.listwithPage(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // 기본 값이 OK 이다.
    public void update(Planner planner) throws Exception {
        plannerService.update(planner);
    }
    
    @RequestMapping("{no}")
    public Planner view(@PathVariable int no) throws Exception {
        return plannerService.get(no);
        
    }
}