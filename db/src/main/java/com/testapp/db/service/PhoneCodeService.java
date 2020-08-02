package com.testapp.db.service;

import com.testapp.db.model.PhoneCode;

import java.util.List;
import java.util.regex.Pattern;

public interface PhoneCodeService {

    List<PhoneCode> findByRegExp(Pattern pattern);

    List<PhoneCode> findAll();

    void add(PhoneCode phoneCode);

    void addAll(List<PhoneCode> phoneCodes);

    void delete(String code);


    // TODO: 01.08.2020:
    //  Удаление записи из справочника
    //  Поиск всех тел.кодов, удовлетворяющих введенной маске.

}
