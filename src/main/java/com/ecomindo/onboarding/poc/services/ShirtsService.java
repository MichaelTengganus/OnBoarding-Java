package com.ecomindo.onboarding.poc.services;

import com.ecomindo.onboarding.poc.dao.ShirtsDao;
import com.ecomindo.onboarding.poc.model.ShirtsModel;

public interface ShirtsService {
	public ShirtsModel insert(String productcode, String name, Integer rating, Double price, String description);
	public ShirtsModel update(ShirtsModel oldShirt, ShirtsModel newShirt);
	public void delete(int id);
}
