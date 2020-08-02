package com.testapp.db.service;

import com.testapp.db.model.PhoneCode;

import java.util.List;
import java.util.regex.Pattern;

public interface PhoneCodeService {

    List<PhoneCode> findByRegExp(Pattern pattern);

    List<PhoneCode> findAll();

    void add(PhoneCode phoneCode);

    void addAll(List<PhoneCode> phoneCodes);

    int deleteByCode(String code);

    int deleteByName(String name);

    // TODO: 01.08.2020:
    //  Поиск всех тел.кодов, удовлетворяющих введенной маске.
}
