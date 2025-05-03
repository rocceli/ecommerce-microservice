package com.ecommerce.repository;

import com.ecommerce.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author - artest - 03rd May 2025 
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
