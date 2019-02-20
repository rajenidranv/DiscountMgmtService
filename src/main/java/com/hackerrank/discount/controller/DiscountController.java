/**
 * 
 */
package com.hackerrank.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.hackerrank.discount.model.Discount;
import com.hackerrank.discount.service.DiscountService;

/**
 * @author rajen.venkatraman
 *
 */
@RestController
@RequestMapping("/tcs/hack/v1/discount")
public class DiscountController {

	@Autowired
	private DiscountService discountService;

	@RequestMapping(value = "/order/{amount}", method = RequestMethod.GET)
	public ResponseEntity<Object> getDiscountForOrder(@PathVariable("amount") double amount) {

		Discount discount = discountService.getDiscountForOrder(amount);

		if (discount != null) {
			return new ResponseEntity<Object>(discount, HttpStatus.OK);
		} else {
			try {
				Thread.sleep(2000);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			return new ResponseEntity<Object>("Discount not found", HttpStatus.NOT_FOUND);
		}
	}

}
