package com.bionexo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionexo.provider.domain.worsesupplier.WorseSupplierEntity;

public interface WorseSupplierRepository extends JpaRepository<WorseSupplierEntity, Long> {

	@Query(value = "SELECT ws FROM WorseSupplierEntity ws WHERE ws.departureCountryName = ?1 "
			+ "AND ws.arrivalCountryName = ?2 AND outboundDateTime BETWEEN ?3 AND ?4 "
			+ "AND ws.inboundDateTime BETWEEN ?5 AND ?6 AND ws.numberOfMedicines = ?7 ")
	List<WorseSupplierEntity> findByRequestFields(String departureCountryName, String arrivalCountryName,
			LocalDateTime outboundDateInitial, LocalDateTime outboundDateFinal, LocalDateTime inboundDateInitial,
			LocalDateTime inboundDateFinal, Integer numberOfMedicines);
}
