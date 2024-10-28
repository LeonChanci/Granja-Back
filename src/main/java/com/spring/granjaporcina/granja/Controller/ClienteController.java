package com.spring.granjaporcina.granja.Controller;

import com.spring.granjaporcina.granja.model.ClienteEntity;
import com.spring.granjaporcina.granja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //---------------GET-----------------//
    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> get(@PathVariable("id") String idCliente) {
        return new ResponseEntity<>(this.clienteService.getCliente(idCliente), HttpStatus.OK);
    }

    //---------------POST-----------------//
    @PostMapping
    public ResponseEntity<ClienteEntity> add(@RequestBody ClienteEntity cliente){
        if (cliente.getIdCliente() == null || !this.clienteService.exist(cliente.getIdCliente())){
            return new ResponseEntity<>(this.clienteService.save(cliente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------PUT-------------------//
    @PutMapping
    public ResponseEntity<ClienteEntity> update(@RequestBody ClienteEntity porcino){
        if (porcino.getIdCliente() != null && this.clienteService.exist(porcino.getIdCliente())){
            return new ResponseEntity<>(this.clienteService.save(porcino), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //--------------DELETE-------------------//
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteEntity> delete(@PathVariable("id") String idCliente){
        if (this.clienteService.exist(idCliente)) {
            this.clienteService.delete(idCliente);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
