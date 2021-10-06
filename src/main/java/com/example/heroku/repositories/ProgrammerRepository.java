package com.example.heroku.repositories;

import com.example.heroku.models.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
}
