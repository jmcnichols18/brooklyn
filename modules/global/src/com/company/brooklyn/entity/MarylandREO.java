package com.company.brooklyn.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.global.DesignSupport;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@DesignSupport("{'imported':true}")
@Table(name = "MarylandREO")
@Entity(name = "brooklyn$MarylandREO")
public class MarylandREO extends BaseUuidEntity {
    private static final long serialVersionUID = 5600802748942301523L;

    @Column(name = "LL_ID")
    protected Integer ll;

    @Lob
    @Column(name = "Address")
    protected String address;

    @Lob
    @Column(name = "City")
    protected String city;

    @Lob
    @Column(name = "State")
    protected String state;

    @Column(name = "Zip")
    protected Integer zip;

    @Lob
    @Column(name = "County")
    protected String county;

    @Lob
    @Column(name = "Parcel_Number")
    protected String parcelNumber;

    @Column(name = "Assessed_Value")
    protected Integer assessedValue;

    @Column(name = "Est_Size")
    protected Integer estSize;

    @Lob
    @Column(name = "Type")
    protected String type;

    @Lob
    @Column(name = "Style")
    protected String style;

    @Column(name = "Year_Built")
    protected Integer yearBuilt;

    @Column(name = "Number_of_units")
    protected Integer numberOfUnits;

    @Column(name = "List_Price")
    protected Integer listPrice;

    @Lob
    @Column(name = "Status")
    protected String status;

    public void setLl(Integer ll) {
        this.ll = ll;
    }

    public Integer getLl() {
        return ll;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getZip() {
        return zip;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setAssessedValue(Integer assessedValue) {
        this.assessedValue = assessedValue;
    }

    public Integer getAssessedValue() {
        return assessedValue;
    }

    public void setEstSize(Integer estSize) {
        this.estSize = estSize;
    }

    public Integer getEstSize() {
        return estSize;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}