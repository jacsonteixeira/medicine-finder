package com.bionexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.provider.domain.medicinefinder.MedicineFinderRequest;
import com.bionexo.provider.domain.medicinefinder.MedicineFinderResponse;
import com.bionexo.service.MedicineFinderService;

@RestController
public class MedicineFinderController {

	@Autowired
	private MedicineFinderService medicineFinderService;

	@GetMapping(value = "/medicine-finder", params = { "origin", "destination", "departureDate", "estimatedArrival",
			"numberOfMedicine" })
	public ResponseEntity<List<MedicineFinderResponse>> findByRequestFields(@RequestParam("origin") String origin,
			@RequestParam("destination") String destination, @RequestParam("departureDate") String departureDate,
			@RequestParam("estimatedArrival") String estimatedArrival,
			@RequestParam("numberOfMedicine") int numberOfMedicine) {
		MedicineFinderRequest request = new MedicineFinderRequest(origin, destination, departureDate, estimatedArrival,
				numberOfMedicine);
		List<MedicineFinderResponse> response = medicineFinderService.findByRequestFields(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
