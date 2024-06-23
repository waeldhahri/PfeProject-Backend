package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.newJWT.Role;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import com.example.pfeprojectbackend.service.IServiceEmploye;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {


    private final IServiceEmploye iServiceEmploye;
    private final EmployeRepository employeRepository;


    @GetMapping("")
    public List<Employe> getAllEmploye(){

        return iServiceEmploye.getAllEmployes();

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employe> getEmployeByEmail(@PathVariable String email){
        return ResponseEntity.ok(iServiceEmploye.findEmployeByEmail(email));
    }



   @GetMapping("/role/{roleName}")
    public List<Employe> getEmployesByRole(@PathVariable String roleName) {
        return iServiceEmploye.findEmployeByRole(roleName);
    }

    @PostMapping("")
    public ResponseEntity<Employe> createEmploye(@Valid @RequestBody Employe employe){

        return ResponseEntity.status(HttpStatus.CREATED).body(iServiceEmploye.createEmploye(employe));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employe> findEmployeById(@PathVariable Long employeeId){

        return ResponseEntity.ok(iServiceEmploye.findEmployeById(employeeId));
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long employeeId){


        iServiceEmploye.deleteEmploye(iServiceEmploye.findEmployeById(employeeId));

        return ResponseEntity.noContent().build();
    }


    @PutMapping("update/{employeeId}")
    public ResponseEntity<Employe> updateEmploye(@Valid @RequestBody Employe employe){
        return ResponseEntity.status(HttpStatus.CREATED).body(iServiceEmploye.updateEmploye(employe));
    }
}
