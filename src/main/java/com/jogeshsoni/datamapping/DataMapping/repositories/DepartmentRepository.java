package com.jogeshsoni.datamapping.DataMapping.repositories;

import com.jogeshsoni.datamapping.DataMapping.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
