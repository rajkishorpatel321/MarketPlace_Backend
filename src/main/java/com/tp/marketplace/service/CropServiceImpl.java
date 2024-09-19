package com.tp.marketplace.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.marketplace.dto.CropDTO;
import com.tp.marketplace.entity.Crop;
import com.tp.marketplace.repository.CropRepository;

@Service
public class CropServiceImpl implements CropService {

	private final CropRepository cropRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public CropServiceImpl(CropRepository cropRepository, ModelMapper modelMapper) {
		this.cropRepository = cropRepository;
		this.modelMapper = modelMapper;
	}

	
	@Override
	public List<CropDTO> findAllCrop() {
		List<Crop> findAll = cropRepository.findAll();
		 List<Crop> sortedCrops = findAll.stream()
                 .sorted(Comparator.comparing(crop -> crop.getCropId()))  // Sort by Crop's 'id' property
                 .collect(Collectors.toList());
		List<CropDTO> allCrop = sortedCrops.stream().map(c -> convertToDTO(c)).collect(Collectors.toList());
		return allCrop;
	}
	
	
	
	
	//Save crop values based on the marketplace and date
	@Override
	public CropDTO saveCropValue(CropDTO cropDTO) {
		Crop crop = convertToEntity(cropDTO);
		Crop savedCrop = cropRepository.save(crop);
		return convertToDTO(savedCrop);
	}

	// Helper method to convert Entity to DTO
	private CropDTO convertToDTO(Crop crop) {
		return modelMapper.map(crop, CropDTO.class);
	}

	// Helper method to convert DTO to Entity
	private Crop convertToEntity(CropDTO cropDTO) {
		return modelMapper.map(cropDTO, Crop.class);
	}

}
