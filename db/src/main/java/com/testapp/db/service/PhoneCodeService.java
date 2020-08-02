package com.testapp.db.service;

import com.testapp.db.model.PhoneCode;

import java.util.List;

public interface PhoneCodeService {

    List<PhoneCode> findByCodeContains(String mask);

    List<PhoneCode> findByNameContains(String mask);

    List<PhoneCode> findAll();

    void add(PhoneCode phoneCode);

    void addAll(List<PhoneCode> phoneCodes);

    int deleteByCode(String code);

    int deleteByName(String name);

}
