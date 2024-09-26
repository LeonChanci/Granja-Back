package com.spring.granjaporcina.granja.Controller;

import com.spring.granjaporcina.granja.model.AlimentacionEntity;
import com.spring.granjaporcina.granja.service.AlimentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/alimentacion")
public class AlimentacionController {

    private final AlimentacionService alimentacionService;

    @Autowired
    public AlimentacionController(AlimentacionService alimentacionService) {
        this.alimentacionService = alimentacionService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<AlimentacionEntity>> getAll(){
        return ResponseEntity.ok(this.alimentacionService.findAll());
    }
}
