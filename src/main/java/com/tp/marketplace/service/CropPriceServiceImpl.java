package com.tp.marketplace.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.marketplace.dto.CropPriceDTO;
import com.tp.marketplace.dto.CropPriceWithNameDTO;
import com.tp.marketplace.entity.Crop;
import com.tp.marketplace.entity.CropPrice;
import com.tp.marketplace.entity.Marketplace;
import com.tp.marketplace.repository.CropPriceRepository;
import com.tp.marketplace.repository.MarketplaceRepository;

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
//        String cropName, String marketplaceName, Float price, LocalDate date
		List<CropPriceWithNameDTO> cropPriceWithName = new ArrayList<>();
		
		for (CropPrice c : cropPrices) {
			Crop crop = c.getCrop();
			Marketplace marketplace = c.getMarketplace();
			cropPriceWithName.add(
					new CropPriceWithNameDTO(crop.getCropName(), marketplace.getLocation(), c.getPrice(), c.getDate()));
		}

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
					new CropPriceWithNameDTO(crop.getCropName(), marketplace.getLocation(), c.getPrice(), c.getDate()));
		}
		return cropPriceWithName;
	}


	// TODO: mainMethod 
	@Override
	public void saveCropPrices(Long marketplaceId, LocalDate date, List<CropPriceDTO> cropPriceDTOs) {
		// Fetch the marketplace entity by marketplaceId
		Marketplace marketplace = marketplaceRepository.findById(marketplaceId)
				.orElseThrow(() -> new RuntimeException("Marketplace not found"));

		
		// Map each CropPriceDTO to a CropPrice entity, set the marketplace and date
		List<CropPrice> cropPrices = cropPriceDTOs.stream().map(dto -> {
			CropPrice cropPrice = modelMapper.map(dto, CropPrice.class);
			cropPrice.setMarketplace(marketplace);
			cropPrice.setDate(date);
			 cropPrice.setPriceId(null);
			return cropPrice;
		}).collect(Collectors.toList());
		// Save the list of crop prices
		cropPriceRepository.saveAll(cropPrices);
	}
	
	
	@Override
	public List<CropPriceDTO> getMarketplacePricesByCropAndDate(Long cropId, LocalDate date) {
		List<CropPrice> cropPrices = cropPriceRepository.findByCrop_CropIdAndDate((int) (long) cropId, date);
		return cropPrices.stream().map(cropPrice -> modelMapper.map(cropPrice, CropPriceDTO.class))
				.collect(Collectors.toList());
	}

}
