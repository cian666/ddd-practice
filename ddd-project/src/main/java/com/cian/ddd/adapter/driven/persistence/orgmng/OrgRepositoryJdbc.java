package com.cian.ddd.adapter.driven.persistence.orgmng;

import com.cian.ddd.domain.orgmng.Org;
import com.cian.ddd.domain.orgmng.OrgRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrgRepositoryJdbc implements OrgRepository {

    @Override
    public Org save(Org org) {
        log.info("执行保存：{}",org);
        return null;
    }
}
