package com.michalmierzwa.checkoutcomponent.checkoutcomponent.repository;

import com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private List<Item> listOfItems = new ArrayList<>();

    public ItemRepository() {
        listOfItems.add(new Item("A", 40, 3, 70));
        listOfItems.add(new Item("B", 10, 2, 15));
        listOfItems.add(new Item("C", 30, 4, 60));
        listOfItems.add(new Item("D", 25, 2, 40));
        listOfItems.add(new Item("E", 20, 2, 0));

    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }
}
