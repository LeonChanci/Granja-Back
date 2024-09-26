package com.spring.granjaporcina.granja.service;

import com.spring.granjaporcina.granja.model.PorcinoEntity;
import com.spring.granjaporcina.granja.model.interfaces.InformeSumary;
import com.spring.granjaporcina.granja.model.repository.PorcinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcinoService {

    private final PorcinoRepository porcinoRepository;

    @Autowired
    public PorcinoService(PorcinoRepository porcinoRepository) {
        this.porcinoRepository = porcinoRepository;
    }

    //---------------GET-----------------//
    public List<PorcinoEntity> findAll(){
        return this.porcinoRepository.findAll();
    }

    public List<InformeSumary> findInforme(){
        return this.porcinoRepository.findInforme();
    }

    public PorcinoEntity getPorcino(int idPorcino) {
        return this.porcinoRepository.findById(idPorcino).orElse(null);
    }

    //---------------POST-----------------//
    public PorcinoEntity save(PorcinoEntity porcinoEntity){
        return this.porcinoRepository.save(porcinoEntity);
    }

    //--------------DELETE-------------------//
    public void delete(int idPorcino){
        this.porcinoRepository.deleteById(idPorcino);
    }

    //-------------VALIDATE---------------//
    public boolean exist(int idPorcino){
        return this.porcinoRepository.existsById(idPorcino);
    }
}
