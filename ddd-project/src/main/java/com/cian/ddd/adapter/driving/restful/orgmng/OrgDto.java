package com.cian.ddd.adapter.driving.restful.orgmng;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author haichao.zhang
 * @Date 2023/9/8
 **/
@Data
public class OrgDto {
    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private String status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastUpdatedAt;
    private Long lastUpdatedBy;
}
