package com.cian.ddd.domain.orgmng.validator;


import com.cian.ddd.domain.common.exception.BusinessException;
import com.cian.ddd.domain.orgmng.Org;
import com.cian.ddd.domain.orgtype.OrgType;
import org.springframework.stereotype.Component;

@Component
public class SuperiorValidator {


    // 上级组织应该是有效组织
    public Org shouldEffective(Long tenant, Long superior, String orgTypeCode) {
        return null;
    }

    public OrgType orgTypeShouldEffective(Long tenant, Long superior, Org superiorOrg) {
        return null;
    }

    // 开发中心和直属部门的上级只能是企业
    public void ofDevCenterAndDirectDeptMustEntp(Long superior, String orgType, OrgType superiorOrgType) {

    }

    // 开发组的上级只能是开发中心
    public void ofDevGroupMustDevCenter(Long superior, String orgType, OrgType superiorOrgType) {
        if ("DEVGRP".equals(orgType) && !"DEVCENT".equals(superiorOrgType.getCode())) {
            throw new BusinessException("开发组的上级(id = '" + superior
                    + "')不是开发中心！");
        }
    }
}
