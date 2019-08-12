package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeCategory;

@Repository
public interface GECategoryRepository extends JpaRepository<GeCategory, Long> {

}
