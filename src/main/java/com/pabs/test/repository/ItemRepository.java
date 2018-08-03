package com.pabs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabs.test.model.ItemData;

public interface ItemRepository extends JpaRepository<ItemData, Long>{

}
