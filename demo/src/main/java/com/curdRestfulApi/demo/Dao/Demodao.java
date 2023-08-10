package com.curdRestfulApi.demo.Dao;

import com.curdRestfulApi.demo.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Demodao extends JpaRepository<Demo, Integer> {
    @Query(value = "SELECT *  FROM demo WHERE name = :name", nativeQuery = true)
    Demo findByname(String name);
}
