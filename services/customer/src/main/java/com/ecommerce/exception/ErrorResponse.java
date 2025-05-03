package com.ecommerce.exception;

import java.util.Map;

/**
 * @author - artest - 03rd May 2025 
 */
 
public record ErrorResponse(
        Map<String, String> errors
) {
}
