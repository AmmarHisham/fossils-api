package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeSubCategory;

@Repository
public interface GESubCategoryRepository extends JpaRepository<GeSubCategory, Long> {

}
