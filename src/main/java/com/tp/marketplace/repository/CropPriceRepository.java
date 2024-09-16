package com.tp.marketplace.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.marketplace.entity.CropPrice;

@Repository
public interface CropPriceRepository extends JpaRepository<CropPrice, Long> {

	 // Find all crop prices for a particular date in a specific marketplace
    List<CropPrice> findByMarketplace_MarketplaceIdAndDate(Integer marketplaceId, LocalDate date);

    // Find all crop prices for a particular marketplace
    List<CropPrice> findByMarketplace_MarketplaceId(Integer marketplaceId);

    // Find all crop prices for a specific crop on a certain date
    List<CropPrice> findByCrop_CropIdAndDate(Integer cropId, LocalDate date);
    

    
}
