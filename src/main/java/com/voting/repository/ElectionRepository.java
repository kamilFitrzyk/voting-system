package com.voting.repository;

import com.voting.models.ElectionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<ElectionData, Long> {
}