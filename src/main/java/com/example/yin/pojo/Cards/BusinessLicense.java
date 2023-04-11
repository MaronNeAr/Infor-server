package com.example.yin.pojo.Cards;

public class BusinessLicense {
    Integer id;

    String businessScope;

    String organizationType;

    String legalPerson;

    String certificateNumber;

    String registerCapital;

    String unitName;

    String validityPeriod;

    String creditCode;

    String paidCapital;

    String approvalDate;

    String establishDate;

    String taxNumber;

    String address;

    String registerAuthority;

    String type;

    Integer uid;

    public BusinessLicense() {
    }

    public BusinessLicense(Integer id, String businessScope, String organizationType, String legalPerson, String certificateNumber, String registerCapital, String unitName, String validityPeriod, String creditCode, String paidCapital, String approvalDate, String establishDate, String taxNumber, String address, String registerAuthority, String type, Integer uid) {
        this.id = id;
        this.businessScope = businessScope;
        this.organizationType = organizationType;
        this.legalPerson = legalPerson;
        this.certificateNumber = certificateNumber;
        this.registerCapital = registerCapital;
        this.unitName = unitName;
        this.validityPeriod = validityPeriod;
        this.creditCode = creditCode;
        this.paidCapital = paidCapital;
        this.approvalDate = approvalDate;
        this.establishDate = establishDate;
        this.taxNumber = taxNumber;
        this.address = address;
        this.registerAuthority = registerAuthority;
        this.type = type;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(String registerCapital) {
        this.registerCapital = registerCapital;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterAuthority() {
        return registerAuthority;
    }

    public void setRegisterAuthority(String registerAuthority) {
        this.registerAuthority = registerAuthority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "BussinessLiense{" +
                "id=" + id +
                ", businessScope='" + businessScope + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", registerCapital='" + registerCapital + '\'' +
                ", unitName='" + unitName + '\'' +
                ", validityPeriod='" + validityPeriod + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", paidCapital='" + paidCapital + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                ", establishDate='" + establishDate + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", address='" + address + '\'' +
                ", registerAuthority='" + registerAuthority + '\'' +
                ", type='" + type + '\'' +
                ", uid=" + uid +
                '}';
    }
}
