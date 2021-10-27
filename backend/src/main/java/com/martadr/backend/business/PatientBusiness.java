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

    public Patient findId(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        return optionalPatient.orElse(null);
    }

    public Patient findName(String name) {
        Optional<Patient> optionalPatient = patientRepository.findByName(name);

        return optionalPatient.orElse(null);
    }

    public Long save(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.getId();
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
