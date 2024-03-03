package com.competa.competademo.repository;

import com.competa.competademo.entity.Ctype;
import com.competa.competademo.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CtypeRepository extends JpaRepository<Ctype, Long> {

    Optional<Ctype> findByName(String name);

    @Query("select с from Ctype с order by с.id")
    List<Ctype> findAll();

}