package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.service.IServiceAdmin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Admin/")
public class AdministrateurController {


    @Autowired
    IServiceAdmin iServiceAdmin;


    @GetMapping("getAllAdmins")
    public List<Administrateur> getAllAdmin(){
        return iServiceAdmin.getAllAdministrateur();
    }


    @PostMapping("AddAdmin")
    public Administrateur createnewadmin(@Valid @RequestBody Administrateur administrateur){
        return iServiceAdmin.createAdmin(administrateur);
    }

    @PutMapping("/updateAddmin/{id}")
    public Administrateur updateAdmin(@Valid @RequestBody Administrateur administrateur){

        return iServiceAdmin.updateAdministrateur(administrateur);
    }


    @GetMapping("/getAdmin/{id}")
    public Administrateur getAdministrateur(@PathVariable Long id){
                return iServiceAdmin.findAdministrateurById(id);
    }


    @GetMapping("/getAdminByEmail/{Email}")
    public Administrateur getAdministrateurByEmail(@PathVariable String Email){
        return iServiceAdmin.findAdministrateurByEmail(Email);
    }


    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdministrateur(@PathVariable Long id){

        iServiceAdmin.deleteAdministrateur(iServiceAdmin.findAdministrateurById(id));
    }

}
