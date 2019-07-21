package com.eror.service.impl;


import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;
import com.eror.exception.EntityNotFoundException;
import com.eror.mapper.VeterinarMapper;
import com.eror.repository.VeterinarRepository;
import com.eror.service.VeterinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class VeterinarServiceImp implements VeterinarService {
    private final VeterinarRepository veterinarRepository;
    private  final VeterinarMapper veterinarMapper;

    @Autowired
    public VeterinarServiceImp(VeterinarRepository veterinarRepository,VeterinarMapper veterinarMapper) {
        this.veterinarRepository = veterinarRepository;
        this.veterinarMapper=veterinarMapper;
    }
    @Override
    @Transactional
    public VeterinarDTO vratiVeterinaraById(Integer id) {
        Veterinar veterinar = veterinarRepository.findOne(id);
        if(veterinar==null)throw new EntityNotFoundException("Ne postoji veterinar sa datim Id-jem");
        VeterinarDTO veterinarDTO= veterinarMapper.toVeterinarDTO(veterinar);
        return veterinarDTO;
    }

    @Override
    @Transactional
    public List<VeterinarDTO> vratiListuVeterinaraDTO() {
        List<Veterinar>listaVeterinara= veterinarRepository.findAll();
        List<VeterinarDTO>listaVeterDTO= new ArrayList<>();
        for (Veterinar v:listaVeterinara) {
            listaVeterDTO.add(veterinarMapper.toVeterinarDTO(v));

        }
        return listaVeterDTO;
    }


}
