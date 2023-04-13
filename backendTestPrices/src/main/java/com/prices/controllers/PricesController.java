package com.prices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prices.controllers.request.PriceRequest;
import com.prices.controllers.request.PriceResponse;
import com.prices.entities.dto.PricesDTO;
import com.prices.entities.service.PricesService;

@RestController
@RequestMapping("/api")
public class PricesController {

	@Autowired
	private PricesService pricesService;

	@GetMapping(path = "/getprice", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PriceResponse getPrice(@RequestBody PriceRequest request) {

		PriceResponse response = new PriceResponse();

		List<PricesDTO> result = this.pricesService.findByProductIdAndBrandIdAndDate(request.getProductId(),
				request.getBrandId(), request.getDate());
		
		if (result.size() > 0) {
			response.setBrandId(result.get(0).getBrandId());
			response.setEndDate(result.get(0).getEndDate());
			response.setPrice(result.get(0).getPrice());
			response.setPriceList(result.get(0).getPriceList());
			response.setProductId(result.get(0).getProductId());
			response.setStartDate(result.get(0).getStartDate());
		}
		
		return response;

	}
}
