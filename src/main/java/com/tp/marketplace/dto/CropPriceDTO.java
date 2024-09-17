package com.tp.marketplace.dto;

import java.time.LocalDate;

public class CropPriceDTO {

    private Integer priceId;
    private Integer cropId;
    private Integer marketplaceId;
    private Float price;
    private Float priceHighest;
    private Float priceLowest;
    private LocalDate date;

    // Constructors
    public CropPriceDTO() {}

    public CropPriceDTO(Integer cropId, Integer marketplaceId, Float price, LocalDate date) {
        this.cropId = cropId;
        this.marketplaceId = marketplaceId;
        this.price = price;
        this.date = date;
    }
    public CropPriceDTO(Integer cropId, Integer marketplaceId, Float price, LocalDate date,Float priceHighest,Float priceLowest) {
        this.cropId = cropId;
        this.marketplaceId = marketplaceId;
        this.price = price;
        this.date = date;
        this.priceHighest=priceHighest;
        this.priceLowest=priceLowest;
    }


    // Getters and Setters
    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(Integer marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	public Float getPriceHighest() {
		return priceHighest;
	}

	public void setPriceHighest(Float priceHighest) {
		this.priceHighest = priceHighest;
	}

	public Float getPriceLowest() {
		return priceLowest;
	}

	public void setPriceLowest(Float priceLowest) {
		this.priceLowest = priceLowest;
	}

	@Override
	public String toString() {
		return "CropPriceDTO [priceId=" + priceId + ", cropId=" + cropId + ", marketplaceId=" + marketplaceId
				+ ", price=" + price + ", priceHighest=" + priceHighest + ", priceLowest=" + priceLowest + ", date="
				+ date + "]";
	}
    
}
