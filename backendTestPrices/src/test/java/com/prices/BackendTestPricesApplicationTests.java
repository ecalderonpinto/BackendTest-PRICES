package com.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prices.controllers.PricesController;
import com.prices.controllers.request.PriceRequest;
import com.prices.controllers.request.PriceResponse;

@SpringBootTest
class BackendTestPricesApplicationTests {

	@Autowired
	PricesController pricesController;

	@BeforeEach
	void setUp() {
	}
	
	/*
	Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	*/

	@Test
	@DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
	void test5() {
		PriceRequest request = new PriceRequest();
		request.setBrandId(1l);
		request.setProductId(35455l);
		request.setDate(getDate(16, 6, 2020, 21, 0));
		
		PriceResponse response = this.pricesController.getPrice(request);
		
		assertEquals(new BigDecimal(38.95).doubleValue(), response.getPrice().doubleValue(), 0.01);
	}
	
	@Test
	@DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
	void test4() {
		PriceRequest request = new PriceRequest();
		request.setBrandId(1l);
		request.setProductId(35455l);
		request.setDate(getDate(15, 6, 2020, 10, 0));
		
		PriceResponse response = this.pricesController.getPrice(request);
		
		assertEquals(new BigDecimal(30.50).doubleValue(), response.getPrice().doubleValue(), 0.01);
	}
	
	@Test
	@DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test3() {
		PriceRequest request = new PriceRequest();
		request.setBrandId(1l);
		request.setProductId(35455l);
		request.setDate(getDate(14, 6, 2020, 21, 0));
		
		PriceResponse response = this.pricesController.getPrice(request);
		
		assertEquals(new BigDecimal(35.50).doubleValue(), response.getPrice().doubleValue(), 0.01);
	}
	
	@Test
	@DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test2() {
		PriceRequest request = new PriceRequest();
		request.setBrandId(1l);
		request.setProductId(35455l);
		request.setDate(getDate(14, 6, 2020, 16, 0));
		
		PriceResponse response = this.pricesController.getPrice(request);
		
		assertEquals(new BigDecimal(25.45).doubleValue(), response.getPrice().doubleValue(), 0.01);
	}
	
	@Test
	@DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test1() {
		PriceRequest request = new PriceRequest();
		request.setBrandId(1l);
		request.setProductId(35455l);
		request.setDate(getDate(14, 6, 2020, 10, 0));
		
		PriceResponse response = this.pricesController.getPrice(request);
		
		assertEquals(new BigDecimal(35.5).doubleValue(), response.getPrice().doubleValue(), 0.01);
	}

	private Date getDate(int day, int month, int year, int hour, int minute) {
		Calendar gc = GregorianCalendar.getInstance();
		gc.set(GregorianCalendar.DAY_OF_MONTH, day);
		gc.set(GregorianCalendar.MONTH, month-1);
		gc.set(GregorianCalendar.YEAR, year);
		gc.set(GregorianCalendar.HOUR_OF_DAY, hour);
		gc.set(GregorianCalendar.MINUTE, minute);
		
		return gc.getTime();
	}

}
