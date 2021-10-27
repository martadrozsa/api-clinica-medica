package com.martadr.backend.entities;

import com.martadr.backend.entities.enums.office.Office;
import com.martadr.backend.entities.enums.period.Period;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private Integer crm;

    @Column
    private String specialty;

    @Column
    private Period period;

    @Column
    private Office office;

    @Column
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(Long id, String name, Integer crm, String specialty, Period period, Office office, String phone) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.specialty = specialty;
        this.period = period;
        this.office = office;
        this.phone = phone;
    }

    public Doctor(String name, Integer crm, String specialty, Period period, Office office, String phone) {
        this.name = name;
        this.crm = crm;
        this.specialty = specialty;
        this.period = period;
        this.office = office;
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

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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
