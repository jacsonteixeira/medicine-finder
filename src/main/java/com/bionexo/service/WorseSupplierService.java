package com.bionexo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionexo.provider.domain.worsesupplier.WorseSupplierEntity;
import com.bionexo.provider.domain.worsesupplier.WorseSupplierRequest;
import com.bionexo.provider.domain.worsesupplier.WorseSupplierResponse;
import com.bionexo.repository.WorseSupplierRepository;

@Service
public class WorseSupplierService {

	@Autowired
	private WorseSupplierRepository worseSupplierRepository;

	public List<WorseSupplierResponse> findByRequestFields(WorseSupplierRequest request) {
		List<WorseSupplierEntity> entityList = worseSupplierRepository.findByRequestFields(request.getDepartFrom(),
				request.getArriveTo(),
				LocalDate.parse(request.getOutboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getOutboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				LocalDate.parse(request.getInboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getInboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				request.getNumberOfMedicines());
		return castEntityToResponse(entityList);
	}

	private List<WorseSupplierResponse> castEntityToResponse(List<WorseSupplierEntity> entityList) {
		List<WorseSupplierResponse> responseList = new ArrayList<>();
		for (WorseSupplierEntity entity : entityList) {
			WorseSupplierResponse response = new WorseSupplierResponse();
			response.setMedicine(entity.getMedicine());
			response.setTotalBasePrice(entity.getTotalBasePrice());
			response.setTax(entity.getTax());
			response.setDiscount(entity.getDiscount());
			response.setDepartureCountryName(entity.getDepartureCountryName());
			response.setArrivalCountryName(entity.getArrivalCountryName());
			response.setOutboundDateTime(entity.getOutboundDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			response.setInboundDateTime(entity.getInboundDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			responseList.add(response);
		}
		return responseList;
	}
}
