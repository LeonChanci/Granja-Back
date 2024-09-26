package com.spring.granjaporcina.granja.Controller;

import com.spring.granjaporcina.granja.model.RazaEntity;
import com.spring.granjaporcina.granja.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/raza")
public class RazaController {

    private final RazaService razaService;

    @Autowired
    public RazaController(RazaService razaService) {
        this.razaService = razaService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<RazaEntity>> getAll(){
        return ResponseEntity.ok(this.razaService.findAll());
    }
}
