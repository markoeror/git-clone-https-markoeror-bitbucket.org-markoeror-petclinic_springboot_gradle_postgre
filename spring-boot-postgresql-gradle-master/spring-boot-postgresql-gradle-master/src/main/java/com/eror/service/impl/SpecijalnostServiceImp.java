package com.eror.service.impl;

import com.eror.dto.SpecijalnostDTO;
import com.eror.entity.Specijalnost;
import com.eror.exception.EntityNotFoundException;
import com.eror.mapper.SpecijalnostMapper;
import com.eror.repository.SpecijalnostRepository;
import com.eror.service.SpecijalnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecijalnostServiceImp implements SpecijalnostService {
    private final SpecijalnostRepository specijalnostRepository;
    private final SpecijalnostMapper specijalnostMapper;
    @Autowired
    public SpecijalnostServiceImp(SpecijalnostRepository specijalnostRepository,SpecijalnostMapper specijalnostMapper) {
        this.specijalnostRepository = specijalnostRepository;
        this.specijalnostMapper=specijalnostMapper;
    }

    @Override
    @Transactional
    public Specijalnost kreirajSpecijalnost(Specijalnost specijalnost) {
        return specijalnostRepository.save(specijalnost);
    }

    @Override
    @Transactional
    public List<SpecijalnostDTO> listaSpecijalnost() {
        List<Specijalnost> listaSpec= specijalnostRepository.findAll();
        List<SpecijalnostDTO> listaSpecDTO= new ArrayList<>();
        if(listaSpec.isEmpty()){
            throw new EntityNotFoundException("Ne postoji ni jedana specijalnost");
        }
        for(Specijalnost temp:listaSpec){
            listaSpecDTO.add(specijalnostMapper.toSpecijalnostDto(temp));
        }
        return listaSpecDTO;
    }
}
