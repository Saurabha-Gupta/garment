package com.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.UsrMain;

@Repository
public interface UserRepository extends CrudRepository<UsrMain, Long>{
	
	UsrMain findByUsername(String userId);
	
}
