package com.eror.service;


import com.eror.dto.PosetaDto;
import com.eror.dto.VlasnikDTO;

public interface PosetaService {

	public VlasnikDTO vrati(Integer idVlasnika);

	public void deletePoseta(Integer idPosete);

	public PosetaDto update(PosetaDto posetaDto, Integer idLjubimca);

	
	
}
