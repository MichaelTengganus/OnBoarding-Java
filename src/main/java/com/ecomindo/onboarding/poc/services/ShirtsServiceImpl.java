package com.ecomindo.onboarding.poc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomindo.onboarding.poc.dao.ShirtsDao;
import com.ecomindo.onboarding.poc.model.ShirtsModel;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ShirtsServiceImpl implements ShirtsService {

	@Autowired
	ShirtsDao shirtsDao;

	@Override
	public ShirtsModel insert(String productcode, String name, Integer rating, Double price, String description) {
		try {
			ShirtsModel shirts = shirtsDao.save(new ShirtsModel(productcode, name, rating, price, description));
			return shirts;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ShirtsModel update(ShirtsModel oldShirt, ShirtsModel newShirt) {
		try {
			oldShirt.setProductCode(newShirt.getProductCode());
			oldShirt.setName(newShirt.getName());
			oldShirt.setPrice(newShirt.getPrice());
			oldShirt.setRating(newShirt.getRating());
			oldShirt.setDescription(newShirt.getDescription());

			shirtsDao.save(oldShirt);
			return oldShirt;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			shirtsDao.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
