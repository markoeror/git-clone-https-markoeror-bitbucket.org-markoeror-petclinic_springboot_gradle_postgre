package com.eror.repository;

import com.eror.entity.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregledRepository extends JpaRepository<Pregled,Integer> {

}
