package com.cian.ddd.domain.orgtype;

public interface OrgTypeRepository {
    boolean existsByCodeAndStatus(long tenant, String code, OrgTypeStatus status);
}
