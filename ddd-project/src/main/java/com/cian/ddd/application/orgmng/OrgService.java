package com.cian.ddd.application.orgmng;

import com.cian.ddd.adapter.driven.persistence.orgmng.OrgRepositoryJdbc;
import com.cian.ddd.adapter.driving.restful.orgmng.OrgDto;
import com.cian.ddd.domain.orgmng.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OrgService {

    @Resource
    OrgRepository orgRepository;

    @Autowired
    OrgBuilderFactory orgBuilderFactory;


    public OrgDto addOrg(OrgDto request, String userId) {
        OrgBuilder builder = orgBuilderFactory.create();
        Org org = builder.tenantId(request.getTenantId())
                .orgTypeCode(request.getOrgTypeCode())
                .leaderId(request.getLeaderId())
                .superiorId(request.getSuperiorId())
                .name(request.getName())
                .createdBy(111L)
                .build();

        org = orgRepository.save(org);
        return buildOrgDto(org);

    }

    private OrgDto buildOrgDto(Org org) {
        return null;
    }

    private Org buildOrg(OrgDto request, String userId) {
        return null;
    }

    private void validate(OrgDto request, String userId) {

    }
}
