package com.martadr.backend.business;

import com.martadr.backend.entities.Patient;
import com.martadr.backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientBusiness {

    private final PatientRepository patientRepository;

    public PatientBusiness(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public Patient find(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null;
        }
    }


    public Patient find(String name) {
        Optional<Patient> optionalPatient = patientRepository.findByName(name);

        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null;
        }
    }

    public Long save(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.getId();
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
