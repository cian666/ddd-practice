package com.cian.ddd.adapter.driving.restful.orgmng;


import com.cian.ddd.application.orgmng.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {


    private final OrgService orgService;
    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }
    @PostMapping("/api/organizations")
    public OrgDto addOrg(@RequestBody OrgDto request) {
        //从请求里解析出 userId ...
        String userId = "demo";
        return orgService.addOrg(request, userId);
    }

}
