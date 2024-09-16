package com.tp.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.marketplace.dto.CropDTO;
import com.tp.marketplace.service.CropService;

@RestController
@RequestMapping("/api/crops")
public class CropController {

	private final CropService cropService;

	@Autowired
	public CropController(CropService cropService) {
		this.cropService = cropService;
	}
	
	@GetMapping("/getAllCrop")
	public ResponseEntity<List<CropDTO>> getAllCrop(){
		List<CropDTO> allCrop = cropService.findAllCrop();
		return ResponseEntity.ok(allCrop);
	}

}
