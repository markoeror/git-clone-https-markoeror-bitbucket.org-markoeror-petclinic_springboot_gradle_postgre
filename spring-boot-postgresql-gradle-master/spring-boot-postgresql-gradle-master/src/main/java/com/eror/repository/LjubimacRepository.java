package com.eror.repository;

import com.eror.entity.Ljubimac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Integer> {

    Ljubimac findLjubimacById(Integer idLjubimca);
}
