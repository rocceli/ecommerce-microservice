package com.ecommerce.service;

import ch.qos.logback.core.util.StringUtil;
import com.ecommerce.controller.CustomerRequest;
import com.ecommerce.controller.CustomerResponse;
import com.ecommerce.customer.Customer;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * @author - artest - 03rd May 2025 
 */

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    public String createCustomer( CustomerRequest customerRequest ) {

        var customer = customerRepository.save( mapper.toCustomer(customerRequest) );
        return customer.getId();
    }


    public void updateCustomer( @Valid CustomerRequest request ) {

        var customer = customerRepository.findById( request.id() )
                .orElseThrow( () -> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer found with the provided id:: '%s' ", request.id())
                ) );
        mergerCustomer(customer, request);
        customerRepository.save( customer );
    }


    private void mergerCustomer( Customer customer, CustomerRequest request ) {

        if( StringUtils.isNotBlank( customer.getEmail() ) ) {
            customer.setEmail( customer.getEmail().toLowerCase() );
        }
        if( StringUtils.isNotBlank( customer.getFirstName() ) ) {
            customer.setFirstName( customer.getFirstName().toLowerCase() );
        }
        if( StringUtils.isNotBlank( customer.getLastName() ) ) {
            customer.setLastName( customer.getLastName().toLowerCase() );
        }
        if( request.address() != null ) {
            customer.setAddress( request.address() );
        }
    }


    public List<CustomerResponse> findAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map( mapper::fromCustomer )
                .collect( Collectors.toList() );
    }


    public Boolean existsById( String customerId ) {

        return customerRepository.existsById( customerId );
    }


    public CustomerResponse findById( String customerId ) {

        return customerRepository.findById( customerId )
                .map( mapper::fromCustomer )
                .orElseThrow( () -> new CustomerNotFoundException( format( " No customer found with the provided id:: '%s' ", customerId ) ));
    }


    public void deleteCustomer( String customerId ) {

        customerRepository.deleteById( customerId );
    }
}
