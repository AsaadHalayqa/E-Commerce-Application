package edu.bzu.app.eCommerceapi.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields

public class CustomerDto {

    private Long id;

    @NotNull
    @Size(min = 3, max = 250)

    private String name;

    private String email;

    private String city;

    private String address;

    private Long phoneNo;

    private Long CreditCard;
}
