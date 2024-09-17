package com.tp.marketplace.dto;

import java.time.LocalDate;

public class CropPriceWithNameDTO {
	 private String cropName;
	    private String marketplaceName;
	    private Float price;
	    private LocalDate date;
	    private Float priceHighest;
	    private Float priceLowest;
	    // Constructors, getters, and setters

	    public CropPriceWithNameDTO(String cropName, String marketplaceName, Float price, LocalDate date) {
	        this.cropName = cropName;
	        this.marketplaceName = marketplaceName;
	        this.price = price;
	        this.date = date;
	    }
	    public CropPriceWithNameDTO(String cropName, String marketplaceName, Float price, LocalDate date,Float priceHighest,Float priceLowest) {
	        this.cropName = cropName;
	        this.marketplaceName = marketplaceName;
	        this.price = price;
	        this.date = date;
	        this.priceHighest = priceHighest;
	        this.priceLowest = priceLowest;
	    }

		public String getCropName() {
			return cropName;
		}

		public void setCropName(String cropName) {
			this.cropName = cropName;
		}

		public String getMarketplaceName() {
			return marketplaceName;
		}

		public void setMarketplaceName(String marketplaceName) {
			this.marketplaceName = marketplaceName;
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
	    
    
}
