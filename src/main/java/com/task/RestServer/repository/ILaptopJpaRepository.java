package com.task.RestServer.repository;

import com.task.RestServer.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopJpaRepository extends JpaRepository<Laptop, Long> {
}

