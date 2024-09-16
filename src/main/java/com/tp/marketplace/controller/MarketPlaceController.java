package com.tp.marketplace.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.marketplace.dto.CropPriceWithNameDTO;
import com.tp.marketplace.dto.MarketplaceDTO;
import com.tp.marketplace.service.CropPriceService;
import com.tp.marketplace.service.MarketplaceService;

@RestController
@RequestMapping("/api/marketplace")
public class MarketPlaceController {
	private final MarketplaceService marketplaceService;
	private final CropPriceService cropProceService;

	@Autowired
	public MarketPlaceController(MarketplaceService marketplaceService,CropPriceService cropProceService) {
		this.marketplaceService = marketplaceService;
		this.cropProceService = cropProceService;
	}
	
	@GetMapping("/getAllMarketPlace")
	public ResponseEntity<List<MarketplaceDTO>> getAllMarketPlace(){
		List<MarketplaceDTO> allCrop = marketplaceService.getAllMarketPlace();
		return ResponseEntity.ok(allCrop);
	}
	
	@GetMapping("/by-marketplace/{marketPlaceId}/on-date/{date}")
    public ResponseEntity<List<CropPriceWithNameDTO>> getMarketplacePricesByCropAndDate(
            @PathVariable Long marketPlaceId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<CropPriceWithNameDTO> cropPrices = cropProceService.getAllCropsInMarketplaceOnDate(marketPlaceId, date);
        return ResponseEntity.ok(cropPrices);
    }
}
