package com.ecomindo.onboarding.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomindo.onboarding.poc.dao.ShirtsDao;
import com.ecomindo.onboarding.poc.dto.OptionsDTO;
import com.ecomindo.onboarding.poc.dto.ResponseDTO;
import com.ecomindo.onboarding.poc.model.ShirtsModel;
import com.ecomindo.onboarding.poc.services.ShirtsService;

@RestController
@RequestMapping("/shirts")
public class ShirtsController {

	@Autowired
	ShirtsDao shirtsDao;

	@Autowired
	ShirtsService shirtsService;

	@GetMapping("/get-shirts")
	public ResponseEntity<List<ShirtsModel>> getAllShirts(@RequestParam(required = false) Integer id) {
		try {
			List<ShirtsModel> shirts = new ArrayList<ShirtsModel>();

			if (id == null)
				shirtsDao.findAll().forEach(shirts::add);
			else
				shirts.add(shirtsDao.findById(id));

			if (shirts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(shirts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-shirts2")
	public ResponseDTO getAllShirts2(@RequestParam(required = false) String productCode) {
		ResponseDTO response = new ResponseDTO();
		try {
			List<ShirtsModel> shirts = new ArrayList<ShirtsModel>();

			if (productCode == null)
				shirtsDao.findAll().forEach(shirts::add);
			else
				shirts.add(shirtsDao.findByProductCode(productCode));

			response.setCode("200");
			if (shirts.isEmpty()) {
				response.setMessage(HttpStatus.NO_CONTENT.toString());
			}

			response.setData(shirts);
			return response;
		} catch (Exception e) {
			response.setCode("500");
			return response;
		}
	}

	@GetMapping("/get-ddl-shirts")
	public ResponseDTO getDdlShirts() {
		ResponseDTO response = new ResponseDTO();
		try {

			List<OptionsDTO> opt = shirtsDao.findDDLid();
			response.setCode("200");
			if (opt.isEmpty()) {
				response.setMessage(HttpStatus.NO_CONTENT.toString());
			}

			response.setData(opt);
			return response;
		} catch (Exception e) {
			response.setCode("500");
			return response;
		}
	}

	@PostMapping("/insert")
	public ResponseDTO insert(@RequestBody ShirtsModel shirts) {
		ResponseDTO response = new ResponseDTO();
		try {
			ShirtsModel shirt = shirtsService.insert(shirts.getProductCode(), shirts.getName(), shirts.getRating(),
					shirts.getPrice(), shirts.getDescription());

			response.setCode("200");
			response.setMessage("Insert Success");
			response.setData(shirt);

			return response;
		} catch (Exception e) {
			response.setCode("500");
			response.setMessage("Insert Failed");
			return response;
		}
	}

	@PostMapping("/update/{id}")
	public ResponseDTO update(@PathVariable int id, @RequestBody ShirtsModel newShirts) {
		ResponseDTO response = new ResponseDTO();
		try {
			ShirtsModel oldShirt = shirtsDao.findById(id);
			ShirtsModel shirt = shirtsService.update(oldShirt, newShirts);

			response.setCode("200");
			response.setMessage("update Success");
			response.setData(shirt);

			return response;
		} catch (Exception e) {
			response.setCode("500");
			response.setMessage("update Failed");
			return response;
		}
	}

	@PostMapping("/delete/{id}")
	public ResponseDTO delete(@PathVariable int id) {
		ResponseDTO response = new ResponseDTO();
		try {
			shirtsService.delete(id);

			response.setCode("200");
			response.setMessage("delete Success");

			return response;
		} catch (Exception e) {
			response.setCode("500");
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
