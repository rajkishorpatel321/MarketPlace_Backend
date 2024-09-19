package com.tp.marketplace.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.marketplace.dto.CropPriceDTO;
import com.tp.marketplace.dto.CropPriceWithNameDTO;
import com.tp.marketplace.entity.Crop;
import com.tp.marketplace.entity.CropPrice;
import com.tp.marketplace.entity.Marketplace;
import com.tp.marketplace.exception.TpCropPriceException;
import com.tp.marketplace.repository.CropPriceRepository;
import com.tp.marketplace.repository.MarketplaceRepository;
import com.tp.marketplace.validator.Validator;

@Service
public class CropPriceServiceImpl implements CropPriceService {

	@Autowired
	private CropPriceRepository cropPriceRepository;

	@Autowired
	private MarketplaceRepository marketplaceRepository;

	@Autowired
	private ModelMapper modelMapper;

	// TODO: mainMethod 
	@Override
	public List<CropPriceWithNameDTO> getCropsByMarketplaceAndDateWithName(Long marketplaceId, LocalDate date) {
		List<CropPrice> cropPrices = cropPriceRepository
				.findByCrop_CropIdAndDate((int) (long) marketplaceId, date);
		
		List<CropPriceWithNameDTO> cropPriceWithName = new ArrayList<>();
//		Collections.sort(cropPrices, Comparator.comparing(CropPrice::getMarketplace().getMarketPlaceId));
		for (CropPrice c : cropPrices) {
		    Crop crop = c.getCrop();
		    Marketplace marketplace = c.getMarketplace();
		    cropPriceWithName.add(
		        new CropPriceWithNameDTO(crop.getCropId(), crop.getCropName(), marketplace.getLocation(), 
		            c.getPrice(), c.getDate(), c.getPriceHighest(), c.getPriceLowest()));
		}
//		Collections.sort(cropPriceWithName, Comparator.comparing(CropPriceWithNameDTO::getCropId));
	    cropPriceWithName.sort(Comparator.comparing(CropPriceWithNameDTO::getMarketplaceName));
	    
		return cropPriceWithName;
	}

	// TODO: mainMethod 
	@Override
	public List<CropPriceWithNameDTO> getAllCropsInMarketplaceOnDate(Long marketplaceId, LocalDate date) {
		List<CropPrice> cropPrices = cropPriceRepository.findByMarketplace_MarketplaceIdAndDate((int) (long) marketplaceId,date);

		List<CropPriceWithNameDTO> cropPriceWithName = new ArrayList<>();

		for (CropPrice c : cropPrices) {
		    Crop crop = c.getCrop();
		    Marketplace marketplace = c.getMarketplace();
		    cropPriceWithName.add(
		        new CropPriceWithNameDTO(crop.getCropId(), crop.getCropName(), marketplace.getLocation(), 
		            c.getPrice(), c.getDate(), c.getPriceHighest(), c.getPriceLowest()));
		}

		// Sort the list by cropId in ascending order
		Collections.sort(cropPriceWithName, Comparator.comparing(CropPriceWithNameDTO::getCropId));
		return cropPriceWithName;
	}


	// TODO: mainMethod 
	@Override
	public void saveCropPrices(Long marketplaceId, LocalDate date, List<CropPriceDTO> cropPriceDTOs) throws TpCropPriceException {
		// Fetch the marketplace entity by marketplaceId
		
		Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
				.orElseThrow(() -> new RuntimeException("Marketplace not found"));
		
		List<CropPrice> existingCropPrices = cropPriceRepository
	            .findByMarketplace_MarketplaceIdAndDate((int) (long) marketplaceId, date);
//		Validator validate = new Validator();
//		validate.validateDateAndPrice(date, cropPriceDTOs);
		
	    if (existingCropPrices.isEmpty()) {
	        // No existing records, perform the insert
	        List<CropPrice> newCropPrices = cropPriceDTOs.stream().map(dto -> {
	            CropPrice cropPrice = modelMapper.map(dto, CropPrice.class);
	            cropPrice.setMarketplace(marketplace);
	            cropPrice.setDate(date);
	            return cropPrice;
	        }).collect(Collectors.toList());

	        cropPriceRepository.saveAll(newCropPrices);

	    } else {
	        // Existing records found, perform the update
	        for (CropPriceDTO newPriceDTO : cropPriceDTOs) {
	            CropPrice existingPrice = existingCropPrices.stream()
	                    .filter(cropPrice -> cropPrice.getCrop().getCropId() == newPriceDTO.getCropId())
	                    .findFirst()
	                    .orElse(null);

	            if (existingPrice != null) {
	                // Update the existing crop price
	                existingPrice.setPrice(newPriceDTO.getPrice());
	                existingPrice.setPriceHighest(newPriceDTO.getPriceHighest());
	                existingPrice.setPriceLowest(newPriceDTO.getPriceLowest());
	            } else {
	                // If no matching crop price is found, create a new one
	                CropPrice newCropPrice = modelMapper.map(newPriceDTO, CropPrice.class);
	                newCropPrice.setMarketplace(marketplace);
	                newCropPrice.setDate(date);
	                cropPriceRepository.save(newCropPrice);
	            }
	        }

	        // Save all updates
	        cropPriceRepository.saveAll(existingCropPrices);
	    }
	
	}
	
	
	@Override
	public List<CropPriceDTO> getMarketplacePricesByCropAndDate(Long cropId, LocalDate date) {
		List<CropPrice> cropPrices = cropPriceRepository.findByCrop_CropIdAndDate((int) (long) cropId, date);
		return cropPrices.stream().map(cropPrice -> modelMapper.map(cropPrice, CropPriceDTO.class))
				.collect(Collectors.toList());
	}

}
