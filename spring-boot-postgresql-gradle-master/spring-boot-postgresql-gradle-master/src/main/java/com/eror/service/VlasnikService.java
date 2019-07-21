package com.eror.service;

import com.eror.dto.VlasnikDTO;
import com.eror.entity.Vlasnik;

import java.util.List;
import java.util.Set;



public interface VlasnikService {

	public Vlasnik Save(Vlasnik vlasnik);

	public Set<Vlasnik> setVlasnika();

	public Vlasnik findVlasnikById(Integer id);

	public List<Vlasnik> findListaVlasnikaByPrezime(String prezime);

	public Vlasnik update(Integer id, Vlasnik vlasnik);

	public void delete(Integer id);

	public VlasnikDTO findVlasnikByDtoId(Integer id);
}
