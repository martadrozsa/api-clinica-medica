package com.martadr.backend.controller;

import com.martadr.backend.business.PatientBusiness;
import com.martadr.backend.dto.PatientDTO;
import com.martadr.backend.entities.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientBusiness patientBusiness;

    private PatientController(PatientBusiness patientBusiness) {
        this.patientBusiness = patientBusiness;
    }

    @GetMapping("/all")
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientBusiness.findAll();

        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            PatientDTO patientDTO = new PatientDTO(patient.getId(), patient.getName(), patient.getDate(), patient.getAddress(), patient.getPhone());
            patientDTOS.add(patientDTO);
        }
        return patientDTOS;
    }

    @GetMapping("/{id}")
    public PatientDTO find(@PathVariable("id") Long id) {
        Patient patient = patientBusiness.find(id);
        if (patient == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO(patient.getId(), patient.getName(), patient.getDate(), patient.getAddress(), patient.getAddress());
        return patientDTO;
    }

    @GetMapping
    public PatientDTO find(@RequestParam("name") String name) {
        Patient patient = patientBusiness.find(name);
        if (patient == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO(patient.getId(), patient.getName(), patient.getDate(), patient.getAddress(), patient.getAddress());
        return patientDTO;
    }

    @PostMapping
    public Long createPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getName(), patientDTO.getDate(), patientDTO.getAddress(), patientDTO.getPhone());
        Long id = patientBusiness.save(patient);
        return id;
    }

    @PutMapping
    public void update(@RequestBody PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getId(), patientDTO.getName(), patientDTO.getDate(), patientDTO.getAddress(), patientDTO.getPhone());

        patientBusiness.save(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        patientBusiness.delete(id);
    }

}
