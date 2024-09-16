package com.tp.marketplace.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crop_prices")
public class CropPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id", nullable = false)
    private Marketplace marketplace;

    @Column(name = "price", nullable = false)
    private Float price;
    
    @Column(name = "price_highest", nullable = true)
    private Float priceHighest;
    
    @Column(name = "price_lowest", nullable = true)
    private Float priceLowest;

    @Column(name = "date", nullable = false)
    private LocalDate date;

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
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
	
    // Getters and Setters
    // Constructors
    
}
