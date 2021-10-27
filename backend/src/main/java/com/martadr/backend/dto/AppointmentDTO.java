package com.martadr.backend.dto;

import java.sql.Time;
import java.time.LocalDate;

public class AppointmentDTO {

    private Long id;
    private LocalDate date;
    private Time time;
    private DoctorDTO doctorDTO;
    private PatientDTO patientDTO;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long id, LocalDate date, Time time, DoctorDTO doctorDTO, PatientDTO patientDTO) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctorDTO = doctorDTO;
        this.patientDTO = patientDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctor(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }
}
