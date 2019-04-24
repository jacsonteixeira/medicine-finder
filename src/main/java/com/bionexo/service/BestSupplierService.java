package com.bionexo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionexo.provider.domain.bestsuplier.BestSupplierEntity;
import com.bionexo.provider.domain.bestsuplier.BestSupplierRequest;
import com.bionexo.provider.domain.bestsuplier.BestSupplierResponse;
import com.bionexo.repository.BestSupplierRepository;

@Service
public class BestSupplierService {

	@Autowired
	private BestSupplierRepository bestSupplierRepository;

	public List<BestSupplierResponse> findByRequestFields(BestSupplierRequest request) {
		List<BestSupplierEntity> entities = bestSupplierRepository.findByRequestFields(request.getOrigin(),
				request.getDestination(),
				LocalDate.parse(request.getDepartureDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getDepartureDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay()
						.plusDays(1),
				LocalDate.parse(request.getEstimatedArrival(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getEstimatedArrival(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay()
						.plusDays(1),
				request.getQuantityCount());
		return castEntityToResponse(entities);
	}

	private List<BestSupplierResponse> castEntityToResponse(List<BestSupplierEntity> entities) {
		List<BestSupplierResponse> responses = new ArrayList<>();
		for (BestSupplierEntity entity : entities) {
			responses.add(new BestSupplierResponse(entity.getMedicineName(), entity.getPrice().doubleValue(),
					entity.getMedicineType().name(), entity.getDepartureCountryCode(),
					entity.getDestinationCountryCode(),
					entity.getDepartureDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
					entity.getEstimatedArrival().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
		}
		return responses;
	}

}
