package com.cian.ddd.domain.orgmng;


import com.cian.ddd.domain.common.validator.CommonValidator;
import com.cian.ddd.domain.orgmng.validator.OrgLeaderValidator;
import com.cian.ddd.domain.orgmng.validator.OrgNameValidator;
import com.cian.ddd.domain.orgmng.validator.OrgTypeValidator;
import com.cian.ddd.domain.orgmng.validator.SuperiorValidator;

import java.time.LocalDateTime;

public class OrgBuilder {
    private CommonValidator commonValidator;
    private OrgTypeValidator orgTypeValidator;
    private SuperiorValidator superiorValidator;
    private OrgNameValidator orgNameValidator;
    private OrgLeaderValidator orgLeaderValidator;

    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private Long createdBy;

    public OrgBuilder(CommonValidator commonValidator,
                      OrgTypeValidator orgTypeValidator,
                      SuperiorValidator superiorValidator,
                      OrgNameValidator orgNameValidator,
                      OrgLeaderValidator orgLeaderValidator) {
    }


    public OrgBuilder tenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public OrgBuilder superiorId(Long superiorId) {
        this.superiorId = superiorId;
        return this;
    }

    public OrgBuilder orgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
        return this;
    }

    public OrgBuilder leaderId(Long leaderId) {
        this.leaderId = leaderId;
        return this;
    }

    public OrgBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OrgBuilder createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Org build() {
        validate();
        Org org = new Org(tenantId, orgTypeCode, LocalDateTime.now(), createdBy);
        org.setLeaderId(this.leaderId);
        org.setName(this.name);
        org.setSuperiorId(this.superiorId);
        return org;
    }

    private void validate() {
        validateOrgTenant();
        validateOrgLeader();
        validateOrgType();
        validateSuperior();
        validateOrgName();
    }

    private void validateOrgLeader() {
        commonValidator.shouldEffective(leaderId);
    }

    private void validateOrgTenant() {
        orgLeaderValidator.shouldEffective(tenantId,leaderId);
    }

    private void validateOrgName() {
        orgNameValidator.shouldNotEmpty(name);
        orgNameValidator.shouldNotDuplicatedInSameSuperior(tenantId, name,superiorId);
    }

    private void validateSuperior() {
        Org superiorOrg = superiorValidator.shouldEffective(tenantId, superiorId,"hahah");
    }

    private void validateOrgType() {
        orgTypeValidator.shouldNotEmpty(orgTypeCode);
    }


}
