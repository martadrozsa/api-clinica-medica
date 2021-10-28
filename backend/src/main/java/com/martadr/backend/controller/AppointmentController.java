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
        return mappingAppointmentToDTO(appointments);
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

    @GetMapping
    public List<AppointmentDTO> findAllByPatientId(@RequestParam("patientId") Long patientId) {
        List<Appointment> patients = appointmentBusiness.findAllByPatientId(patientId);
        return mappingAppointmentToDTO(patients);
    }

    public List<AppointmentDTO> mappingAppointmentToDTO(List<Appointment> appointments) {
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        for (Appointment appointment : appointments) {
            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getId(), appointment.getDate(), appointment.getTime(), mappingDoctorToDoctorDTO(appointment.getDoctor()), mappingPatientToPatientDTO(appointment.getPatient()));
            appointmentDTOS.add(appointmentDTO);
        }
        return appointmentDTOS;
    }

    @PostMapping
    public Long createAppointment(@RequestBody AppointmentDTO appointmentDTO) {

        DoctorDTO doctorDTO = appointmentDTO.getDoctorDTO();
        Long idDoctor = doctorDTO.getId();
        Doctor doctor = new Doctor();
        doctor.setId(idDoctor);

        PatientDTO patientDTO = appointmentDTO.getPatientDTO();
        Long idPatient = patientDTO.getId();
        Patient patient = new Patient();
        patient.setId(idPatient);

        Appointment appointment = new Appointment(null, appointmentDTO.getDate(), appointmentDTO.getTime(), doctor, patient);
        Long id = appointmentBusiness.save(appointment);
        return id;
    }

    @PutMapping
    public void update(@RequestBody AppointmentDTO appointmentDTO) {

        DoctorDTO doctorDTO = appointmentDTO.getDoctorDTO();
        Long idDoctor = doctorDTO.getId();
        Doctor doctor = new Doctor();
        doctor.setId(idDoctor);

        PatientDTO patientDTO = appointmentDTO.getPatientDTO();
        Long idPatient = patientDTO.getId();
        Patient patient = new Patient();
        patient.setId(idPatient);

        Appointment appointment = new Appointment(appointmentDTO.getId(), appointmentDTO.getDate(), appointmentDTO.getTime(), doctor, patient);
        appointmentBusiness.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        appointmentBusiness.delete(id);
    }



}
