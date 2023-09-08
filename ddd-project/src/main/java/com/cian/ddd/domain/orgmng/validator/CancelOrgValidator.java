package com.cian.ddd.domain.orgmng.validator;


import com.cian.ddd.domain.orgmng.Org;
import org.springframework.stereotype.Component;

@Component
public class CancelOrgValidator {


    // 要被撤销的组织不能有下属员工
    public void shouldNotHasEmp(Long tenant, Long id) {

    }

    // 只有有效组织才能被撤销
    public void shouldEffective(Org org) {

    }
}
