package com.bionexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.provider.domain.worsesupplier.WorseSupplierRequest;
import com.bionexo.provider.domain.worsesupplier.WorseSupplierResponse;
import com.bionexo.service.WorseSupplierService;

@RestController
public class WorseSupplierController {

	@Autowired
	private WorseSupplierService worseSupplierService;

	@GetMapping(value = "/worse-supplier", params = { "departFrom", "arriveTo", "outboundDate", "inboundDate",
			"numberOfMedicines" })
	public ResponseEntity<List<WorseSupplierResponse>> findByRequestFields(
			@RequestParam("departFrom") String departFrom, @RequestParam("arriveTo") String arriveTo,
			@RequestParam("outboundDate") String outboundDate, @RequestParam("inboundDate") String inboundDate,
			@RequestParam("numberOfMedicines") int numberOfMedicines) {
		WorseSupplierRequest request = new WorseSupplierRequest(departFrom, arriveTo, outboundDate, inboundDate,
				numberOfMedicines);
		List<WorseSupplierResponse> response = worseSupplierService.findByRequestFields(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
