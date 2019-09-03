package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.GeBlog;

@Repository
public interface GEBlogRepository extends JpaRepository<GeBlog, Long> {

}
