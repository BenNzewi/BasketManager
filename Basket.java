package com.basket.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.basket.manager.exception.ItemNotFoundException;

public class Basket implements IBasket {

	private String userId;
	private Map<String, Item> map;
	
	
	public Basket(){}
	public Basket(String pUserId){
		userId = pUserId;
		map = new HashMap<String, Item>();
	}
	@Override
	public boolean addItem(Item i) {
		// if map already contains item, get item from map and update quantity and price
		if(map.containsKey(i.getItemName())){
			Item item =  map.get(i.getItemName());
			item.setQuantity(item.getQuantity() + i.getQuantity());
			item.setPrice(item.getPrice() + i.getPrice());
			return true;
		}
		
		map.put(i.getItemName(), i);
		return false;
	}

	@Override
	public boolean removeItem(String itemId) throws ItemNotFoundException {
		// remove item if it is found in basket
		if(map.containsKey(itemId)){
			System.out.println("removing item" + map.get(itemId).getItemName());
			map.remove(itemId);
			return true;
		}
		else
			throw new ItemNotFoundException("item with id " + itemId + " not found");
	}

	@Override
	public Item getItemFromBasket(String itemId) throws ItemNotFoundException {
		if(map.containsKey(itemId)){
			System.out.println("removing item" + map.get(itemId).getItemName());
			return map.get(itemId);
		}
		else
			throw new ItemNotFoundException("item with id " + itemId + " not found");
	}

	@Override
	public Collection<Item> getBasketDetails() {
		
		return map.values();
	}

	@Override
	public int productCount() {
		return map.size();
	}

	@Override
	public double getBasketTotalCost() {
		double price = 0.0d;
		Iterator<Item> itr = getBasketDetails().iterator();
		while(itr.hasNext()){
			Item i = itr.next();
			price+=i.getPrice() * i.getQuantity();
		}
		return price;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
