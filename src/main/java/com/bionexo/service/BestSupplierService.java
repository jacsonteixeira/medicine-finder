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
		List<BestSupplierEntity> entityList = bestSupplierRepository.findByRequestFields(request.getOrigin(),
				request.getDestination(),
				LocalDate.parse(request.getDepartureDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getDepartureDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				LocalDate.parse(request.getEstimatedArrival(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getEstimatedArrival(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				request.getQuantityCount());
		return castEntityToResponse(entityList);
	}

	private List<BestSupplierResponse> castEntityToResponse(List<BestSupplierEntity> entityList) {
		List<BestSupplierResponse> responseList = new ArrayList<>();
		for (BestSupplierEntity entity : entityList) {
			BestSupplierResponse response = new BestSupplierResponse();
			response.setMedicineName(entity.getMedicineName());
			response.setPrice(entity.getPrice());
			response.setMedicineType(entity.getMedicineType().name());
			response.setDepartureCountryCode(entity.getDepartureCountryCode());
			response.setDestinationCountryCode(entity.getDestinationCountryCode());
			response.setDepartureDate(entity.getDepartureDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			response.setEstimatedArrival(entity.getEstimatedArrival().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			responseList.add(response);
		}
		return responseList;
	}

}
