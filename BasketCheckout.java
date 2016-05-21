package com.basket.manager.main;

import java.util.Iterator;
import java.util.Scanner;

import com.basket.manager.Basket;
import com.basket.manager.Item;

public class BasketCheckout {
	
	public static void checkoutBasket()
	{
		Scanner scan = new Scanner(System.in);
		
		String itemName = null;
		int qty;
		double price;
		
		System.out.println(readMe());
		
		String  userId;
		System.out.println("Enter userId (First Name): ");
		userId = scan.next();
		String addItemToBasket = "y";
		Basket basket = new Basket(userId);
		boolean itemNotExits = true;
		do{	
			Items.getItemNames();
			System.out.println("Enter ItemName: ");
			itemName = scan.next();
			while(itemNotExits){
				if(Items.contains(itemName)){
					itemNotExits = false;
					continue;
				}
				else{
					System.out.println("Invalid ItemName, Please try again using name from Item List: ");
					itemName = scan.next(); 
				}
				
			}
			
			System.out.println("Enter quantity: ");
			qty = scan.nextInt();
			
			System.out.println("Enter price: ");
			price = scan.nextDouble();
			
			basket.addItem(new Item(itemName, qty, price));
			
			System.out.println("Add more items to basket(y/n)? ");
			addItemToBasket = scan.next();
			itemNotExits = true;
		}
		while(addItemToBasket.equals("y"));
		
	    System.out.println("\nNo. of Products : "+basket.productCount());
	    System.out.println ("Basket Owned By: "+basket.getUserId());
	    
	    System.out.println ("Basket Total: " +basket.getBasketTotalCost());
        final Iterator<Item> it = basket.getBasketDetails().iterator();
        while(it.hasNext()){
            System.out.println (it.next().toString());
        }
        scan.close();
	}
	
	public static String readMe(){
		return "----Basket Manager----\n" + 
				"\nThis program takes a basket of items and outputd its total cost."+
				"\nThe basket can contain the following items:"+
				"\nBananas "+
				"\nOranges "+
				"\nApples "+
				"\nLemons "+
				"\nPeaches " +
				"\nAssumption - User will input prices & quantity for items.\n";
	}
	
	public enum Items
	{
		Bananas, Oranges, Apples, Lemons, Peaches;

	    public static void getItemNames() {
	    	StringBuilder bd = new StringBuilder();
	    	bd.append("Pick from the following Items: ");
	    	boolean isFirst = true;
	    	for(Items value: Items.values()){
	    		if(isFirst){
	    			bd.append(value.name());
	    			isFirst= false;
	    		}
	    		else{
		    		bd.append(",");		
		    		bd.append(value.name());
	    		}
	    	}
	    	System.out.println(bd.toString());
	    }
	    
	    public static boolean contains(String s) {
	        try {
	        	Items.valueOf(s);
	            return true;
	        } 
	        catch (Exception e) {
	            return false;
	        }
	    }
	}

}
