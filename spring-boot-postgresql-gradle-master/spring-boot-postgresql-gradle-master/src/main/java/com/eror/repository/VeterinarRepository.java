package com.eror.repository;

import com.eror.entity.Veterinar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Set;

public interface VeterinarRepository extends JpaRepository<Veterinar, Integer> {
    @Query("select v from Veterinar v ")
    Collection<Veterinar> findSetVeterinara();
}
