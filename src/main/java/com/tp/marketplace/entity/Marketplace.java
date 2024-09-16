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
@Table(name = "marketplace")
public class Marketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marketplaceId;

    @Column(name = "marketplace_name", nullable = false)
    private String marketplaceName;

    @Column(name = "location", nullable = false)
    private String location;

    // One marketplace can have many crop prices
    @OneToMany(mappedBy = "marketplace", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CropPrice> cropPrices;

	public Integer getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(Integer marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	public String getMarketplaceName() {
		return marketplaceName;
	}

	public void setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
