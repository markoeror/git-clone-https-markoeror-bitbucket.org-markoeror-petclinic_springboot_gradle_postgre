package com.eror.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.dto.VlasnikDto;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.mapper.VlasnikMapper;
import com.comtrade.repository.VlasnikRepository;
@Service
public class VlasnikServiceImp implements VlasnikService {
	private final VlasnikRepository vlasnikRepository;
	private final VlasnikMapper vlasnikMapper;
	@Autowired
	public VlasnikServiceImp(VlasnikRepository vlasnikRepository,VlasnikMapper vlasnikMapper) {
		super();
		this.vlasnikRepository = vlasnikRepository;
		this.vlasnikMapper=vlasnikMapper;
	}

	@Override
	@Transactional
	public Vlasnik Save(Vlasnik vlasnik) {		
		return vlasnikRepository.save(vlasnik);
	}

	@Override
	@Transactional
	public Set<Vlasnik> setVlasnika() {
		Set<Vlasnik> setVlasnika=  vlasnikRepository.findAllVlasnici();
		if(setVlasnika.isEmpty()) {
			throw new EntityNotFoundException("Ne postoji ni jedan vlasnik");
		}
		return setVlasnika;
	}

	@Override
	@Transactional
	public Vlasnik findVlasnikById(Integer id) {
		Vlasnik vlasnik= vlasnikRepository.findVlasnikById(id);
		if(vlasnik== null) {
			throw new EntityNotFoundException("Vlasnik sa ovim Id-em ne postoji");
		}
		return vlasnik;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vlasnik> findListaVlasnikaByPrezime(String prezime) {
		List<Vlasnik> listaVlasnika= vlasnikRepository.findListVlasnikaByPrezime(prezime);
		if(listaVlasnika.isEmpty()) {
			throw new EntityNotFoundException("Ne postoji ni jedan vlasnik za dato prezime");
		}
		return listaVlasnika;
	}

	@Override
	@Transactional
	public Vlasnik update(Integer id, Vlasnik vlasnik) {
		Vlasnik vlasnik1= vlasnikRepository.findVlasnikById(id);
		vlasnik.setId(id);
		if(vlasnik1 == null) {
			throw new EntityNotFoundException("Ne postoji ni jedan vlasnik za dati ID");
		}
		vlasnik1= vlasnikRepository.save(vlasnik);
		return vlasnik1;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Vlasnik vlasik= vlasnikRepository.findVlasnikById(id);
		if(vlasik == null) {
			throw new EntityNotFoundException("Ne postoji ni jedan vlasnik za dati ID");
		}
		vlasnikRepository.delete(vlasik);
	}

	@Override
	@Transactional
	public VlasnikDto findVlasnikByDtoId(Integer id) {
		Vlasnik vlasnik= vlasnikRepository.findVlasnikById(id);
		if(vlasnik == null) {
			throw new EntityNotFoundException("Ne postoji ni jedan vlasnik za dati ID");
		}
		
		return vlasnikMapper.toVlasnikDto(vlasnik);
	}

	
}
