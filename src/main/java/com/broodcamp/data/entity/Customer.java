package com.broodcamp.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String name;

    @NotBlank
    @Size(min = 5, max = 255)
    private String email;

    @Min(value = 18)
    private int age;

    /**
     * Because id is being hidden by Spring REST Data JPA
     */
    @Transient
    private Long entityId;

    public Customer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getEntityId() {
        return id;
    }
}
