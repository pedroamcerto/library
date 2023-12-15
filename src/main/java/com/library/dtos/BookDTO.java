package com.library.dtos;

import jakarta.validation.constraints.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class BookDTO {
    @NotBlank private String name;
    @NotBlank private String author;
    @NotBlank private String description;
    @Positive private Long stock;
    @DecimalMin(value = "0") private BigDecimal price;
}



