package com.company.brooklyn.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.Updatable;
import java.util.Date;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;

@Table(name = "BROOKLYN_REO_PROPERTIES")
@Entity(name = "brooklyn$REOProperties")
public class REOProperties extends BaseIntegerIdEntity implements Updatable, HasUuid {
    private static final long serialVersionUID = 956077411938863166L;

    @Column(name = "ADDRESS", length = 100)
    protected String address;

    @Column(name = "PARCEL_NUMBER", length = 15)
    protected String parcelNumber;

    @Column(name = "CITY_STATE_ZIP", length = 100)
    protected String cityStateZip;

    @Column(name = "LIST_PRICE")
    protected Integer listPrice;

    @Column(name = "YEAR_BUILT")
    protected Integer yearBuilt;

    @Column(name = "LL_ID")
    protected Integer llId;

    @Column(name = "NUMBER_OF_UNITS")
    protected Integer numberOfUnits;

    @Column(name = "STYLE")
    protected String style;

    @Column(name = "EST_SIZE")
    protected Integer estSize;

    @Column(name = "STATUS", length = 10)
    protected String status;

    @Column(name = "ZPID", length = 15)
    protected String zpid;

    @Column(name = "ZILLOW_URL", length = 100)
    protected String zillowUrl;

    @Column(name = "COUNTY_SITE_URL", length = 100)
    protected String countySiteUrl;

    @Column(name = "TAX_ASSESSOR_LINK")
    protected String taxAssessorLink;

    @Column(name = "TAX_COLLECTOR_LINK")
    protected String taxCollectorLink;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

    @Column(name = "UUID")
    private UUID uuid;

    public void setStyle(PropertyStyle style) {
        this.style = style == null ? null : style.getId();
    }

    public PropertyStyle getStyle() {
        return style == null ? null : PropertyStyle.fromId(style);
    }

    public void setEstSize(Integer estSize) {
        this.estSize = estSize;
    }

    public Integer getEstSize() {
        return estSize;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setZpid(String zpid) {
        this.zpid = zpid;
    }

    public String getZpid() {
        return zpid;
    }

    public void setZillowUrl(String zillowUrl) {
        this.zillowUrl = zillowUrl;
    }

    public String getZillowUrl() {
        return zillowUrl;
    }

    public void setCountySiteUrl(String countySiteUrl) {
        this.countySiteUrl = countySiteUrl;
    }

    public String getCountySiteUrl() {
        return countySiteUrl;
    }

    public void setTaxAssessorLink(String taxAssessorLink) {
        this.taxAssessorLink = taxAssessorLink;
    }

    public String getTaxAssessorLink() {
        return taxAssessorLink;
    }

    public void setTaxCollectorLink(String taxCollectorLink) {
        this.taxCollectorLink = taxCollectorLink;
    }

    public String getTaxCollectorLink() {
        return taxCollectorLink;
    }


    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setCityStateZip(String cityStateZip) {
        this.cityStateZip = cityStateZip;
    }

    public String getCityStateZip() {
        return cityStateZip;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setLlId(Integer llId) {
        this.llId = llId;
    }

    public Integer getLlId() {
        return llId;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }


}