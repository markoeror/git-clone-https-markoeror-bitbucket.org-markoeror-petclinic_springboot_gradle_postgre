package com.eror.service;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;

import java.util.List;

public interface LjubimacService {

    List<Ljubimac> listaLjubimaca();

    LjubimacDTO save(Ljubimac ljubimac);

    void deleteAll(List<LjubimacDTO> lista);

    LjubimacDTO updateLjubimca(LjubimacDTO ljubimacDto, Integer idVlasnika, Integer idLjubimacTip);
}
