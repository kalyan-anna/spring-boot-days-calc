package com.dayscalc.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class DateForm {

	@NotNull()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@NotNull()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	public DateForm() {
		this.startDate = LocalDate.now();
		this.endDate = LocalDate.now();
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
