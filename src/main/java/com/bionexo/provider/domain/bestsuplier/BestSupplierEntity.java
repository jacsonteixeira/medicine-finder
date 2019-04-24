package com.bionexo.provider.domain.bestsuplier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionexo.util.enums.MedicineType;

@Entity
@Table(name = "BESTSUPPLIER")
public class BestSupplierEntity implements Serializable {

	private static final long serialVersionUID = 1543237945949085625L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String medicineName;

	@Column
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	@Column
	private MedicineType medicineType;

	@Column
	private String departureCountryCode;

	@Column
	private String destinationCountryCode;

	@Column
	private LocalDateTime departureDate;

	@Column
	private LocalDateTime estimatedArrival;

	@Column
	private Integer numberOfMedicines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public MedicineType getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(MedicineType medicineType) {
		this.medicineType = medicineType;
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

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getEstimatedArrival() {
		return estimatedArrival;
	}

	public void setEstimatedArrival(LocalDateTime estimatedArrival) {
		this.estimatedArrival = estimatedArrival;
	}

	public Integer getNumberOfMedicines() {
		return numberOfMedicines;
	}

	public void setNumberOfMedicines(Integer numberOfMedicines) {
		this.numberOfMedicines = numberOfMedicines;
	}

}
