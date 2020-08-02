package com.testapp.db.dao;

import com.testapp.db.model.PhoneCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCodeDao extends JpaRepository<PhoneCode, Long> {
    int deleteByCode(String code);

    int deleteByName(String name);
}
