package com.bionexo.provider.domain.bestsuplier;

public class BestSupplierResponse {

	private String medicineName;
	private double price;
	private String medicineType;
	private String departureCountryCode;
	private String destinationCountryCode;
	private String departureDate; 
	private String estimatedArrival; 

	public BestSupplierResponse() {
		super();
	}

	public BestSupplierResponse(String medicineName, double price, String medicineType, String departureCountryCode,
			String destinationCountryCode, String departureDate, String estimatedArrival) {
		super();
		this.medicineName = medicineName;
		this.price = price;
		this.medicineType = medicineType;
		this.departureCountryCode = departureCountryCode;
		this.destinationCountryCode = destinationCountryCode;
		this.departureDate = departureDate;
		this.estimatedArrival = estimatedArrival;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepartureCountryCode() {
		return departureCountryCode;
	}

	public void setDepartureCountryCode(String departureCountryCode) {
		this.departureCountryCode = departureCountryCode;
	}

	public String getDestinationCountryCode() {
		return destinationCountryCode;
	}

	public void setDestinationCountryCode(String destinationCountryCode) {
		this.destinationCountryCode = destinationCountryCode;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getEstimatedArrival() {
		return estimatedArrival;
	}

	public void setEstimatedArrival(String estimatedArrival) {
		this.estimatedArrival = estimatedArrival;
	}
}
