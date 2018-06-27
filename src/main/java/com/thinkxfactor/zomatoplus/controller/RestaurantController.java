package com.thinkxfactor.zomatoplus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@PostMapping("/add")
	public Restaurant addUser(@RequestBody Restaurant res) {
		Restaurant persistedRes=restaurantRepository.save(res);
		return persistedRes;
	}
	@GetMapping("/getAll")
	public List<Restaurant> restaurantList() {
		List<Restaurant> listofres=restaurantRepository.findAll();
		return listofres;
	}
	
	/*@PostMapping("/create")
	public Restaurant userCreate(@RequestBody Restaurant res) {
		System.out.println(res.toString());
		return res;
	}
	@GetMapping("/getAll")
	public List<Restaurant> allRestaurants(List<Restaurant> res) {
		return res;
	}
	@GetMapping("/items")
	public List<Item> allItems(List<Item> items) {
		return items;
	}
	@PostMapping("/addItems")
	public Item userCreate(@RequestBody Item item) {
		System.out.println(item.toString());
		return item;
	}*/
}
