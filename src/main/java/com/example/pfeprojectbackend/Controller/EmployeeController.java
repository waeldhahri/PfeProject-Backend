package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.service.IServiceEmploye;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {


    private final IServiceEmploye iServiceEmploye;


    @GetMapping("")
    public List<Employe> getAllEmploye(){

        return iServiceEmploye.getAllEmployes();

    }


    @PostMapping("")
    public Employe createEmploye(@Valid @RequestBody Employe employe){

        return iServiceEmploye.createEmploye(employe);
    }

    @GetMapping("/{employeeId}")
    public Employe findEmployeById(@PathVariable Long employeeId){

        return iServiceEmploye.findEmployeById(employeeId);
    }


    @DeleteMapping("/{employeeId}")
    public void deleteEmploye(@PathVariable Long employeeId){


        iServiceEmploye.deleteEmploye(iServiceEmploye.findEmployeById(employeeId));
    }


    @PutMapping("update/{employeeId}")
    public Employe updateEmploye(@Valid @RequestBody Employe employe){
        return iServiceEmploye.updateEmploye(employe);
    }
}
