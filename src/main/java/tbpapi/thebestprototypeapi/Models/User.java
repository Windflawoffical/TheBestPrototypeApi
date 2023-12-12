package tbpapi.thebestprototypeapi.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "users",
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
    @Column(name = "networkoperatorname")
    private String NetworkOperatorName;
    @Column(name = "networkoperatorcode")
    private int NetworkOperatorCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public int getSignalpower() {
        return signalpower;
    }

    public void setSignalpower(int signalpower) {
        this.signalpower = signalpower;
    }

    public String getNetworkOperatorName() {
        return NetworkOperatorName;
    }

    public void setNetworkOperatorName(String networkOperatorName) {
        NetworkOperatorName = networkOperatorName;
    }

    public int getNetworkOperatorCode() {
        return NetworkOperatorCode;
    }

    public void setNetworkOperatorCode(int networkOperatorCode) {
        NetworkOperatorCode = networkOperatorCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", signalpower=" + signalpower +
                ", NetworkOperatorName='" + NetworkOperatorName + '\'' +
                ", NetworkOperatorCode=" + NetworkOperatorCode +
                '}';
    }
}
