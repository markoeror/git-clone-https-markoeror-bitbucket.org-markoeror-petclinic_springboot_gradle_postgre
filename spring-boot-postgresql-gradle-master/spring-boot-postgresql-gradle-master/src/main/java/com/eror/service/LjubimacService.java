package com.eror.service;

import java.util.List;

import com.eror.dto.LjubimacDto;
import com.eror.entity.Ljubimac;

public interface LjubimacService {

	List<Ljubimac> listaLjubimaca();

	LjubimacDto save(Ljubimac ljubimac);

	void deleteAll(List<LjubimacDto> lista);

	LjubimacDto updateLjubimca(LjubimacDto ljubimacDto, Integer idVlasnika, Integer idLjubimacTip); 
}
