package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeSubCategoryPost;

@Repository
public interface GESubCategoryPostRepository extends JpaRepository<GeSubCategoryPost, Long> {

}
