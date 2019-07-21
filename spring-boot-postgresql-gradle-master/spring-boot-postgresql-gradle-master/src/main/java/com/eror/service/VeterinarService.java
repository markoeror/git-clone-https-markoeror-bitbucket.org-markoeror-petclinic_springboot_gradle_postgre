package com.eror.service;

import com.eror.dto.VeterinarDTO;
import com.eror.entity.Veterinar;

import java.util.List;
import java.util.Set;

public interface VeterinarService {

    public VeterinarDTO vratiVeterinaraById(Integer id);
    public List<VeterinarDTO> vratiListuVeterinaraDTO();

}
