package com.testapp.db.dao;

import com.testapp.db.model.PhoneCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface PhoneCodeDao extends JpaRepository<PhoneCode, Long> {
    @Modifying
    int deleteByCode(String code);

    @Modifying
    int deleteByName(String name);

    List<PhoneCode> findByCodeContains(String mask);
}
