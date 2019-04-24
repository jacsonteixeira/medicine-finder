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
		List<WorseSupplierEntity> entities = worseSupplierRepository.findByRequestFields(request.getDepartFrom(),
				request.getArriveTo(),
				LocalDate.parse(request.getOutboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getOutboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				LocalDate.parse(request.getInboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay(),
				LocalDate.parse(request.getInboundDate(), DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().plusDays(1),
				request.getNumberOfMedicines());
		return castEntityToResponse(entities);
	}

	private List<WorseSupplierResponse> castEntityToResponse(List<WorseSupplierEntity> entities) {
		List<WorseSupplierResponse> responses = new ArrayList<>();
		for (WorseSupplierEntity entity : entities) {
			responses.add(new WorseSupplierResponse(entity.getMedicine(), entity.getTotalBasePrice().doubleValue(),
					entity.getTax().doubleValue(), entity.getDiscount().doubleValue(), entity.getDepartureCountryName(),
					entity.getArrivalCountryName(),
					entity.getOutboundDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
					entity.getInboundDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
		}
		return responses;
	}
}
