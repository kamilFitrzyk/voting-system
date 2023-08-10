package com.voting.repository;

import com.voting.models.ElectionData;
import com.voting.view.ElectionView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<ElectionData, Long> {
    Optional<ElectionView> findByCode(String code);
    List<ElectionView> findAllByStatus(String status);
}