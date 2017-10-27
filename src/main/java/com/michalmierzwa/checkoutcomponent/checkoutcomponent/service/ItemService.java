package com.michalmierzwa.checkoutcomponent.checkoutcomponent.service;

import com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain.Item;
import com.michalmierzwa.checkoutcomponent.checkoutcomponent.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getListOfItems(){
        return itemRepository.getListOfItems();
    }

}
