package com.library.dtos;

import jakarta.validation.constraints.*;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    @NotBlank private String name;
    @NotBlank private String author;
    @NotBlank private String description;
    @Positive private Long stock;
    @DecimalMin(value = "0") private BigDecimal price;
}



