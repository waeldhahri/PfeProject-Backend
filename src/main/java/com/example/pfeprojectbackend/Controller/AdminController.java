package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.service.IServiceAdmin;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {


    private final IServiceAdmin iServiceAdmin;


    @GetMapping("")
    public List<Administrateur> getAllAdmin(){
        return iServiceAdmin.getAllAdministrateur();
    }


    @PostMapping("")
    public ResponseEntity<Administrateur> createnewadmin(@Valid @RequestBody Administrateur administrateur){
        return ResponseEntity.status(HttpStatus.CREATED).body(iServiceAdmin.createAdmin(administrateur));
    }

    @PutMapping("/{adminId}")
    public Administrateur updateAdmin(@PathVariable String adminId, @Valid @RequestBody Administrateur administrateur){

        return iServiceAdmin.updateAdministrateur(administrateur);
    }


    @GetMapping("/{adminId}")
    public Administrateur getAdministrateur(@PathVariable Long adminId){
                return iServiceAdmin.findAdministrateurById(adminId);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<Administrateur> getAdministrateurByEmail(@PathVariable String email){
        return ResponseEntity.ok(iServiceAdmin.findAdministrateurByEmail(email));
    }


    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId){

        iServiceAdmin.deleteAdministrateur(iServiceAdmin.findAdministrateurById(adminId));

        return ResponseEntity.noContent().build();
    }

}
