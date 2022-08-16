create table if not exists company_share
(
    symbol                     varchar(255)   primary key,
    avg_total_volume           bigint         null,
    calculation_price          varchar(255)   null,
    changee                    decimal(19, 2) null,
    change_percent             decimal(19, 2) null,
    close                      bigint         null,
    close_source               varchar(255)   null,
    close_time                 datetime       null,
    company_name               varchar(255)   null,
    currency                   varchar(255)   null,
    delayed_price              decimal(19, 2) null,
    delayed_price_time         datetime       null,
    extended_change            decimal(19, 2) null,
    extended_change_percent    decimal(19, 2) null,
    extended_price             decimal(19, 2) null,
    high_source                varchar(255)   null,
    high_time                  datetime       null,
    iex_ask_price              decimal(19, 2) null,
    iex_ask_size               bigint         null,
    iex_bid_price              decimal(19, 2) null,
    iex_bid_size               bigint         null,
    iex_close                  decimal(19, 2) null,
    iex_close_time             datetime       null,
    iex_last_updated           datetime       null,
    iex_market_percent         decimal(19, 2) null,
    iex_open                   decimal(19, 2) null,
    iex_open_time              datetime       null,
    iex_realtime_price         decimal(19, 2) null,
    iex_realtime_size          bigint         null,
    iex_volume                 bigint         null,
    isusmarket_open            bit            null,
    last_trade_time            datetime       null,
    latest_price               decimal(19, 2) null,
    latest_source              varchar(255)   null,
    latest_time                varchar(255)   null,
    latest_update              datetime       null,
    latest_volume              bigint         null,
    low                        bigint         null,
    low_source                 varchar(255)   null,
    low_time                   datetime       null,
    market_cap                 bigint         null,
    odd_lot_delayed_price      decimal(19, 2) null,
    odd_lot_delayed_price_time datetime       null,
    open                       bigint         null,
    open_source                varchar(255)   null,
    open_time                  datetime       null,
    pe_ratio                   decimal(19, 2) null,
    previous_close             decimal(19, 2) null,
    previous_volume            bigint         null,
    primary_exchange           varchar(255)   null,
    volume                     bigint         null,
    week52high                 decimal(19, 2) null,
    week52low                  decimal(19, 2) null,
    ytd_change                 decimal(19, 2) null
);