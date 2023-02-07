package com.example.superkassatest.repository;

import com.example.superkassatest.model.Example;
import jakarta.persistence.LockModeType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Example> findById(Long id);
}
