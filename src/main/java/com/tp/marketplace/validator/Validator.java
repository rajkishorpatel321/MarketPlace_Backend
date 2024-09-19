package com.tp.marketplace.validator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.tp.marketplace.dto.CropPriceDTO;
import com.tp.marketplace.exception.TpCropPriceException;

public class Validator {

	@Autowired
	Environment environment;
	
	public void validateDateAndPrice(LocalDate date,List<CropPriceDTO> cropPriceDTO) throws TpCropPriceException{
		if(isDateValid(date)) {
			throw new TpCropPriceException(environment.getProperty("Validator.INVALID_DATE"));
		}
		if(isPriceValid(cropPriceDTO)) {
			throw new TpCropPriceException(environment.getProperty("Validator.INVALID_PRICE"));
		}
	}
	
	public boolean isDateValid(LocalDate date) {
		boolean flag = date.isBefore(LocalDate.now().plusDays(1));
		return flag;
	}
	
	public boolean isPriceValid(List<CropPriceDTO> cropPriceDTO) {
		boolean flag=false;
		for(CropPriceDTO c:cropPriceDTO) {
			if(c.getPrice()>=1000000 && c.getPrice()<=0) {
				return true;
			}
			if(c.getPriceHighest()>=1000000 && c.getPriceHighest()<=0) {
				return true;
			}
			if(c.getPriceLowest()>=1000000 && c.getPriceLowest()<=0) {
				return true;
			}
		}
		return flag;
	}
}
