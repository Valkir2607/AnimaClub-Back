package com.example.AnimaClub.Controllers;

import com.example.AnimaClub.dto.CompteDTO;
import com.example.AnimaClub.model.Compte;
import com.example.AnimaClub.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping(value = "{id}")
    public ResponseEntity<CompteDTO> findById(@PathVariable int id) throws SQLException{
       CompteDTO compte = compteService.searchById(id);

        if (compte != null) {
            return ResponseEntity.ok().body(compte);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public List<Compte> getAllAccount() throws SQLException{
        return compteService.findAll();
    }

    @PostMapping
    public ResponseEntity<CompteDTO> createAcc(@RequestBody CompteDTO compteDTO) throws SQLException{
        CompteDTO compte = compteService.create(compteDTO);

        if (compte == null) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}