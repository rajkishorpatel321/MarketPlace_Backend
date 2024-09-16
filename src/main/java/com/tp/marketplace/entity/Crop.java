package com.tp.marketplace.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cropId;

    @Column(name = "crop_name", nullable = false)
    private String cropName;

    // One crop can have many price records
    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CropPrice> cropPrices;

    

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

	public List<CropPrice> getCropPrices() {
		return cropPrices;
	}

	public void setCropPrices(List<CropPrice> cropPrices) {
		this.cropPrices = cropPrices;
	}

    // Getters and Setters
    // Constructors
}

