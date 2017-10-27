package com.michalmierzwa.checkoutcomponent.checkoutcomponent.controller;

import com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain.Item;
import com.michalmierzwa.checkoutcomponent.checkoutcomponent.repository.ItemRepository;
import com.michalmierzwa.checkoutcomponent.checkoutcomponent.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/item")
public class ItemController {

    private ItemService items;

    @Autowired
    public void setItemService(ItemService itemService){
        this.items = itemService;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Item> getAll() {
        return items.getListOfItems();
    }

//    @RequestMapping(value = "/add/{name}/{price}", method = RequestMethod.GET)
//    public List<Item> addToCart(@PathVariable("name") String name, @PathVariable("price") int price) {
//        // Add item to all item list
//        items.getListOfItems().add(new Item(name, price));
//
//        // Update new list with the repository
//        items.setListOfItems(items.getListOfItems());
//
//
//        return items.getListOfItems();
//    }
}
