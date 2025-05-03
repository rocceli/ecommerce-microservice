package com.ecommerce.service;

/**
 * @author - artest - 03rd May 2025 
 */

import com.ecommerce.controller.CustomerRequest;
import com.ecommerce.controller.CustomerResponse;
import com.ecommerce.customer.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerMapper {

    public Customer toCustomer( CustomerRequest customerRequest ) {

        if ( customerRequest == null ) {
            return null;
        }
        return Customer.builder()
                .id( customerRequest.id() )
                .email( customerRequest.email() )
                .firstName( customerRequest.firstName() )
                .lastName( customerRequest.lastName() )
                .address( customerRequest.address() )
                .build();
    }


    public CustomerResponse fromCustomer( Customer customer ) {

        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress());
    }
}
