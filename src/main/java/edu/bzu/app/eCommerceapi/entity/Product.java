package edu.bzu.app.eCommerceapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "product_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)

public class Product {
    @Id   //declare the primary key
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //indicates that the persistence provider must assign primary keys for the entity using a database identity column.This means they are auto-incremented
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "categoryId", nullable = false)
    private Long categoryId;

    @Column
    private float price;

    @Column(name = "description", nullable = true)
    private String description;

}
