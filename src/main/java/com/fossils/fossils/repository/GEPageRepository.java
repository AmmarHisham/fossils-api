package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GePage;

@Repository
public interface GEPageRepository extends JpaRepository<GePage, Long> {

}
