package com.example.socks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "socks")
public class Socks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String color;
    private int cottonPart;
    private Integer quantity;
}
