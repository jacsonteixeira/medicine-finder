package com.bionexo.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bionexo.provider.domain.bestsuplier.BestSupplierEntity;
import com.bionexo.provider.domain.medicinefinder.MedicineFinderRequest;
import com.bionexo.provider.domain.medicinefinder.MedicineFinderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MedicineFinderService {

	public List<MedicineFinderResponse> findByRequestFields(MedicineFinderRequest request) {
		getBestSupplierFromAPI(request);
		return null;
	}
	
	public List<BestSupplierEntity> getBestSupplierFromAPI(MedicineFinderRequest request){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/best-supplier")
		        .queryParam("origin", request.getOrigin())
		        .queryParam("destination", request.getDestination())
		        .queryParam("departureDate", request.getDepartureDate())
		        .queryParam("estimatedArrival", request.getEstimatedArrival())
		        .queryParam("quantityCount", request.getNumberOfMedicine());

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = response.getBody();
		return null;
	}
}
