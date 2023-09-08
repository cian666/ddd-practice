package com.cian.ddd.domain.orgmng.validator;


import org.springframework.stereotype.Component;

@Component
public class OrgNameValidator {

    // 组织必须有名称
    public void shouldNotEmpty(String name) {
    }

    public void shouldNotDuplicatedInSameSuperior(Long tenant, String name, Long superiorId) {
    }
}
