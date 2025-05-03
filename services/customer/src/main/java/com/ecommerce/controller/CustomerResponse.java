package com.ecommerce.controller;

import com.ecommerce.customer.Address;

/**
 * @author - artest - 03rd May 2025 
 */

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

}
