package com.masteringmicroservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masteringmicroservices.model.Item;


@RestController
@RequestMapping("/api/items")
public class ItemController {

	private List<Item> itemList = new ArrayList<>();
	
	@GetMapping
	public List<Item> getAllItems(){
		return itemList;
	}
	
	@GetMapping("/{id}")
	public Optional<Item> getItemById(@PathVariable Long id){
		return itemList.stream().filter(item -> item.getId().equals(id)).findFirst();
	}
	
	@PostMapping
	public Item createItem(@RequestBody Item item) {
		
		item.setId( (long) (itemList.size() + 1) );
		itemList.add(item);
		return item;
	}
	
	@PutMapping("/{id}")
	public Optional<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails){
		return itemList.stream().filter(item -> item.getId().equals(id)).findFirst().map(item -> {
			 item.setName(itemDetails.getName());
			 return item;
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id) {
		itemList.removeIf(item -> item.getId().equals(id));
	}
}
