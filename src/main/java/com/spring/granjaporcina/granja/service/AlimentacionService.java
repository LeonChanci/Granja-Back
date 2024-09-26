package com.spring.granjaporcina.granja.service;

import com.spring.granjaporcina.granja.model.AlimentacionEntity;
import com.spring.granjaporcina.granja.model.repository.AlimentacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentacionService {

    private final AlimentacionRepository alimentacionRepository;

    @Autowired
    public AlimentacionService(AlimentacionRepository alimentacionRepository) {
        this.alimentacionRepository = alimentacionRepository;
    }

    //---------------GET-----------------//
    public List<AlimentacionEntity> findAll(){
        return this.alimentacionRepository.findAll();
    }
}
