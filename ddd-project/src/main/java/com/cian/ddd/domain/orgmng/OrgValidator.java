package com.cian.ddd.domain.orgmng;

import com.cian.ddd.adapter.driving.restful.orgmng.OrgDto;
import com.cian.ddd.domain.common.validator.CommonValidator;
import com.cian.ddd.domain.orgmng.validator.OrgLeaderValidator;
import com.cian.ddd.domain.orgmng.validator.OrgNameValidator;
import com.cian.ddd.domain.orgmng.validator.OrgTypeValidator;
import com.cian.ddd.domain.orgmng.validator.SuperiorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgValidator {
    //依赖更小的 Validator，也就是更小的规则分组
    private CommonValidator commonValidator;
    private OrgTypeValidator orgTypeValidator;
    private SuperiorValidator superiorValidator;
    private OrgNameValidator orgNameValidator;
    private OrgLeaderValidator orgLeaderValidator;

    @Autowired
    public OrgValidator(CommonValidator commonValidator
            , OrgTypeValidator orgTypeValidator
            , SuperiorValidator superiorValidator
            , OrgNameValidator orgNameValidator
            , OrgLeaderValidator orgLeaderValidator) {
        // 为依赖注入的组件赋值...
    }

    public void validate(OrgDto request) {
        final Long tenant = request.getTenantId();
        commonValidator.shouldEffective(tenant);
        orgLeaderValidator.shouldEffective(tenant, request.getTenantId());
        orgTypeValidator.shouldEffective(tenant, request.getOrgTypeCode());
        superiorValidator.shouldEffective(tenant, request.getSuperiorId(), request.getOrgTypeCode());
        orgNameValidator.shouldNotDuplicatedInSameSuperior(tenant, request.getName(), request.getSuperiorId());
    }
}
