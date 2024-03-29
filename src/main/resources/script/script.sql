create table SettleDetail
(
    id      bigint auto_increment
        primary key,
    customerId bigint null,
    serviceId  bigint null,
    count      bigint null,
    fee        bigint null,
    targetDate bigint null
);

create table SettleGroup
(
    id      bigint auto_increment
        primary key,
    customerId bigint null,
    serviceId  bigint null,
    totalCount bigint null,
    totalFee   bigint null,
    createAt   datetime null
);