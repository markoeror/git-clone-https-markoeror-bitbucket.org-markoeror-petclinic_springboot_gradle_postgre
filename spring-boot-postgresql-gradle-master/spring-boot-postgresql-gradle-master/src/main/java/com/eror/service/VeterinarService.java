package com.eror.service;

import com.eror.dto.VeterinarDTO;

import java.util.List;

public interface VeterinarService {

    public VeterinarDTO vratiVeterinaraById(Integer id);
    public List<VeterinarDTO> vratiListuVeterinaraDTO();

    VeterinarDTO dodajLjubimcaVeterinaru(Integer idVeterinara, Integer idLjubimca);
}
