package com.eror.service;

import java.util.List;

import com.eror.dto.LjubimacDTO;
import com.eror.entity.Ljubimac;

public interface LjubimacService {

	List<Ljubimac> listaLjubimaca();

	LjubimacDTO save(Ljubimac ljubimac);

	void deleteAll(List<LjubimacDTO> lista);

	LjubimacDTO updateLjubimca(LjubimacDTO ljubimacDto, Integer idVlasnika, Integer idLjubimacTip);
}
