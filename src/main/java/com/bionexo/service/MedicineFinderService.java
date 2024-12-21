package com.bionexo.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bionexo.util.enums.SupplierType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bionexo.provider.domain.bestsuplier.BestSupplierResponse;
import com.bionexo.provider.domain.medicinefinder.MedicineFinderRequest;
import com.bionexo.provider.domain.medicinefinder.MedicineFinderResponse;
import com.bionexo.provider.domain.worsesupplier.WorseSupplierResponse;
import com.bionexo.util.enums.MedicineType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MedicineFinderService {

	static final String BEST_SUPPLIER_API = "http://localhost:8080/best-supplier";
	static final String WORSE_SUPPLIER_API = "http://localhost:8080/worse-supplier";

	public List<MedicineFinderResponse> findByRequestFields(MedicineFinderRequest request) {
		// Get API results
		List<BestSupplierResponse> bestSupResponses = getBestSupRespFromAPI(request);
		List<WorseSupplierResponse> worseSupResponses = getWorseSupRespFromAPI(request);

		// Transform to results to MedicineFinderResponse
		List<MedicineFinderResponse> bestSupMedResponses = castBestRespToMedResp(bestSupResponses);
		List<MedicineFinderResponse> worseSupMedResponses = castWorseSupRespToMedResp(worseSupResponses);

		// Combine responses
		List<MedicineFinderResponse> finalMedFinderResponses = combineResponses(bestSupMedResponses,
				worseSupMedResponses);

		// Order and return
		return orderByPrice(finalMedFinderResponses);
	}

	private List<BestSupplierResponse> getBestSupRespFromAPI(MedicineFinderRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ObjectMapper mapper = new ObjectMapper();
		List<BestSupplierResponse> bestSupResponses = new ArrayList<>();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BEST_SUPPLIER_API)
				.queryParam("origin", request.getOrigin()).queryParam("destination", request.getDestination())
				.queryParam("departureDate", request.getDepartureDate())
				.queryParam("estimatedArrival", request.getEstimatedArrival())
				.queryParam("quantityCount", request.getNumberOfMedicine());
		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		try {
			bestSupResponses = mapper.readValue(response.getBody(), new TypeReference<List<BestSupplierResponse>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bestSupResponses;
	}

	private List<WorseSupplierResponse> getWorseSupRespFromAPI(MedicineFinderRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ObjectMapper mapper = new ObjectMapper();
		List<WorseSupplierResponse> worseSupResponses = new ArrayList<>();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(WORSE_SUPPLIER_API)
				.queryParam("departFrom", request.getOrigin()).queryParam("arriveTo", request.getDestination())
				.queryParam("outboundDate", request.getDepartureDate())
				.queryParam("inboundDate", request.getEstimatedArrival())
				.queryParam("numberOfMedicines", request.getNumberOfMedicine());
		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		try {
			worseSupResponses = mapper.readValue(response.getBody(), new TypeReference<List<WorseSupplierResponse>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return worseSupResponses;
	}

	private List<MedicineFinderResponse> castBestRespToMedResp(List<BestSupplierResponse> bestSupResponses) {
		List<MedicineFinderResponse> medResponses = new ArrayList<>();
		for (BestSupplierResponse bestSupResponse : bestSupResponses) {
			medResponses.add(new MedicineFinderResponse(SupplierType.BEST_SUPPLIER.getSupplierName(),
					bestSupResponse.getMedicineName(), bestSupResponse.getPrice(),
					bestSupResponse.getDepartureCountryCode(), bestSupResponse.getDestinationCountryCode(),
					LocalDate.parse(bestSupResponse.getDepartureDate(), DateTimeFormatter.ISO_DATE_TIME).toString(),
					LocalDate.parse(bestSupResponse.getEstimatedArrival(), DateTimeFormatter.ISO_DATE_TIME)
							.toString()));
		}
		return medResponses;
	}

	private List<MedicineFinderResponse> castWorseSupRespToMedResp(List<WorseSupplierResponse> worseSupResponses) {
		List<MedicineFinderResponse> medResponses = new ArrayList<>();
		for (WorseSupplierResponse worseSupResponse : worseSupResponses) {
			medResponses.add(new MedicineFinderResponse(SupplierType.WORSE_SUPPLIER.getSupplierName(),
					worseSupResponse.getMedicine(),
					(Math.round(calculateTotalPrice(worseSupResponse.getTotalBasePrice(),
							worseSupResponse.getDiscount(), worseSupResponse.getTax()) * 100.0) / 100.0),
					worseSupResponse.getDepartureCountryName(), worseSupResponse.getArrivalCountryName(),
					LocalDate.parse(worseSupResponse.getOutboundDateTime(), DateTimeFormatter.ISO_DATE_TIME).toString(),
					LocalDate.parse(worseSupResponse.getInboundDateTime(), DateTimeFormatter.ISO_DATE_TIME)
							.toString()));

		}
		return medResponses;
	}

	protected double calculateTotalPrice(double basePrice, double discount, double tax) {
		double discountAmount = basePrice * discount;
		double priceAfterDiscount = basePrice - discountAmount;
		double taxAmount = priceAfterDiscount * tax;
		return priceAfterDiscount + taxAmount;

	}

	protected List<MedicineFinderResponse> combineResponses(List<MedicineFinderResponse> bestResp,
			List<MedicineFinderResponse> worseResp) {
		bestResp.addAll(worseResp);
		return bestResp;
	}

	protected List<MedicineFinderResponse> orderByPrice(List<MedicineFinderResponse> responses) {
		responses.sort(Comparator.comparing(MedicineFinderResponse::getTotalPrice));
		return responses;
	}

}
