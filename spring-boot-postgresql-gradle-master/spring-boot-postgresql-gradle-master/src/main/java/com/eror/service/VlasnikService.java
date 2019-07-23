package com.eror.service;

import com.eror.dto.VlasnikDTO;
import com.eror.entity.Vlasnik;

import java.util.List;
import java.util.Set;


public interface VlasnikService {

    Vlasnik Save(Vlasnik vlasnik);

    Set<Vlasnik> setVlasnika();

    Vlasnik findVlasnikById(Integer id);

    List<Vlasnik> findListaVlasnikaByPrezime(String prezime);

    Vlasnik update(Integer id, Vlasnik vlasnik);

    void delete(Integer id);

    VlasnikDTO findVlasnikByDtoId(Integer id);
}
