package com.martadr.backend.dto;

import com.martadr.backend.entities.enums.office.Office;
import com.martadr.backend.entities.enums.period.Period;

import java.time.LocalDate;

public class DoctorDTO {

    private Long id;
    private String name;
    private Integer crm;
    private String specialty;
    private Period period;
    private Office office;
    private String phone;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, Integer crm, String specialty, Period period, Office office, String phone) {
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
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
}
