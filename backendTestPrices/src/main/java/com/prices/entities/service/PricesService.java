package com.prices.entities.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prices.entities.Prices;
import com.prices.entities.dto.PricesDTO;
import com.prices.entities.mapper.PricesMapper;
import com.prices.entities.repositories.PricesRepository;

@Service
public class PricesService {

	@Autowired
	private PricesRepository pricesRepository;
	
	private PricesMapper pricesMapper = new PricesMapper();
	
	@Transactional(readOnly = true)
	public List<PricesDTO> findByProductId(Long productId){
		List<Prices> queryResult = this.pricesRepository.findByProductId(productId);
		
		return toDTO(queryResult);
	}
	
	@Transactional(readOnly = true)
	public List<PricesDTO> findByProductIdAndBrandId(Long productId, Long brandId){
		List<Prices> queryResult = this.pricesRepository.findByProductIdAndBrandId(productId, brandId);
	
		return toDTO(queryResult);
	}
	
	@Transactional(readOnly = true)
	public List<PricesDTO> findByProductIdAndBrandIdAndDate(Long productId, Long brandId, Date date){
		List<Prices> queryResult = this.pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date);
		
		return toDTO(queryResult);
	}
	
	private List<PricesDTO> toDTO(List<Prices> prices){
		List<PricesDTO> result = new ArrayList<PricesDTO>();
		
		for(Prices p : prices) {
			result.add(pricesMapper.toDTO(p));
		}
		
		return result;
	}
}
