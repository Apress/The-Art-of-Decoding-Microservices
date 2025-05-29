package com.masteringmicroservices.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masteringmicroservices.model.Item;
import com.masteringmicroservices.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	private List<Item> items = new ArrayList<>();
	
	
	@Override
	public List<Item> getAllItems() {
		
		return items;
	}

	@Override
	public Optional<Item> getItemById(Long id) {
		
		return items.stream().filter(item -> item.getId().equals(id)).findFirst();
	}

	@Override
	public void addItem(Item item) {
		items.add(item);

	}

}
