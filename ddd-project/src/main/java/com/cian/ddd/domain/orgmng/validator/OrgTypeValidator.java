package com.cian.ddd.domain.orgmng.validator;


import com.cian.ddd.domain.common.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class OrgTypeValidator {


    // 组织类别不能为空
    public void shouldNotEmpty(String orgType) {
    }

    // 组织类别必须有效
    public void shouldEffective(Long tenant, String orgType) {

    }

    // 企业是在创建租户的时候创建好的，因此不能单独创建企业
    public void shouldNotEntp(String orgType) {
        if ("ENTP".equals(orgType)) {
            throw new BusinessException("企业是在创建租户的时候创建好的，因此不能单独创建企业!");
        }
    }

}
