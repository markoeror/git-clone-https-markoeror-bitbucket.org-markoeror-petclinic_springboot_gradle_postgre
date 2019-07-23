package com.eror.service;

import com.eror.dto.VeterinarDTO;

import java.util.List;

public interface VeterinarService {

    VeterinarDTO vratiVeterinaraById(Integer id);

    List<VeterinarDTO> vratiListuVeterinaraDTO();

    VeterinarDTO dodajLjubimcaVeterinaru(Integer idVeterinara, Integer idLjubimca);
}
