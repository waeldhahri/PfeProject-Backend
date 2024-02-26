package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.service.IServiceEmploye;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Employe/")
public class EmployeeController {


    @Autowired
    IServiceEmploye iServiceEmploye;


    @GetMapping("getall")
    public List<Employe> getAllEmploye(){

        return iServiceEmploye.getAllEmployes();

    }


    @PostMapping("addEmploye")
    public Employe createEmploye(@Valid @RequestBody Employe employe){

        return iServiceEmploye.createEmploye(employe);
    }

    @GetMapping("getEmploye/{id}")
    public Employe findEmployeById(@PathVariable Long id){

        return iServiceEmploye.findEmployeById(id);
    }


    @DeleteMapping("deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable Long id){


        iServiceEmploye.deleteEmploye(iServiceEmploye.findEmployeById(id));
    }


    @PutMapping("update/{id}")
    public Employe updateEmploye(@Valid @RequestBody Employe employe){
        return iServiceEmploye.updateEmploye(employe);
    }
}
