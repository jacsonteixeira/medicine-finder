package com.bionexo.provider.domain.medicinefinder;

public class MedicineFinderResponse {

	private String medicineName;
	private String supplier;
	private double totalPrice;
	private String departureCountry;
	private String destinationCountry;
	private String departureDate;
	private String estimatedArrival;

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public void setDepartureCountry(String departureCountry) {
		this.departureCountry = departureCountry;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
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
