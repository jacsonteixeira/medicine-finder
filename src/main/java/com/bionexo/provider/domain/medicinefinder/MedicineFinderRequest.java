package com.bionexo.provider.domain.medicinefinder;

public class MedicineFinderRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String estimatedArrival;
    private int numberOfMedicine;

    // Added a constructor to make it easier to create new objects MedicineFinderRequest
    public MedicineFinderRequest(String origin, String destination, String departureDate, String estimatedArrival,
			int numberOfMedicine) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.estimatedArrival = estimatedArrival;
		this.numberOfMedicine = numberOfMedicine;
	}

	public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public int getNumberOfMedicine() {
        return numberOfMedicine;
    }

    public void setNumberOfMedicine(int numberOfMedicine) {
        this.numberOfMedicine = numberOfMedicine;
    }
}
