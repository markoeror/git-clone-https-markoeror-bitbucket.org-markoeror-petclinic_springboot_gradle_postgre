package com.eror.repository;

import com.eror.entity.Pregled;
import com.eror.entity.TipPregleda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipPregledaRepository extends JpaRepository<TipPregleda, Integer> {

}
