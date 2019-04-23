package com.bionexo.util.enums;

public enum MedicineType {
	P("PILL"), L("LIQUID");

	private String abbreviation;
	
	private MedicineType(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
