package com.ecomindo.onboarding.poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecomindo.onboarding.poc.dto.OptionsDTO;
import com.ecomindo.onboarding.poc.model.ShirtsModel;

public interface ShirtsDao extends JpaRepository<ShirtsModel, Long> {
	@Query("Select new com.ecomindo.onboarding.poc.dto.OptionsDTO(concat(p.productcode, ' - ', p.name) as label, p.id as value) from ShirtsModel p")
	List<OptionsDTO> findDDLid();

	@Query(value = "select s from ShirtsModel s where s.id = :id ")
	List<ShirtsModel> findByid(int id);

	@Query(value = "select s from ShirtsModel s where s.productcode = :productCode ")
	List<ShirtsModel> findByProductCode(String productCode);

	void deleteById(int id);
}
