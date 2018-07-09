package main.java.SpringDataTest;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String telnum;

    @OneToMany(mappedBy="owner")
    private List<Car> ownedCars;
}
