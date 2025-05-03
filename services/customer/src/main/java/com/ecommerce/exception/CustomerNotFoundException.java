package com.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author - artest - 03rd May 2025 
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {

    private final String msg;
}
