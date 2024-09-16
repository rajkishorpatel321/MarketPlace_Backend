package com.tp.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.marketplace.entity.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

	// Fetch all crops with a price greater than a certain amount
//	List<Crop> findByPriceGreaterThan(Double price);

	// 1. Get the value of crops on a date basis in different marketplaces
	// @Query("SELECT c FROM Crop c WHERE c.marketplace.name = :marketplaceName AND
	// c.date = :date")
	// List<Crop> findByMarketplaceAndDate(@Param("marketplaceName") String
	// marketplaceName, @Param("date") LocalDate date);

	// Method to find crops by crop name
//	List<Crop> findByCropName(String cropName);

}