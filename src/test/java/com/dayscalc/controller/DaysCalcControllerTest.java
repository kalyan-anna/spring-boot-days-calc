package com.dayscalc.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DaysCalcControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testZeroDaysCount() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-26")
				.param("endDate", "2019-11-26")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("result"))
		.andExpect(model().hasNoErrors())
		.andExpect(model().attribute("daysCount", equalTo(0L)));
	}
	
	@Test
	public void test1DaysCount() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-26")
				.param("endDate", "2019-11-27")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("result"))
		.andExpect(model().hasNoErrors())
		.andExpect(model().attribute("daysCount", equalTo(1L)));
	}
	
	@Test
	public void testDaysCount() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-26")
				.param("endDate", "2020-11-27")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("result"))
		.andExpect(model().hasNoErrors())
		.andExpect(model().attribute("daysCount", equalTo(367L)));
	}
	
	@Test
	public void testStartDateMandatoryError() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "")
				.param("endDate", "2019-11-27")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeHasFieldErrors("dateForm", "startDate"))
		.andExpect(content().string(containsString("Start date is required.")));
	}
	
	@Test
	public void testStartDateInvalidError() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "sdfsdfsd")
				.param("endDate", "2019-11-27")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeHasFieldErrors("dateForm", "startDate"))
		.andExpect(content().string(containsString("Start date should be yyyy-MM-dd format.")));
	}
	
	@Test
	public void testEndDateMandatoryError() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-27")
				.param("endDate", "")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeHasFieldErrors("dateForm", "endDate"))
		.andExpect(content().string(containsString("End date is required.")));
	}
	
	@Test
	public void testEndDateInvalidError() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-27")
				.param("endDate", "dsfdsfsdfds")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeHasFieldErrors("dateForm", "endDate"))
		.andExpect(content().string(containsString("End date should be yyyy-MM-dd format.")));
	}
	
	@Test
	public void testEndDateNotBeforeStartDateError() throws Exception {
		mockMvc.perform(post("/result").accept(MediaType.TEXT_HTML)
				.param("startDate", "2019-11-27")
				.param("endDate", "2019-11-26")
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeHasFieldErrors("dateForm", "endDate"))
		.andExpect(content().string(containsString("End date cannot be before start date.")));
	}
}
