package com.martadr.backend.business;

import com.martadr.backend.entities.Doctor;
import com.martadr.backend.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorBusiness {

    private final DoctorRepository doctorRepository;

    public DoctorBusiness(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    public Doctor findId(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);

        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        } else {
            return null;
        }
    }

    public Doctor findName(String name) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByName(name);

        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        } else {
            return null;
        }
    }

    public Long save(Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return savedDoctor.getId();
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
