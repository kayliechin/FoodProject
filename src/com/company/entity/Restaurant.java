package com.company.entity;


import com.company.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<Item> itemList;
    private int bank;
    public Restaurant(int id, String name, int bank) {
        this.id = id;
        this.name = name;
        this.itemList = new ArrayList<Item>();
        this.bank = bank;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", bank=" + bank +
                '}';
    }
}
