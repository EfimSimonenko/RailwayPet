package com.javaschool.SBB.db.entities;


import com.javaschool.SBB.db.entities.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated
    private Roles role;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public User() {
    }

    public User(String email, String password, Roles role, boolean enabled, Passenger passenger) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.passenger = passenger;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
