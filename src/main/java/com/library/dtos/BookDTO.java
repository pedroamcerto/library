package com.library.dtos;

import java.math.BigDecimal;

public record BookDTO(
        String name,
        String author,
        String description,
        Long stock,
        BigDecimal price) {



}
