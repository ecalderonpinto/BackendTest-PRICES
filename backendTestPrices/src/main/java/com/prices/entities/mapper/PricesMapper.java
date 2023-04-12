package com.prices.entities.mapper;

import com.prices.entities.Prices;
import com.prices.entities.dto.PricesDTO;

public class PricesMapper {

	public PricesDTO toDTO(Prices entity) {
		PricesDTO result = new PricesDTO();
		
		result.setBrandId(entity.getBrandId());
		result.setCurr(entity.getCurr());
		result.setEndDate(entity.getEndDate());
		result.setPrice(entity.getPrice());
		result.setPriceList(entity.getPriceList());
		result.setPriority(entity.getPriority());
		result.setProductId(entity.getProductId());
		result.setStartDate(entity.getStartDate());
		
		return result;
	}

    Prices toEntity(PricesDTO dto) {
    	Prices result = new Prices();
		
		result.setBrandId(dto.getBrandId());
		result.setCurr(dto.getCurr());
		result.setEndDate(dto.getEndDate());
		result.setPrice(dto.getPrice());
		result.setPriceList(dto.getPriceList());
		result.setPriority(dto.getPriority());
		result.setProductId(dto.getProductId());
		result.setStartDate(dto.getStartDate());
		
		return result;
    }

}
