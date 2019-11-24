package com.dayscalc.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class DateForm {

	@NotNull()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public DateForm() {
		this.startDate = new Date();
		this.endDate = new Date();
	}
	
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
