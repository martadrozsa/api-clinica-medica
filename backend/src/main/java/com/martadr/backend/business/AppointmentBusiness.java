package com.martadr.backend.business;

import com.martadr.backend.entities.Appointment;
import com.martadr.backend.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentBusiness {

    private final AppointmentRepository appointmentRepository;

    public AppointmentBusiness(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    public Appointment findById(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        return optionalAppointment.orElse(null);
    }

//    public Appointment findName(String name) {
//        Optional<Appointment> optionalAppointment = appointmentRepository.findByName(name);
//
//        return optionalAppointment.orElse(null);
//    }

//    public Long save(Appointment appointment) {
//        Appointment savedAppointment = appointmentRepository.save(appointment);
//        return savedAppointment.getId();
//    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

}
