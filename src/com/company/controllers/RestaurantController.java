package com.company.controllers;

import com.company.entity.Drink;
import com.company.entity.Restaurant;
import com.company.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController {
    private Restaurant restaurant;
    private int size = 0;
    public RestaurantController(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void addItem(Item item) {
        restaurant.getItemList().add(item);
        size++;
    }
    public List<Item> searchList(String name) {
        List<Item> foods = new ArrayList<Item>();
        for(Item item : restaurant.getItemList()) {
            if(item.getName().contains(name)) {
                foods.add(item);
            }
        }

        return foods;
    }
    public void editItem(int index, Item item) {
        restaurant.getItemList().set(index, item);
    }
    public int searchItem(int id) {
        for(int i = 0; i < restaurant.getItemList().size(); i++) {
            if(restaurant.getItemList().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public void deleteItem(int id) {
        for(Item item : restaurant.getItemList()) {
            if(item.getId() == id) {
                restaurant.getItemList().remove(item);
                size--;
                break;
            }
        }
    }
    public void sellItem(int id) {
        for(Item food : restaurant.getItemList()) {

            if(food.getId() == id) {
                restaurant.getItemList().remove(food);
                restaurant.setBank(restaurant.getBank() + food.getPrice());
                this.size--;
                break;
            }
        }
     }
    public List<Item> getFreeDrinks() {
        List<Item> drinks = new ArrayList<>();
        for(Item item : restaurant.getItemList()) {
            if(item instanceof Drink && item.getPrice() == 0) {
                drinks.add(item);
            }
        }

        return drinks;
    }

    public int getSize() {
        return size;
    }
}
