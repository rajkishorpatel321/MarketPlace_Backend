package com.tp.marketplace.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.marketplace.dto.CropPriceDTO;
import com.tp.marketplace.dto.CropPriceWithNameDTO;
import com.tp.marketplace.exception.TpCropPriceException;
import com.tp.marketplace.service.CropPriceService;

@RestController
@RequestMapping("/api/crop-prices")
public class CropPriceController {

    @Autowired
    private CropPriceService cropPriceService;

    @Autowired
    private Environment enviroment;

    // Get all marketplace prices for a specific crop on a given date
    @GetMapping("/by-crop/{cropId}/on-date/{date}")
    public ResponseEntity<List<CropPriceDTO>> getMarketplacePricesByCropAndDate(
            @PathVariable Long cropId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<CropPriceDTO> cropPrices = cropPriceService.getMarketplacePricesByCropAndDate(cropId, date);
        return ResponseEntity.ok(cropPrices);
    }
    
    @GetMapping("/by-crop/name/{cropId}/on-date/{date}")
    public ResponseEntity<List<CropPriceWithNameDTO>> getCropPricesByCropNameAndDate(
    		@PathVariable Long cropId,
    		@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    	
    	List<CropPriceWithNameDTO> cropPrices = cropPriceService.getCropsByMarketplaceAndDateWithName(cropId, date);
         return ResponseEntity.ok(cropPrices);
    }
    
    @PostMapping("/save/{marketplaceId}/on-date/{date}")
    public ResponseEntity<String> saveCropPrices(
            @PathVariable Long marketplaceId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody List<CropPriceDTO> cropPriceDTOs) throws TpCropPriceException{
    	
    		 cropPriceService.saveCropPrices(marketplaceId, date, cropPriceDTOs);
    	        String successMessage = enviroment.getProperty("API.INSERT_SUCCESS");
    	        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    	
       
    }
}
