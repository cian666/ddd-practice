package com.cian.ddd.domain.orgmng.validator;


import org.springframework.stereotype.Component;

@Component
public class OrgLeaderValidator {

    // 组织负责人可以空缺，如果有的话，的必须是一个在职员工（含试用期）
    public void shouldEffective(Long tenant, Long leader) {

    }
}
