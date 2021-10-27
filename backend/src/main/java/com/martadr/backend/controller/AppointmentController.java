package com.martadr.backend.controller;

import com.martadr.backend.business.AppointmentBusiness;
import com.martadr.backend.dto.AppointmentDTO;
import com.martadr.backend.dto.DoctorDTO;
import com.martadr.backend.dto.PatientDTO;
import com.martadr.backend.entities.Appointment;
import com.martadr.backend.entities.Doctor;
import com.martadr.backend.entities.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentBusiness appointmentBusiness;

    public AppointmentController(AppointmentBusiness appointmentBusiness) {
        this.appointmentBusiness = appointmentBusiness;
    }

    public DoctorDTO mappingDoctorToDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty(), doctor.getPeriod(), doctor.getOffice(), doctor.getPhone());
    }

    public PatientDTO mappingPatientToPatientDTO(Patient patient) {
        return new PatientDTO(patient.getId(), patient.getName(), patient.getCpf(), patient.getDate(), patient.getAddress(), patient.getAddress());
    }

    @GetMapping("/all")
    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentBusiness.findAll();

        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment : appointments) {
            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getId(), appointment.getDate(), appointment.getTime(), mappingDoctorToDoctorDTO(appointment.getDoctor()), mappingPatientToPatientDTO(appointment.getPatient()));
            appointmentDTOS.add(appointmentDTO);
        }
        return appointmentDTOS;
    }

    @GetMapping("/{id}")
    public AppointmentDTO find(@PathVariable("id") Long id) {
        Appointment appointment = appointmentBusiness.findById(id);
        if (appointment == null) {
            return null;
        }
        AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getId(), appointment.getDate(), appointment.getTime(), mappingDoctorToDoctorDTO(appointment.getDoctor()), mappingPatientToPatientDTO(appointment.getPatient()));
        return appointmentDTO;
    }

//    @GetMapping
//    public AppointmentDTO find(@RequestParam("name") String name) {
//        Appointment appointment = appointmentBusiness.findName(name);
//        if (appointment == null) {
//            return null;
//        }
//        AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getId(), appointment.getDate(), appointment.getTime(), mappingDoctorToDoctorDTO(appointment.getDoctor()), mappingPatientToPatientDTO(appointment.getPatient()));
//        return appointmentDTO;
//    }

//    @PostMapping
//    public Long createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
//        Appointment appointment = new Appointment(appointmentDTO.getId(), appointmentDTO.getDate(), appointmentDTO.getTime(), appointmentDTO.getDoctor(), appointmentDTO.getPatient());
//        Long id = appointmentBusiness.save(appointment);
//        return id;
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        appointmentBusiness.delete(id);
    }
}
