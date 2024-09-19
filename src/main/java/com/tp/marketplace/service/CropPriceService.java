package com.tp.marketplace.service;


import java.time.LocalDate;
import java.util.List;

import com.tp.marketplace.dto.CropPriceDTO;
import com.tp.marketplace.dto.CropPriceWithNameDTO;
import com.tp.marketplace.exception.TpCropPriceException;

public interface CropPriceService {


    // Get all crop prices in a given marketplace on a certain date
    List<CropPriceWithNameDTO> getAllCropsInMarketplaceOnDate(Long marketplaceId, LocalDate date);
    
    List<CropPriceWithNameDTO> getCropsByMarketplaceAndDateWithName(Long marketplaceId, LocalDate date);

    void saveCropPrices(Long marketplaceId, LocalDate date, List<CropPriceDTO> cropPriceDTOs) throws TpCropPriceException;
    
   
    
    List<CropPriceDTO> getMarketplacePricesByCropAndDate(Long cropId, LocalDate date);
    
}
