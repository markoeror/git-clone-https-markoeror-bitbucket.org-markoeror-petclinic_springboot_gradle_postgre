package com.eror.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityErrorResponse;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.mapper.LjubimacMapper;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.service.LjubimacService;
import com.comtrade.service.LjubimacTipService;
import com.comtrade.service.VlasnikService;
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
	public LjubimacDto save(Integer idVlasnika, Integer idLjubimacTip, LjubimacDto ljubimacDto) {
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
		LjubimacDto ljubimacDto1=ljubimacService.save(ljubimac);
		return ljubimacDto1;
	}

}
