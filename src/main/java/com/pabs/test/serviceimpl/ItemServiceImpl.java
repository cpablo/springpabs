package com.pabs.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabs.test.model.ItemData;
import com.pabs.test.repository.ItemRepository;
import com.pabs.test.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	public ItemRepository itemRepository;

	@Override
	public List<ItemData> retrieveAllItems() {
		return itemRepository.findAll();
	}
	
}
