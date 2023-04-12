package com.prices.entities.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prices.entities.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long>{

	public List<Prices> findByProductId(Long productId);
	
	public List<Prices> findByProductIdAndBrandId(Long productId, Long brandId);
	
	@Query("from Prices where productId = :productId and brandId = :brandId and :date between startDate and endDate order by priority desc")
	public List<Prices> findByProductIdAndBrandIdAndDate(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("date") Date date);
}
