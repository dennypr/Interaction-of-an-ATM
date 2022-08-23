package com.knf.dev.repository;

import com.knf.dev.model.Atm;
import com.knf.dev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<Atm, Long> {
    Atm findByEmail(String email);
    Atm findByNorekening(Long rekeningtujuan);
}
