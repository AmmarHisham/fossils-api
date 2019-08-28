package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeSubCategoryDivisionItem;

@Repository
public interface GESubCategoryDivisionItemRepository extends JpaRepository<GeSubCategoryDivisionItem, Long> {

}
