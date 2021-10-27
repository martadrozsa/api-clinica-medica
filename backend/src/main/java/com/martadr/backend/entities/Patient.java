package com.martadr.backend.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column
    private LocalDate date;

    @Column
    private String address;

    @Column
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(Long id, String name, String cpf, LocalDate date, String address, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.date = date;
        this.address = address;
        this.phone = phone;
    }

    public Patient(String name, String cpf, LocalDate date, String address, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.date = date;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

}
