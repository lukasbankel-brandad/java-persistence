package de.bas.devcamp.jdbc.spring;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "coffee", schema="jdbc")
@Data
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
}
