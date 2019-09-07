package pl.lukasz.zaliczeniedb.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String address;
    private String image;
}
