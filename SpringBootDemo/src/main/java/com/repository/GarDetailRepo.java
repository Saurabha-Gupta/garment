package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.GarmentDetail;
@Repository
public interface GarDetailRepo extends JpaRepository<GarmentDetail, Long>{

}
