package com.beginner.orderhub.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderRequest(

        @Valid
        @NotEmpty(message = "Items cannot be empty")
        List<OrderItemRequest> items
) {

    public record OrderItemRequest(
            @NotNull(message = "productId is required")
            Long productId,

            @NotBlank(message = "productName is required")
            String productName,

            @Min(value = 1, message = "Quantity cannot be a less 1")
            int quantity,

            @NotNull(message = "price is required")
            @DecimalMin(value = "0.01", message = "Price must be greater than 1")
            BigDecimal price
    ){

    }
}
