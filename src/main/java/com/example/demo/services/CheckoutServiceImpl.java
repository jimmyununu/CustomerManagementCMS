package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        Customer customer = purchase.getCustomer();

        String trackingNumber = UUID.randomUUID().toString();

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.addItem(item);
        });

        //debuging
        //System.out.println("saved cart item?");
        cart.setOrderTrackingNumber(trackingNumber);

        cart.setStatus(StatusType.ordered);

        cart.setCustomer(customer);

        cartRepository.save(cart);

    return new PurchaseResponse(trackingNumber);


}
}
