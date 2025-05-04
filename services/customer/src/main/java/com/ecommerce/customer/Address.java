package com.ecommerce.customer;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * @author - artest - 03rd May 2025 
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
@Document
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
