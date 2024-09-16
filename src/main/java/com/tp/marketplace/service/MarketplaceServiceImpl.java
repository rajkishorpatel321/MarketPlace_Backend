package com.tp.marketplace.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.marketplace.dto.MarketplaceDTO;
import com.tp.marketplace.entity.Marketplace;
import com.tp.marketplace.repository.MarketplaceRepository;

@Service
public class MarketplaceServiceImpl implements MarketplaceService {

    private final MarketplaceRepository marketplaceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MarketplaceServiceImpl(MarketplaceRepository marketplaceRepository,ModelMapper modelMapper) {
        this.marketplaceRepository = marketplaceRepository;
        this.modelMapper=modelMapper;
    }

	@Override
	public List<MarketplaceDTO> getAllMarketPlace() {
		// TODO Auto-generated method stub
		List<Marketplace> marketPlaces= marketplaceRepository.findAll();
//		Integer marketplaceId, String marketplaceName, String location
		List<MarketplaceDTO> marketPlaceDTOList = marketPlaces.stream().map(marketPlace -> convertToDTO(marketPlace)).collect(Collectors.toList());
		return marketPlaceDTOList;
	}

	// Helper method to convert Entity to DTO
	private MarketplaceDTO convertToDTO(Marketplace marketplace) {
		return modelMapper.map(marketplace, MarketplaceDTO.class);
	}

//	// Helper method to convert DTO to Entity
//	private Marketplace convertToEntity(MarketplaceDTO marketplaceDTO) {
//		return modelMapper.map(marketplaceDTO, Marketplace.class);
//	}
}
