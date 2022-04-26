package edu.bzu.app.eCommerceapi.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields

public class ProductDto {

    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    private String name;

    private Long categoryId;

    private float price;

    private String description;
}
