package com.eror.repository;

import com.eror.entity.Poseta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosetaRepository extends JpaRepository<Poseta, Integer> {

    Poseta findPosetaById(Integer idPosete);


}
