package tbpapi.thebestprototypeapi.Models;

import jakarta.persistence.*;

@Entity
@Table(
        name = "user",
        schema = "public"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "fullname", nullable = false)
    public String fullname;
    @Column(name = "email", unique = true, nullable = false)
    public String email;
    @Column(name = "password", nullable = false)
    public String password;
    @Column(name = "latitude")
    public double latitude;
    @Column(name = "longtitude")
    public double longtitude;
    @Column(name = "signalpower")
    public int signalpower;
    //networkOperatorName
    @Column(name = "networkoperatorname")
    public String NetworkOperatorName;
    //networkOperatorCode
    @Column(name = "networkoperatorcode")
    public int NetworkOperatorCode;

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
