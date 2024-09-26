package com.spring.granjaporcina.granja.Controller;

import com.spring.granjaporcina.granja.model.PorcinoEntity;
import com.spring.granjaporcina.granja.model.interfaces.InformeSumary;
import com.spring.granjaporcina.granja.service.PorcinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/porcino")
public class PorcinoController {

    private final PorcinoService porcinoService;

    @Autowired
    public PorcinoController(PorcinoService porcinoService) {
        this.porcinoService = porcinoService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<PorcinoEntity>> getAll() {
        return new ResponseEntity<>(this.porcinoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/informe")
    public ResponseEntity<List<InformeSumary>> getInforme() {
        return new ResponseEntity<>(this.porcinoService.findInforme(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PorcinoEntity> get(@PathVariable("id") int idPorcino) {
        return new ResponseEntity<>(this.porcinoService.getPorcino(idPorcino), HttpStatus.OK);
    }

    //---------------POST-----------------//
    @PostMapping
    public ResponseEntity<PorcinoEntity> add(@RequestBody PorcinoEntity porcino){
        if (porcino.getIdPorcino() == null || !this.porcinoService.exist(porcino.getIdPorcino())){
            return new ResponseEntity<>(this.porcinoService.save(porcino), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------PUT-------------------//
    @PutMapping
    public ResponseEntity<PorcinoEntity> update(@RequestBody PorcinoEntity porcino){
        if (porcino.getIdPorcino() != null && this.porcinoService.exist(porcino.getIdPorcino())){
            return new ResponseEntity<>(this.porcinoService.save(porcino), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------DELETE-------------------//
    @DeleteMapping("/{id}")
    public ResponseEntity<PorcinoEntity> delete(@PathVariable("id") int idPorcino){
        if (this.porcinoService.exist(idPorcino)) {
            this.porcinoService.delete(idPorcino);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
