package com.masteringmicroservices.service;

import java.util.List;
import java.util.Optional;

import com.masteringmicroservices.model.Item;

public interface ItemService {

	public List<Item> getAllItems();
	
	public Optional<Item> getItemById(Long id);
	
	public void addItem(Item item);
}
