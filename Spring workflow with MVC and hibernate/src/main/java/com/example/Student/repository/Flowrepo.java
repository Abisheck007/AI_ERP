package com.example.Student.repository;

import com.example.Student.model.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Flowrepo extends JpaRepository<Flow,Long> {
    Optional<Flow> findByCourse(String course);
}
