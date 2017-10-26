package com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> listOfItems = new ArrayList<>();

    // Public constructor - clears the list on the start of the application
    public Cart() {
        listOfItems.clear();
    }

    public void addItem(Item item) {
        listOfItems.add(item);
    }
    public void removeItem(int id) {
        listOfItems.remove(id);
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }
}
