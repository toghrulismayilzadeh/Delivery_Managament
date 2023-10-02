package com.div.repository;

import com.div.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository <Driver,Long>{
    Driver findByEmail(String email);
}
