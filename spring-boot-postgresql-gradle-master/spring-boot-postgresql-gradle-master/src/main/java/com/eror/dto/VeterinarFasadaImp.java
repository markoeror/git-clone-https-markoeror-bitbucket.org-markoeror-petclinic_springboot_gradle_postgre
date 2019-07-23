package com.eror.dto;

import com.eror.entity.Ljubimac;
import com.eror.entity.Specijalnost;
import com.eror.entity.Veterinar;
import com.eror.exception.EntityNotFoundException;
import com.eror.repository.LjubimacRepository;
import com.eror.repository.SpecijalnostRepository;
import com.eror.repository.VeterinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class VeterinarFasadaImp implements VeterinarFasada {
    private final VeterinarRepository veterinarRepository;
    private final LjubimacRepository ljubimacRepository;
    private final SpecijalnostRepository specijalnostRepository;

    @Autowired
    public VeterinarFasadaImp(VeterinarRepository veterinarRepository, SpecijalnostRepository specijalnostRepository, LjubimacRepository ljubimacRepository) {
        this.veterinarRepository = veterinarRepository;
        this.specijalnostRepository = specijalnostRepository;
        this.ljubimacRepository = ljubimacRepository;
    }

    @Override
    @Transactional
    public Veterinar kreirajVeterinara(Veterinar veterinar, Integer idSpecijalizacije) {
        Specijalnost specijalnost = specijalnostRepository.findOne(idSpecijalizacije);
        if (specijalnost == null) {
            throw new EntityNotFoundException("Specijalnost sa ovim Id-em ne postoji");
        }

        veterinar.setSpecijalnost(specijalnost);
        Set<Ljubimac> setLjubimaca = new HashSet<>();
        veterinar.setSetLjubimaca(setLjubimaca);
        veterinarRepository.save(veterinar);

        return veterinar;
    }
}
