-- begin BROOKLYN_REO_PROPERTIES
create table BROOKLYN_REO_PROPERTIES (
    ID integer,
    UUID varchar(32),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    --
    ADDRESS varchar(100),
    PARCEL_NUMBER varchar(15),
    CITY_STATE_ZIP varchar(100),
    LIST_PRICE integer,
    YEAR_BUILT integer,
    LL_ID integer,
    NUMBER_OF_UNITS integer,
    STYLE varchar(50),
    EST_SIZE integer,
    STATUS varchar(10),
    ZPID varchar(15),
    ZILLOW_URL varchar(100),
    COUNTY_SITE_URL varchar(100),
    TAX_ASSESSOR_LINK varchar(255),
    TAX_COLLECTOR_LINK varchar(255),
    --
    primary key (ID)
)^
-- end BROOKLYN_REO_PROPERTIES
