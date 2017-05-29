package com.trivikram.MizuhoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONUtil;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(value = InstrumentController.class, secure = false)
public class MizuhoTestApplicationTests {

	@Test
	public void contextLoads() {
	}
	
		
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InstrumentService instService;

	Instrument mockInst = new Instrument(12, "Inst101", "300.12","20170127","BBG");
			
	String Inst101Json = "{ \"price\":\"300.12\",\"providerName\":\"BBG\",\"id\": 12,\"businessDate\": \"20170127\",\"instrumentName\": \"Inst101\"}";
			
	@Test
	public void getInstruments() throws Exception {
		
		Mockito.when(
				instService.getAllInstruments(
						)).thenReturn(Arrays.asList( mockInst));

		
		
		mockMvc.perform(get("/Instruments")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", is(12)))
		.andExpect(jsonPath("$[0].price", is("300.12")))
		.andExpect(jsonPath("$[0].providerName", is("BBG")))
		.andExpect(jsonPath("$[0].businessDate", is("20170127")))
		.andExpect(jsonPath("$[0].instrumentName", is("Inst101")));
		
		
		
		
	}
	
	
 
}

