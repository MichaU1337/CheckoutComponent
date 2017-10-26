# Checkout Component 
Project created according to Project.jpg file

At the beggining of this project I started creating it with JPA, but in the file there was nothing about using any persistance technology.

The project consists of two lists: The ItemRepository class has one list of items that can be added to the Cart.
The second list consists of items already added.

You may add items to the cart only from the first list.

# API:
Show all items that can be added to cart:

/item/show

Show all items that have been already added to the cart:

/cart/show

Add an item to the cart:

/cart/add/{itemname}

Remove an item from the cart:

/cart/delete/{id}

The main goal of this project was to calculate the price for all of the items in the cart:

/cart/total
