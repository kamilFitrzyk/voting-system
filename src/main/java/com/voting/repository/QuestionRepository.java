package com.voting.repository;

import com.voting.models.QuestionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionData, Long> {
}