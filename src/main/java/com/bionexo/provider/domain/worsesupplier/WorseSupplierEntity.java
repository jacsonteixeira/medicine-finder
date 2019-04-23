package com.bionexo.provider.domain.worsesupplier;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WORSESUPPLIER")
public class WorseSupplierEntity implements Serializable {

	private static final long serialVersionUID = -8757210201235185143L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String medicine;

	@Column
	private Long totalBasePrice;

	@Column
	private Long tax;

	@Column
	private Long discount;

	@Column
	private String departureCountryName;

	@Column
	private String arrivalCountryName;

	@Column
	private LocalDateTime outboundDateTime;

	@Column
	private LocalDateTime inboundDateTime;

	@Column
	private Integer numberOfMedicines;

	public Long getId() {
		return id;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalBasePrice() {
		return totalBasePrice;
	}

	public void setTotalBasePrice(Long totalBasePrice) {
		this.totalBasePrice = totalBasePrice;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public String getDepartureCountryName() {
		return departureCountryName;
	}

	public void setDepartureCountryName(String departureCountryName) {
		this.departureCountryName = departureCountryName;
	}

	public String getArrivalCountryName() {
		return arrivalCountryName;
	}

	public void setArrivalCountryName(String arrivalCountryName) {
		this.arrivalCountryName = arrivalCountryName;
	}

	public LocalDateTime getOutboundDateTime() {
		return outboundDateTime;
	}

	public void setOutboundDateTime(LocalDateTime outboundDateTime) {
		this.outboundDateTime = outboundDateTime;
	}

	public LocalDateTime getInboundDateTime() {
		return inboundDateTime;
	}

	public void setInboundDateTime(LocalDateTime inboundDateTime) {
		this.inboundDateTime = inboundDateTime;
	}

	public Integer getNumberOfMedicines() {
		return numberOfMedicines;
	}

	public void setNumberOfMedicines(Integer numberOfMedicines) {
		this.numberOfMedicines = numberOfMedicines;
	}

}
