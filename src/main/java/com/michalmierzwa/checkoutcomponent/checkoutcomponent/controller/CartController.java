package com.michalmierzwa.checkoutcomponent.checkoutcomponent.controller;

import com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain.Cart;
import com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain.Item;
import com.michalmierzwa.checkoutcomponent.checkoutcomponent.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(value = "/cart")
public class CartController {

    private Cart cart = new Cart();
    private ItemService items;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.items = itemService;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Item> getAll() {
        return cart.getListOfItems();
    }

    @RequestMapping(value = "/add/{itemName}", method = RequestMethod.GET)
    public List<Item> addToCart(@PathVariable String itemName) {
        for (Item item : items.getListOfItems()) {
            if (item.getName().matches(itemName)) {
                cart.addItem(item);
                break;
            }
        }
        return cart.getListOfItems();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Item> removeFromCart(@PathVariable int id) {
        cart.getListOfItems().remove(id);

        return cart.getListOfItems();
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public double totalPrice() {
        return calculatePrice();
    }

    private double calculatePrice() {
        double price = 0;

        // Create sorted collection using frequency
        Set<Item> uniqueSet = new HashSet<>(cart.getListOfItems());

        // For each item in the uniqueSet...
        for (Item item : uniqueSet) {
            // number of items in a cart
            int n = Collections.frequency(cart.getListOfItems(), item);

            // check if discount price is not 0
            if (item.getDiscountPrice() != 0) {
                // if number of items in cart is equal or greater than discount number
                if (n >= item.getDiscountNumber()) {
                    // number of packs
                    int packs = n / item.getDiscountNumber();

                    // calculate price for items that are in packs and multipriced
                    if (n % item.getDiscountNumber() == 0) {
                        price = price + packs * item.getDiscountPrice();
                    }
                    // calculate price for packs + rest
                    else {
                        int rest = n % item.getDiscountNumber();
                        price = price + packs * item.getDiscountPrice() + rest * item.getPrice();
                    }
                }
                // calculate price if number of items is less than a pack
                else {
                    price = price + n * item.getPrice();
                }
            }
            // calculate price for items without Discount price
            else {
                price = price + n * item.getPrice();
            }
        }
        return price;
    }
}
