package com.tp.marketplace.dto;

public class CropDTO {

    private Integer cropId;
    private String cropName;

    // Constructors
    public CropDTO() {}

    public CropDTO(Integer cropId, String cropName) {
        this.cropId = cropId;
        this.cropName = cropName;
    }

    // Getters and Setters
    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }
}
