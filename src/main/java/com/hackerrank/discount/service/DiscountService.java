/**
 * 
 */
package com.hackerrank.discount.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.discount.model.Discount;

/**
 * @author rajen.venkatraman
 *
 */
@Service
public class DiscountService {

	private static final Map<Integer, Discount> orderDiscountMap = new HashMap<Integer, Discount>();
	static {
		orderDiscountMap.put(1, new Discount(1, "5", "2019-05-01"));
		orderDiscountMap.put(2, new Discount(2, "12", "2019-05-01"));
		orderDiscountMap.put(3, new Discount(3, "15", "2019-05-01"));
		orderDiscountMap.put(4, new Discount(4, "20", "2019-05-01"));
		orderDiscountMap.put(5, new Discount(5, "25", "2019-05-01"));
	}

	public Discount getDiscountForOrder(double orderWeightageAmt) {
		return orderDiscountMap.get(findOrderWeightage(orderWeightageAmt));
	}

	private int findOrderWeightage(double amount) {
		return amount < 50 ? 1
				: (amount > 50 && amount < 70) ? 2
						: (amount > 70 && amount < 100) ? 3
								: (amount > 100 && amount < 250) ? 3
										: (amount > 250 && amount < 500) ? 4 : (amount > 500 && amount < 1000) ? 5 : 0;
	}

}