package com.bionexo.provider.domain.worsesupplier;

public class WorseSupplierRequest {

    private String departFrom;
    private String arriveTo;
    private String outboundDate;
    private String inboundDate;
    private int numberOfMedicines;

 	// Added a constructor to make it easier to create new objects WorseSupplierRequest
    public WorseSupplierRequest(String departFrom, String arriveTo, String outboundDate, String inboundDate,
			int numberOfMedicines) {
		super();
		this.departFrom = departFrom;
		this.arriveTo = arriveTo;
		this.outboundDate = outboundDate;
		this.inboundDate = inboundDate;
		this.numberOfMedicines = numberOfMedicines;
	}

	public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveTo() {
        return arriveTo;
    }

    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public void setNumberOfMedicines(int numberOfMedicines) {
        this.numberOfMedicines = numberOfMedicines;
    }
}
