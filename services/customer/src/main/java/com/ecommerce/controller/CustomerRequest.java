package com.ecommerce.controller;

import com.ecommerce.customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * @author - artest - 03rd May 2025 
 */

public record CustomerRequest(
         String id,

         @NotNull(message = "Customer first name required")
         String firstName,

         @NotNull(message = "Customer last name required")
         String lastName,

         @NotNull(message = "Customer email required")
         @Email(message = "Customer email not a valid email address ")
         String email,

         Address address
) {

}
