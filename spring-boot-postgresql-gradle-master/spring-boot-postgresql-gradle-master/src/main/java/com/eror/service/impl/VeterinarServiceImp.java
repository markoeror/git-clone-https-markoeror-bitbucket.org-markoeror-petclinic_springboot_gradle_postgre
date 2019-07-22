package com.eror.service.impl;


import com.eror.dto.VeterinarDTO;
import com.eror.entity.Ljubimac;
import com.eror.entity.Veterinar;
import com.eror.exception.EntityNotFoundException;
import com.eror.mapper.VeterinarMapper;
import com.eror.repository.LjubimacRepository;
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
    private final LjubimacRepository ljubimacRepository;

    @Autowired
    public VeterinarServiceImp(VeterinarRepository veterinarRepository,VeterinarMapper veterinarMapper,LjubimacRepository ljubimacRepository) {
        this.veterinarRepository = veterinarRepository;
        this.veterinarMapper=veterinarMapper;
        this.ljubimacRepository=ljubimacRepository;
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
            listaVeterDTO.add(veterinarMapper.toVeterinarDTOPosete(v));

        }
        return listaVeterDTO;
    }

    @Override
    @Transactional
    public VeterinarDTO dodajLjubimcaVeterinaru(Integer idVeterinara, Integer idLjubimca) {
        Veterinar veterinar = veterinarRepository.findOne(idVeterinara);
        if(veterinar==null)throw new EntityNotFoundException("Ne postoji veterinar sa datim Id-jem");
        Ljubimac ljubimac= ljubimacRepository.findOne(idLjubimca);
        if(ljubimac==null)throw new EntityNotFoundException("Ne postoji ljubimac sa datim Id-jem");
        veterinar.addLjubimca(ljubimac);
        VeterinarDTO veterinarDTO= veterinarMapper.toVeterinarDTO(veterinar);
        return veterinarDTO;
    }


}
