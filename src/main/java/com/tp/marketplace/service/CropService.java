package com.tp.marketplace.service;

import java.util.List;

import com.tp.marketplace.dto.CropDTO;

public interface CropService {

	// 3. Save crop values based on the marketplace and date
	CropDTO saveCropValue(CropDTO cropDTO);
	
	List<CropDTO> findAllCrop();

}
