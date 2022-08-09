package com.example.entity;

/**
 * @author zhoupeng
 * @create time 2021-05-06-15:31
 */
public class ConsumeData {
    private String type;
    private String sampleId;
    private String alias;
    private String sdcId;
    private String productType;
    private String sampleType;
    private String paramlistid;
    private String dataset;
    private String notes;
    private String copySign;


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSampleId() {
        return sampleId;
    }
    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getSdcId() {
        return sdcId;
    }
    public void setSdcId(String sdcId) {
        this.sdcId = sdcId;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getSampleType() {
        return sampleType;
    }
    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }
    public String getParamlistid() {
        return paramlistid;
    }
    public void setParamlistid(String paramlistid) {
        this.paramlistid = paramlistid;
    }
    public String getDataset() {
        return dataset;
    }
    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCopySign() {
        return copySign;
    }
    public void setCopySign(String copySign) {
        this.copySign = copySign;
    }
    @Override
    public String toString() {
        return "notes=" + notes +  ", type=" + type + ", sampleId=" + sampleId + ", alias=" + alias + ", sdcId=" + sdcId
                + ", productType=" + productType + ", sampleType=" + sampleType + ", paramlistid=" + paramlistid
                + ", dataset=" + dataset + ", copySign=" + copySign +  "";
    }

}
