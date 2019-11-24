package com.dayscalc.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class DateRange {

	@NotBlank(message = "Date is mandatory")
	private Date startDate;

	@NotBlank(message = "Date is mandatory")
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
