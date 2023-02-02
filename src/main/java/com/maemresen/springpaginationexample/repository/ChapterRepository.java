package com.maemresen.springpaginationexample.repository;

import com.maemresen.springpaginationexample.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
