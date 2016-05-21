package com.basket.manager;

import java.util.Collection;

import com.basket.manager.exception.ItemNotFoundException;

public interface IBasket {

	boolean addItem(Item i);
	boolean removeItem(String itemId) throws ItemNotFoundException;
	Item getItemFromBasket(String itemId) throws ItemNotFoundException;
	Collection<Item> getBasketDetails();
	int productCount();
	double getBasketTotalCost();
	
}
