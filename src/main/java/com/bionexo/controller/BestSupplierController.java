package com.bionexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.provider.domain.bestsuplier.BestSupplierRequest;
import com.bionexo.provider.domain.bestsuplier.BestSupplierResponse;
import com.bionexo.service.BestSupplierService;

@RestController
public class BestSupplierController {

	@Autowired
	private BestSupplierService bestSupplierService;

	@GetMapping(value = "/best-supplier", params = { "origin", "destination", "departureDate", "estimatedArrival",
			"quantityCount" })
	public ResponseEntity<List<BestSupplierResponse>> findByRequestFields(
			@RequestParam("origin") String origin, @RequestParam("destination") String destination,
			@RequestParam("departureDate") String departureDate, @RequestParam("estimatedArrival") String estimatedArrival,
			@RequestParam("quantityCount") int quantityCount) {
		BestSupplierRequest request = new BestSupplierRequest(origin, destination, departureDate, estimatedArrival,
				quantityCount);
		List<BestSupplierResponse> response = bestSupplierService.findByRequestFields(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
