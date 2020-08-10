package com.testapp.db.dao;

import com.testapp.db.model.PhoneCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneCodeDao extends JpaRepository<PhoneCode, Long> {

    int deleteByCode(String code);

    int deleteByName(String name);

    List<PhoneCode> findByCodeContains(String mask);
}
