package com.pabs.test.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pabs.test.model.ItemData;
import com.pabs.test.model.Order;
import com.pabs.test.model.OrderDetails;
import com.pabs.test.service.ItemService;
import com.pabs.test.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	public ItemService itemService;
	
	@Autowired
	public OrderService orderService;
	
	@GetMapping("/LoadOrder")
	public String loadOrder(Model model) {
		
		Order order = new Order();
		Set<OrderDetails> listDetails = new HashSet<OrderDetails>();
		
		listDetails.add(new OrderDetails());
		order.setOrderDetails(listDetails);
		model.addAttribute("orderForm",order);
		
		return "transaction/order_detail"; 
	}
	
	@PostMapping(value="/RowAddSub")
	public String addRowDetail(@ModelAttribute Order orderForm, BindingResult result, Model model) {
		Set<OrderDetails> listOrders = new HashSet<OrderDetails>();
		if (orderForm.getOrderDetails() != null) {
			orderForm.getOrderDetails().add(new OrderDetails());
		} else {
			listOrders.add(new OrderDetails());
			orderForm.setOrderDetails(listOrders);
		}
		
		model.addAttribute("orderForm",orderForm);
		return "transaction/order_detail";
	}
	
	@PostMapping("/CreateOrder")
	public String createOrder(Order order, Model model) {
		 return "transaction/order_detail";
	}
	
	@ModelAttribute("listItems")
	public List<ItemData> getAllItems(){
		return itemService.retrieveAllItems();
	}
}
