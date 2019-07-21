package com.eror.dto;

import com.eror.entity.Ljubimac;
import com.eror.entity.LjubimacTip;
import com.eror.entity.Vlasnik;
import com.eror.exception.EntityNotFoundException;
import com.eror.mapper.LjubimacMapper;
import com.eror.service.LjubimacService;
import com.eror.service.LjubimacTipService;
import com.eror.service.VlasnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LjubimacFasadaImp implements LjubimacFasada {
	private final VlasnikService vlasnikService;
	private final LjubimacMapper ljubimacMapper;
	private final LjubimacService ljubimacService;
	private final LjubimacTipService ljubimacTipService;
	
	
	@Autowired
	public LjubimacFasadaImp(VlasnikService vlasnikService, LjubimacMapper ljubimacMapper,
			LjubimacService ljubimacService, LjubimacTipService ljubimacTipService) {
		super();
		this.vlasnikService = vlasnikService;
		this.ljubimacMapper = ljubimacMapper;
		this.ljubimacService = ljubimacService;
		this.ljubimacTipService = ljubimacTipService;
	}



	@Override
	public LjubimacDTO save(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDto) {
		Vlasnik vlasnik= vlasnikService.findVlasnikById(idVlasnika);
		if(vlasnik== null) {
			throw new EntityNotFoundException("Ne postoji vlasnik sa tim Idem "+idVlasnika);
		}
		LjubimacTip ljubimacTip= ljubimacTipService.findLjubimacTipById(idLjubimacTip);
		if(ljubimacTip== null) {
			throw new EntityNotFoundException("Ne postoji tip ljubimca sa tim Idem "+idLjubimacTip );		
		}
		Ljubimac ljubimac= new Ljubimac();
		ljubimac.setIme(ljubimacDto.getNaziv());
		ljubimac.setLjubimacTip(ljubimacTip);
		ljubimac.setVlasnik(vlasnik);
		LjubimacDTO ljubimacDto1=ljubimacService.save(ljubimac);
		return ljubimacDto1;
	}

}
