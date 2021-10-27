package com.martadr.backend.repository;

import com.martadr.backend.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    //Optional<Appointment> findByName(String name);
}
