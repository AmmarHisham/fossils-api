package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeSubCategoryDivision;

@Repository
public interface GESubCategoryDivisionRepository extends JpaRepository<GeSubCategoryDivision, Long> {

}
