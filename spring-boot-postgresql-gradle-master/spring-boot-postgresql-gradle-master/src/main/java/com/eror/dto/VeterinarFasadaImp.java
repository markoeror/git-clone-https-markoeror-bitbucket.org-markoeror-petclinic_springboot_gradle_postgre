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
    public Veterinar kreirajVeterinara(Veterinar veterinar, Integer idSpecijalizacije, Integer idLjubimca) {
        Specijalnost specijalnost = specijalnostRepository.findOne(idSpecijalizacije);
        if (specijalnost == null) {
            throw new EntityNotFoundException("Specijalnost sa ovim Id-em ne postoji");
        }
        Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
        if (ljubimac == null) {
            throw new EntityNotFoundException("Ljubimac sa ovim Id-em ne postoji");
        }
        veterinar.addLjubimca(ljubimac);
        veterinar.setSpecijalnost(specijalnost);
        veterinarRepository.save(veterinar);
        return veterinar;
    }
}
