package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.GarmentMain;
@Repository
public interface GarMainRepo extends JpaRepository<GarmentMain, Long>{

}
