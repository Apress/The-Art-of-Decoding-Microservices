package com.masteringmicroservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.masteringmicroservices.model.Item;
import com.masteringmicroservices.service.ItemService;

public class ItemServiceTest {

	@InjectMocks
	private ItemService itemService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		
		Item item1 = new Item(1L, "Item 1");
		Item item2 = new Item(2L, "Item 2");
		itemService.addItem(item1);
		itemService.addItem(item1);
	}
	
	@Test
	public void testGetAllItems() {
		List<Item> items = itemService.getAllItems();
		assertEquals(2, items.size());
		
	}
	
	@Test
	public void testGetItemById() {
		Optional<Item> item = itemService.getItemById(1L);
		assertTrue(item.isPresent());
		assertEquals("Item 1", item.get().getName());
	}
}
