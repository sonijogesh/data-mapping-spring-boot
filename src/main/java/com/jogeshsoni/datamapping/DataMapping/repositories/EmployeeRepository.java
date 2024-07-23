package com.jogeshsoni.datamapping.DataMapping.repositories;

import com.jogeshsoni.datamapping.DataMapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
