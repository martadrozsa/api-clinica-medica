package com.martadr.backend.dto;


import java.time.LocalDate;

public class PatientDTO {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate date;
    private String address;
    private String phone;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String name, String cpf, LocalDate date, String address, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.date = date;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
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
}
