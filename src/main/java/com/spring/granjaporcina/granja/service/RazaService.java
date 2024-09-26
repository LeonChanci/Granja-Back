package com.spring.granjaporcina.granja.service;

import com.spring.granjaporcina.granja.model.RazaEntity;
import com.spring.granjaporcina.granja.model.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaService {
        private final RazaRepository razaRepository;

    @Autowired
    public RazaService(RazaRepository razaRepository) {
        this.razaRepository = razaRepository;
    }

    //---------------GET-----------------//
    public List<RazaEntity> findAll(){
        return this.razaRepository.findAll();
    }
}
