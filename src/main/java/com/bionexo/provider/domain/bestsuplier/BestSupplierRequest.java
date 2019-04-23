package com.bionexo.provider.domain.bestsuplier;

public class BestSupplierRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String estimatedArrival;
    private int quantityCount;
    
    public BestSupplierRequest(String origin, String destination, String departureDate, String estimatedArrival,
			int quantityCount) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.estimatedArrival = estimatedArrival;
		this.quantityCount = quantityCount;
	}
	
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(String estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }

    public int getQuantityCount() {
        return quantityCount;
    }

    public void setQuantityCount(int quantityCount) {
        this.quantityCount = quantityCount;
    }
}
