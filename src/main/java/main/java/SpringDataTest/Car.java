package main.java.SpringDataTest;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;
}
