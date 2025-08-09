package com.tests;

/**
 * @author tasahu
 */

public class PublicEntityMergeElement {
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSourcePKey() {
        return sourcePKey;
    }

    public void setSourcePKey(String sourcePKey) {
        this.sourcePKey = sourcePKey;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    @Override
    public String toString() {
        return "PublicEntityMergeElement{" +
                "businessId='" + businessId + '\'' +
                ", sourcePKey='" + sourcePKey + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                '}';
    }

    private String businessId;

    public PublicEntityMergeElement(String businessId, String sourcePKey, String sourceSystem) {
        this.businessId = businessId;
        this.sourcePKey = sourcePKey;
        this.sourceSystem = sourceSystem;
    }

    private String sourcePKey;

    private String sourceSystem;
}
