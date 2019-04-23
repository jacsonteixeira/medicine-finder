package com.bionexo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionexo.provider.domain.bestsuplier.BestSupplierEntity;

public interface BestSupplierRepository extends JpaRepository<BestSupplierEntity, Long> {

	@Query(value = "SELECT bs FROM BestSupplierEntity bs WHERE bs.departureCountryCode = ?1 "
			+ "AND bs.destinationCountryCode = ?2 AND departureDate BETWEEN ?3 AND ?4 "
			+ "AND bs.estimatedArrival BETWEEN ?5 AND ?6 AND bs.numberOfMedicines = ?7 ")
	List<BestSupplierEntity> findByRequestFields(String departureCountryCode, String destinationCountryCode,
			LocalDateTime departureDateInitial, LocalDateTime departureDateFinal, LocalDateTime estimatedArrivalInitial,
			LocalDateTime estimatedArrivalFinal, Integer numberOfMedicines);
}
