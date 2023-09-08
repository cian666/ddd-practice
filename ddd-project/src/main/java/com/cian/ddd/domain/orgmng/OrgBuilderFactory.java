package com.cian.ddd.domain.orgmng;

import com.cian.ddd.domain.common.validator.CommonValidator;
import com.cian.ddd.domain.orgmng.validator.OrgLeaderValidator;
import com.cian.ddd.domain.orgmng.validator.OrgNameValidator;
import com.cian.ddd.domain.orgmng.validator.OrgTypeValidator;
import com.cian.ddd.domain.orgmng.validator.SuperiorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgBuilderFactory {
    private CommonValidator commonValidator;
    private OrgTypeValidator orgTypeValidator;
    private SuperiorValidator superiorValidator;
    private OrgNameValidator orgNameValidator;
    private OrgLeaderValidator orgLeaderValidator;


    public OrgBuilderFactory(CommonValidator commonValidator
            , OrgTypeValidator orgTypeValidator
            , SuperiorValidator superiorValidator
            , OrgNameValidator orgNameValidator
            , OrgLeaderValidator orgLeaderValidator) {

        this.commonValidator = commonValidator;
        this.orgTypeValidator = orgTypeValidator;
        this.superiorValidator = superiorValidator;
        this.orgNameValidator = orgNameValidator;
        this.orgLeaderValidator = orgLeaderValidator;
    }

    public OrgBuilder create() {
        return new OrgBuilder(commonValidator
                , orgTypeValidator
                , superiorValidator
                , orgNameValidator
                , orgLeaderValidator);
    }

}
