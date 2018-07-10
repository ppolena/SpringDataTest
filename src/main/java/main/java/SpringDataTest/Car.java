package main.java.SpringDataTest;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;

    private String name;

    private int year;

    private Condition condition;

    @ManyToOne
    private Person owner;
}
