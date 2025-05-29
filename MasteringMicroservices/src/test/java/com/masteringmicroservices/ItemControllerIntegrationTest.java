package com.masteringmicroservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masteringmicroservices.model.Item;


public class ItemControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetAllItems() throws Exception{
		mockMvc.perform(get("/api/items"))
		       .andExpect(status().isOk())
		       .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		       .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(0)));
	}
	
	@Test
	public void testAddAndGetItem() throws Exception{
		Item item = new Item(1L, "Item1");
		mockMvc.perform(post("/api/items")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(item)))
		.andExpect(status().isOk());
		
		mockMvc.perform(get("api/items"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize(1)))
		.andExpect(jsonPath("$[0].name").value("Item 1"));
	}
}
