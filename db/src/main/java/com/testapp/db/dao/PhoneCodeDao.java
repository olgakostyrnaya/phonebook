package com.testapp.db.dao;

import com.testapp.db.model.PhoneCode;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface PhoneCodeDao extends JpaRepository<PhoneCode, Long> {
    @Modifying
    int deleteByCode(String code);

    @Modifying
    int deleteByName(String name);

    @Modifying
    List<PhoneCode> findByCodeContains(String mask);

    @Modifying
    List<PhoneCode> findByNameContains(String mask);

    @Override
    <S extends PhoneCode> List<S> findAll(Example<S> example);
}
