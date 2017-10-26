package com.michalmierzwa.checkoutcomponent.checkoutcomponent.domain;

public class Item {

    private String name;
    private double price;
    private int discountNumber;
    private double discountPrice;

    public Item(String name, double price, int discountNumber, double discountPrice) {
        this.name = name;
        this.price = price;
        this.discountNumber = discountNumber;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getDiscountNumber() {
        return discountNumber;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }
}
