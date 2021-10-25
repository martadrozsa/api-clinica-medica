package com.martadr.backend.controller;

import com.martadr.backend.business.DoctorBusiness;
import com.martadr.backend.dto.DoctorDTO;
import com.martadr.backend.entities.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorBusiness doctorBusiness;

    public DoctorController(DoctorBusiness doctorBusiness) {
        this.doctorBusiness = doctorBusiness;
    }

    @GetMapping("/all")
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorBusiness.findAll();

        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorDTO doctorDTO = new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty(), doctor.getPeriod(), doctor.getOffice(), doctor.getPhone());
            doctorDTOS.add(doctorDTO);
        }
        return doctorDTOS;
    }

    @GetMapping("/{id}")
    public DoctorDTO find(@PathVariable("id") Long id) {
        Doctor doctor = doctorBusiness.findId(id);
        if (doctor == null) {
            return null;
        }
        DoctorDTO doctorDTO = new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty(), doctor.getPeriod(), doctor.getOffice(), doctor.getPhone());
        return doctorDTO;
    }

    @GetMapping
    public DoctorDTO find(@RequestParam("name") String name) {
        Doctor doctor = doctorBusiness.findName(name);
        if (doctor == null) {
            return null;
        }
        DoctorDTO doctorDTO = new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getSpecialty(), doctor.getPeriod(), doctor.getOffice(), doctor.getPhone());
        return doctorDTO;
    }

    @PostMapping
    public Long createDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getName(), doctorDTO.getCrm(), doctorDTO.getSpecialty(), doctorDTO.getPeriod(), doctorDTO.getOffice(), doctorDTO.getPhone());
        Long id = doctorBusiness.save(doctor);
        return id;
    }

    @PutMapping
    public void update(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getName(), doctorDTO.getCrm(), doctorDTO.getSpecialty(), doctorDTO.getPeriod(), doctorDTO.getOffice(), doctorDTO.getPhone());

        doctorBusiness.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        doctorBusiness.delete(id);
    }
    
}
