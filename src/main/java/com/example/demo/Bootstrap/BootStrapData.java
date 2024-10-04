package com.example.demo.Bootstrap;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.dao.ExcursionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;
    private final ExcursionRepository excursionRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CartItemRepository cartItemRepository, CustomerRepository customerRepository, ExcursionRepository excursionRepository, DivisionRepository divisionRepository) {
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
        this.excursionRepository = excursionRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 1) {
            Customer c1 = new Customer();
            Customer c2 = new Customer();
            Customer c3 = new Customer();
            Customer c4 = new Customer();
            Customer c5 = new Customer();

            c1.setFirstName("Bob");
            c1.setLastName("Billy");
            c1.setPostal_code("21042");
            c1.setAddress("202 meade street");
            c1.setPhone("5054231541");
            c1.setCreate_date(new Date());
            c1.setLast_update(new Date());
            customerRepository.save(c1);

            c2.setFirstName("Joe");
            c2.setLastName("Billy");
            c2.setPostal_code("29541");
            c2.setAddress("52 whitetail dr");
            c2.setPhone("6069396815");
            c2.setCreate_date(new Date());
            c2.setLast_update(new Date());
            customerRepository.save(c2);

            c3.setFirstName("Bob");
            c3.setLastName("Billy");
            c3.setPostal_code("21042");
            c3.setAddress("8100 idx road");
            c3.setPhone("4812549025");
            c3.setCreate_date(new Date());
            c3.setLast_update(new Date());
            customerRepository.save(c3);

            c4.setFirstName("Ryan");
            c4.setLastName("Billy");
            c4.setPostal_code("72176");
            c4.setAddress("45 lakewood dr");
            c4.setPhone("8668675309");
            c4.setCreate_date(new Date());
            c4.setLast_update(new Date());
            customerRepository.save(c4);

            c5.setFirstName("Tingting");
            c5.setLastName("Han");
            c5.setPostal_code("41144");
            c5.setAddress("24 martin ave");
            c5.setPhone("2394568974");
            c5.setCreate_date(new Date());
            c5.setLast_update(new Date());
            customerRepository.save(c5);

            System.out.println("Sample Customers added");

        }else{ System.out.println("Could not create Sample customers");}



    }
}
