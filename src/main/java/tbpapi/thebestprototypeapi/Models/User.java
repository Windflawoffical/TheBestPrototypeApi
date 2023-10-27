package tbpapi.thebestprototypeapi.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "user",
        schema = "public"
)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fullname", nullable = false)
    private String fullname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longtitude")
    private double longtitude;
    @Column(name = "signalpower")
    private int signalpower;

}
